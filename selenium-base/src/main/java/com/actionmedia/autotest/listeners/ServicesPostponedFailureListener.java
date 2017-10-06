package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.event.postpone.failure.PostponedFailureException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.List;

import static com.actionmedia.autotest.event.postpone.failure.ServicesPostponedErrorMessageHolder.getErrorMessageListForTest;
import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.join;
import static org.testng.ITestResult.FAILURE;

public class ServicesPostponedFailureListener implements IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {
        final String testName = getTestName(testResult);
        final Boolean failed = (Boolean) context.getAttribute(format("%s postpone fail", testName));
        if (failed != null && failed) {
            testResult.setStatus(FAILURE);
            testResult.setThrowable(new PostponedFailureException(getErrorMessage(testName)));
        }
    }

    private String getErrorMessage(final String testName) {
        final StringBuilder result = new StringBuilder();
        final List<String> messageList = getErrorMessageListForTest(testName);
        for (String message : messageList) {
            result.append(message).append("\r").append("\n");
        }

        return result.toString();
    }

    public static String getTestName(final ITestResult test) {
        return getTestName(test.getMethod().getConstructorOrMethod().getMethod(), test.getParameters());
    }

    public static String getTestName(final Method test, final Object[] params) {
        final StringBuilder testName = new StringBuilder();
        testName.append(test.getDeclaringClass().getSimpleName())
                .append('.')
                .append(test.getName());

        if (params.length > 0) {
            testName.append('(')
                    .append(join(params, ','))
                    .append(')');
        }
        return testName.toString();
    }

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }
}
