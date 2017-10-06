package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.screenshots.ScreenshotInfo;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.actionmedia.autotest.Group.backlinks_panel;
import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.getScreenShotPathsForTest;

/**
 * User: n.tyukavkin
 * Date: 21.12.13
 * Time: 10:04
 */
public class BacklinksPanelMailSenderListener implements ISuiteListener, ITestListener {

    private final Log logger = LogFactory.getLog(getClass());

    private static List<String> testsNameList = new ArrayList<String>();

    private static List<File> attachList = new ArrayList<File>();
    private static List<Result> resultList = new ArrayList<Result>();
    private static int counter = 0;

    @Override
    public void onFinish(ISuite suite) {
        if (counter == 0) {

            if (suite.getXmlSuite().getFileName().contains("customsuite.xml")) {
                return;
            }

            Iterator<ISuiteResult> iterator = suite.getResults().values().iterator();
            if (!iterator.hasNext()) {
                return;
            }

            ITestContext context = iterator.next().getTestContext();
            final Properties mailProperties = (Properties) context.getAttribute("mailProperties");
            List<File> fileList = new ArrayList<File>();
            String errorSend = "";

            for (Result result : resultList) {
                fileList.addAll(result.getAttachList());
                errorSend = errorSend + result.getErrorMessage();
            }

            if (fileList.isEmpty()) {
                return;
            }

            if (errorSend.isEmpty()) {
                return;
            }

            sendEmail(mailProperties, errorSend, fileList);

            counter++;
        }
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        if (!isVerifyBacklinksPanelTest(testResult.getMethod())) {
            return;
        }

        String testName = getTestName(testResult);
        List<ScreenshotInfo> screenshotInfoList = getScreenShotPathsForTest(testName);
        List<File> fileList = new ArrayList<File>();
        StringBuilder builder = new StringBuilder();

        builder
                .append("Шаги:")
                .append("\n");

        for (String report : Reporter.getOutput(testResult)) {
            builder
                    .append("\n")
                    .append(report)
                    .append("\n");
        }

        for (ScreenshotInfo screenshotInfo : screenshotInfoList) {
            File file = getAttachFile(screenshotInfo);
            if (isFileExist(file.getName())) {
                continue;
            }

            builder
                    .append("\n")
                    .append(screenshotInfo.getMessage().replaceAll("expected:", "").replaceAll("but", "").replaceAll("was:", ""))
                    .append("\n")
                    .append("_______________________________________________________________________________________________")
                    .append("\n");

            fileList.add(file);
            attachList.add(file);
        }

        Result result = new Result(testName, builder.toString(), fileList);
        resultList.add(result);
    }

    private void sendEmail(final Properties mailProperties, String text, List<File> attachFileList) {
        String from = mailProperties.getProperty("mail.user");
        String to = mailProperties.getProperty("mail.to.backlinks.panel");

        String[] recipientArr = to.split(",");

        String subject = "Проверка панели доп.материалы.";

        Properties props = new Properties();
        props.put("mail.smtp.host", mailProperties.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", mailProperties.getProperty("mail.smtp.port"));
        props.put("mail.smtp.auth", mailProperties.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", mailProperties.getProperty("mail.smtp.starttls.enable"));

        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(mailProperties.getProperty("mail.user"), mailProperties.getProperty("mail.user.password")));
            }
        });

        Message simpleMessage = new MimeMessage(mailSession);

        InternetAddress fromAddress = null;
        InternetAddress[] toAddress = new InternetAddress[recipientArr.length];
        try {
            fromAddress = new InternetAddress(from);

            for (int i = 0; i < recipientArr.length; i++) {
                toAddress[i] = new InternetAddress(recipientArr[i].trim());
            }

        } catch (AddressException e) {
            logger.error("AddressException occurs", e);
        }

        try {
            simpleMessage.setSentDate(new Date());
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipients(Message.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);

            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(text);

            List<MimeBodyPart> attachBodyPartList = new ArrayList<MimeBodyPart>();
            for (File file : attachFileList) {
                MimeBodyPart mbp2 = new MimeBodyPart();
                DataSource fds = new FileDataSource(file);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());

                attachBodyPartList.add(mbp2);
            }

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);

            for (MimeBodyPart bodyPart : attachBodyPartList) {
                mp.addBodyPart(bodyPart);
            }

            simpleMessage.setText(text);
            simpleMessage.setContent(mp);

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            logger.error("MessagingException occurs", e);
        }
    }

    private boolean isFileExist(String fileName) {
        for (File file : attachList) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    private String getTestName(ITestResult testResult) {
        return TestMethodUtils.getTestName(testResult);
    }

    private File getAttachFile(ScreenshotInfo screenshotInfo) {
        File attachmentFile = new File(screenshotInfo.getPath().split("//../")[1]);
        BufferedImage image;
        try {
            image = ImageIO.read(new File(screenshotInfo.getPath()));

            int width = image.getWidth();
            int height;
            if (image.getHeight() < 1080) {
                height = image.getHeight();
            } else {
                height = 1080;
            }
            image = image.getSubimage(0, 0, width, height);
            ImageIO.write(image, "png", attachmentFile);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }
        return attachmentFile;
    }

    private boolean isVerifyBacklinksPanelTest(ITestNGMethod method) {
        for (String group : method.getGroups()) {
            if (group.contains(backlinks_panel)) {
                return true;
            }
        }
        return false;
    }

    private class Result {
        String testName;
        String errorMessage;
        List<File> attachList;

        Result(String testName, String errorMessage, List<File> attachList) {
            this.testName = testName;
            this.errorMessage = errorMessage;
            this.attachList = attachList;
        }

        public String getTestName() {
            return testName;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public List<File> getAttachList() {
            return attachList;
        }
    }

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = getTestName(result);
        if (!testsNameList.contains(testName)) {
            testsNameList.add(testName);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
