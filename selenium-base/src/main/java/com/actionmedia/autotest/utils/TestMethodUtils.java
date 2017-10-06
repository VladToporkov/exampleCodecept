package com.actionmedia.autotest.utils;

import com.actionmedia.autotest.selenium.SeleniumHolder;
import org.testng.ITestResult;

import java.lang.reflect.Method;

import static org.apache.commons.lang.StringUtils.join;

public final class TestMethodUtils {

    /**
     * private constructor for utils class
     */
    private TestMethodUtils() {
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

    public static String getTestName(final ITestResult test) {
        return getTestName(test.getMethod().getConstructorOrMethod().getMethod(), test.getParameters()) + ".browser." + SeleniumHolder.getDriverName();
    }

    public static String getTestNameNotUI(final ITestResult test) {
        return getTestName(test.getMethod().getConstructorOrMethod().getMethod(), test.getParameters());
    }
}
