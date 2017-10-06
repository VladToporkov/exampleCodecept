package com.actionmedia.autotest.selenium;

import com.actionmedia.autotest.event.postpone.failure.PostponedFailureEvent;
import com.actionmedia.autotest.event.postpone.failure.ScreenshotOnPostponeFailureSubscriber;
import com.actionmedia.autotest.event.postpone.failure.StorePostponeFailureSubscriber;
import com.actionmedia.autotest.listeners.CuantoListener;
import com.actionmedia.autotest.listeners.ProcessPostponedFailureListener;
import com.actionmedia.autotest.listeners.SkipTestListener;
import com.actionmedia.autotest.listeners.TestLinkIntegrationListener;
import com.actionmedia.autotest.screenshots.Screenshoter;
import com.actionmedia.autotest.selenium.context.HelperRegistry;
import com.actionmedia.autotest.selenium.context.IPage;
import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.autotest.spring.SeleniumTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Properties;

import static com.actionmedia.autotest.selenium.SeleniumHolder.getWebDriver;
import static org.testng.Reporter.log;

@TestExecutionListeners(SeleniumTestExecutionListener.class)
@ContextConfiguration(locations = {
        "classpath*:/META-INF/spring/context-selenium.xml",
        "classpath*:/META-INF/spring/testlink.xml",
        "classpath*:/META-INF/spring/mail.xml"
})
@Listeners({
        ProcessPostponedFailureListener.class,
        TestLinkIntegrationListener.class,
        SkipTestListener.class
})
public abstract class AbstractSeleniumTest extends AbstractTestNGSpringContextTests {

    protected ThreadLocal<String> platformForThread = new ThreadLocal<String>() {
        @Override
        public String initialValue() {
            return "";
        }
    };

    protected ThreadLocal<String> pubNameForThread = new ThreadLocal<String>() {
        @Override
        public String initialValue() {
            return "";
        }
    };

    @Autowired
    private HelperRegistry registry;

    @Autowired
    private SeleniumSettings settings;

    @Autowired
    private ParamsProvider parameterProvider;

    @Autowired
    private ParamsProvider parameterProviderForGroup;

    @Autowired
    private PostponedFailureEvent postponeFailureEvent;

    @Qualifier("testLinkInfo")
    @Autowired
    private Properties testLinkInfo;

    @Qualifier("mailProperties")
    @Autowired
    private Properties mailProperties;

    public ParamsProvider getParameterProviderForGroup() {
        return parameterProviderForGroup;
    }

    @BeforeMethod(alwaysRun = true)
    public final void beforeMethod(final Method test, final Object[] params, final ITestContext context) {
        postponeFailureEvent.subscribe(new ScreenshotOnPostponeFailureSubscriber(test, params));
        postponeFailureEvent.subscribe(new StorePostponeFailureSubscriber(test, params, context));
    }

    @AfterMethod(alwaysRun = true)
    public final void afterMethod() {
        parameterProvider.clear();
        postponeFailureEvent.unsubscribeAll();
    }

    @BeforeMethod(alwaysRun = true)
    public final void setTestLinkInfo(final ITestContext context) {
        context.setAttribute("testLinkInfo", testLinkInfo);
        context.setAttribute("mailProperties", mailProperties);
    }

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public final void setBrowserForGrid(@Optional("browser") String browser) {
        SeleniumHolder.setParameterBrowserName(browser);
    }

    @BeforeTest(alwaysRun = true)
    @Parameters("platform")
    public final void setPlatform(@Optional("platform") String platform, ITestContext context) {
        platformForThread.set(platform);
        context.setAttribute("platform", platform);
    }

    public <E extends IPage> E getPage(final Class<E> helperClass) {
        E helper = registry.getPageHelper(helperClass);
        helper.init(getWebDriver());
        helper.load(settings.createUrl());
        return helper;
    }

    public <E extends IPage> E getPage(final Class<E> helperClass, final String path) {
        E helper = registry.getPageHelper(helperClass);
        helper.init(getWebDriver());
        helper.load(path);
        return helper;
    }

    protected SeleniumSettings getSettings() {
        return settings;
    }

    protected final Object getParameter(final String key) {
        return parameterProvider.get(key);
    }

    protected void setParameter(final String key, final Object value) {
        parameterProvider.put(key, value);
    }

    protected final Object getParameterForGroup(final String key) {
        return parameterProviderForGroup.get(key);
    }

    protected void setParameterForGroup(final String key, final Object value) {
        parameterProviderForGroup.put(key, value);
    }

    public void setPostponedTestFail(final String message) {
        postponeFailureEvent.fire(message);
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        super.run(callBack, testResult);
        if (testResult.getThrowable() != null) {
            takeScreenshot(testResult);
        }
    }

    private void takeScreenshot(final ITestResult testResult) {
        try {
            new Screenshoter().takeScreenshot(testResult);
        } catch (Exception e) {
            logger.error("Exception e", e);
            log("Couldn't take screenshot. Error: " + e.getMessage());
        }
    }

    public void takeScreenshot(final String errorMessage, final String testName) {
        try {
            new Screenshoter().takeScreenshot(errorMessage, testName);
        } catch (Exception e) {
            logger.error("Exception e", e);
            log("Couldn't take screenshot. Error: " + e.getMessage());
        }
    }
}
