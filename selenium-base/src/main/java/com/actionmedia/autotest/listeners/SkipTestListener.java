package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.Group;
import com.actionmedia.autotest.spring.SeleniumSettings;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class SkipTestListener implements IInvokedMethodListener {

    private static final ClassPathXmlApplicationContext APPLICATION_CONTEXT = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/context-selenium.xml"});
    private static final SeleniumSettings SELENIUM_SETTINGS = APPLICATION_CONTEXT.getBean(SeleniumSettings.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (SELENIUM_SETTINGS.isRunProduction() && isNoGroupTest(iTestResult, Group.noProduction)) {
            throw new SkipException("Test skipped because of noProduction group");
        }

        if (SELENIUM_SETTINGS.isRunWeb13() && isNoGroupTest(iTestResult, Group.noWeb13)) {
            throw new SkipException("Test skipped because of noWeb13 group");
        }

        if ((SELENIUM_SETTINGS.isRunRT() || SELENIUM_SETTINGS.isRunTbd()) && isNoGroupTest(iTestResult, Group.noRT)) {
            throw new SkipException("Test skipped because of noRT group");
        }

        if (SELENIUM_SETTINGS.isRunProk1() && isNoGroupTest(iTestResult, Group.noProk)) {
            throw new SkipException("Test skipped because of noProk group");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    private boolean isNoGroupTest(ITestResult iTestResult, String noGroupName) {
        String[] groups = iTestResult.getMethod().getGroups();
        for (String group : groups) {
            if (group.equals(noGroupName)) {
                return true;
            }
        }
        return false;
    }
}