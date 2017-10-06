package com.actionmedia.autotest.event.postpone.failure;

import com.actionmedia.autotest.screenshots.Screenshoter;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.actionmedia.autotest.utils.TestMethodUtils.getTestName;
import static org.testng.Reporter.log;

public class ScreenshotOnPostponeFailureSubscriber extends PostponeFailureSubscriber {
    private final String testName;
    private final Screenshoter screenshoter = new Screenshoter();
    private int failures = 0;
    private boolean isRunMoreThanOne;
    private final Log logger = LogFactory.getLog(getClass());

    public ScreenshotOnPostponeFailureSubscriber(final Method test, final Object[] params) {
        final Test testAnnotation = test.getAnnotation(Test.class);
        isRunMoreThanOne = testAnnotation.invocationCount() > 1;
        testName = getTestName(test, params);
    }

    @Override
    public void notify(final String message) {
        try {
            if (isRunMoreThanOne) {
                screenshoter.takeScreenshot(message, String.format("%s.%d.%s.%s", testName, ++failures, "browser." + SeleniumHolder.getDriverName(), RandomStringUtils.randomAlphabetic(5)));
            } else {
                screenshoter.takeScreenshot(message, String.format("%s.%d.%s", testName, ++failures, "browser." + SeleniumHolder.getDriverName()));
            }
        } catch (Exception e) {
            logger.error("Exception occurs", e);
            log("Couldn't take screenshot. Error: " + e.getMessage());
        }
    }

    @Override
    public void notifyWithoutScreen(String message) {
    }
}
