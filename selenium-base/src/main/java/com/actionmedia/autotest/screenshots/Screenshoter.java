package com.actionmedia.autotest.screenshots;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.addScreenShotPathForTest;
import static com.actionmedia.autotest.selenium.SeleniumHolder.getWebDriver;
import static com.actionmedia.autotest.utils.TestMethodUtils.getTestName;

public class Screenshoter {

    private final Log logger = LogFactory.getLog(getClass());

    public void takeScreenshot(String errorMessage, final String testName) {
        try {
            final File screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);

            errorMessage = removeTags(errorMessage);

            final BufferedImage image = ImageIO.read(screenShot);
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            String currentTime = new DateTime().toString(dateTimeFormatter);
            printStrings(image, removeNL(testName, errorMessage, currentTime));

            final String pathName = filenameFor(testName);
            File screenshotWithMessage = new File(pathName);
            ImageIO.write(image, "png", screenshotWithMessage);
            String originalTestName = getOriginalTestName(testName);
            addScreenshotToAllureReport(errorMessage, originalTestName, screenshotWithMessage);
            addScreenShotPathForTest(originalTestName, pathName, errorMessage);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        } catch (WebDriverException e) {
            logger.error("WebDriverException occurs", e);
        }
    }

    @Attachment(value = "{0} : {1}", type = "image/png")
    private byte[] addScreenshotToAllureReport(String errorMessage, String testName, File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    public void takeScreenshot(final ITestResult testResult) {
        final Throwable testResultThrowable = testResult.getThrowable();
        String message = testResultThrowable.getMessage() != null ? testResultThrowable.getMessage() :
                testResultThrowable.getCause().getMessage();

        if (message == null) {
            message = "Test failed";
        }

        takeScreenshot(message, getTestName(testResult));
    }

    public void takeScreenshotForComparison(final String path, final String name) {
        try {
            final File screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            final BufferedImage image = ImageIO.read(screenShot);

            final String pathName = path + "\\" + name;
            ImageIO.write(image, "png", new File(pathName));
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }
    }

    public void takeScreenshotForComparison(final WebElement element, final String path, final String name) {
        try {
            final File screenShot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            final BufferedImage fullImage = ImageIO.read(screenShot);

            org.openqa.selenium.Point point = element.getLocation();

            int eleWidth = element.getSize().getWidth();
            int eleHeight = element.getSize().getHeight();

            BufferedImage eleScreenshot = fullImage.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", screenShot);

            final String pathName = path + "\\" + name;
            FileUtils.copyFile(screenShot, new File(pathName));
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }
    }

    private Collection<String> removeNL(final String... strings) {
        final Collection<String> result = new ArrayList<String>();
        for (final String each : strings) {
            if (each != null) {
                result.addAll(Arrays.asList(each.split("\n")));
            }
        }
        return result;
    }

    private void printStrings(final BufferedImage image, final Collection<String> lines) {
        final Graphics g = image.getGraphics();

        final Font font = new Font("Tahoma", Font.PLAIN, 18);
        g.setFont(font);
        g.setColor(Color.red);
        g.setFont(font);

        int y = 575;
        for (final String line : lines) {
            g.drawString(line, 25, y);
            y += 25;
        }
    }

    private String filenameFor(final String currentTest) {
        return String.format("%s/../%s.png", getClass().getResource("/").getFile(), currentTest);
    }

    private String getOriginalTestName(final String testName) {
        final Pattern pattern = Pattern.compile("(.+?)(\\.\\d+)?");
        final Matcher matcher = pattern.matcher(testName);
        if (matcher.matches()) {
            return matcher.group(1);
        }

        return testName;
    }

    private String removeTags(String errMsg) {
        return errMsg.replaceAll("<.*?>", "");
    }
}
