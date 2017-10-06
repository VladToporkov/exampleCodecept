package com.actionmedia.autotest.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static java.lang.String.format;

public class ReportTestInvocationListener implements IInvokedMethodListener {

    private final Log logger = LogFactory.getLog(getClass());
    private static ThreadLocal<Integer> startCounter = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> finishCounter = new ThreadLocal<Integer>();

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (startCounter.get() == null) {
            startCounter.set(0);
        } else if (startCounter.get() == 1) {
            return;
        }
        log(format("%s was started", testName(testResult)));
        startCounter.set(startCounter.get() + 1);
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (finishCounter.get() == null) {
            finishCounter.set(0);
        } else if (finishCounter.get() == 1) {
            return;
        }
        log(format("%s was finished", testName(testResult)));
        finishCounter.set(finishCounter.get() + 1);
    }

    private String testName(final ITestResult testResult) {
        return format("%s.%s", testResult.getTestClass().getRealClass().getSimpleName(), testResult.getName());
    }

    private void log(final String message) {
        System.out.println(message);
        Reporter.log(message);
        logger.info(message);
    }
}
