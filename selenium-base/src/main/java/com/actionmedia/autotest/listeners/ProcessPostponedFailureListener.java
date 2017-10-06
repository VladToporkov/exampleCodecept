package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.event.postpone.failure.PostponedFailureException;
import com.actionmedia.autotest.screenshots.ScreenshotInfo;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.List;

import static com.actionmedia.autotest.event.postpone.failure.ServicesPostponedErrorMessageHolder.getErrorMessageListForTest;
import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.getScreenShotPathsForTest;
import static com.actionmedia.autotest.utils.TestMethodUtils.getTestName;
import static java.lang.String.format;
import static org.testng.ITestResult.FAILURE;

public class ProcessPostponedFailureListener implements IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {
        final String testName = getTestName(testResult).split(".browser")[0];
        final Boolean failed = (Boolean) context.getAttribute(format("%s postpone fail", testName));
        if (failed != null && failed) {
            testResult.setStatus(FAILURE);
            testResult.setThrowable(new PostponedFailureException(getErrorMessage(testName)));
        }
    }

    private String getErrorMessage(final String testName) {
        final StringBuilder result = new StringBuilder();
        final List<ScreenshotInfo> screenshotInfoList = getScreenShotPathsForTest(testName);
        final List<String> errorMessageListForTest = getErrorMessageListForTest(testName);
        if (!screenshotInfoList.isEmpty()) {
            for (ScreenshotInfo screenshotInfo : screenshotInfoList) {
                result.append(screenshotInfo.getMessage()).append("\r").append("\n");
            }
        } else {
            for (String message : errorMessageListForTest) {
                result.append(message).append("\r").append("\n");
            }
        }

        return result.toString();
    }

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }
}
