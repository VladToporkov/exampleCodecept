package com.actionmedia.autotest.event.postpone.failure;

import org.testng.ITestContext;
import org.testng.Reporter;

import java.lang.reflect.Method;

import static com.actionmedia.autotest.event.postpone.failure.ServicesPostponedErrorMessageHolder.addErrorMessageForTest;
import static com.actionmedia.autotest.utils.TestMethodUtils.getTestName;
import static java.lang.String.format;

public class StorePostponeFailureSubscriber extends PostponeFailureSubscriber {
    private final String testName;
    private final ITestContext context;

    public StorePostponeFailureSubscriber(final Method test, final Object[] params, final ITestContext context) {
        testName = getTestName(test, params);
        this.context = context;
    }

    @Override
    public void notify(final String message) {
        Reporter.log(message);
        context.setAttribute(format("%s postpone fail", testName), true);
        addErrorMessageForTest(testName, message);
    }

    @Override
    public void notifyWithoutScreen(String message) {
        Reporter.log(message);
        context.setAttribute(format("%s postpone fail", testName), true);
        addErrorMessageForTest(testName, message);
    }
}
