package com.actionmedia.autotest.spring;

import com.actionmedia.autotest.annotations.FireFoxOnly;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

    @Override
    public void beforeTestMethod(TestContext context) throws Exception {
        FireFoxOnly fireFoxOnly = context.getTestMethod().getAnnotation(FireFoxOnly.class);
        SeleniumSettings settings = getSeleniumSettings(context);
        new WebDriverFactory(settings).createDriver(fireFoxOnly != null);
    }

    private SeleniumSettings getSeleniumSettings(final TestContext context) {
        return context.getApplicationContext().getBean(SeleniumSettings.class);
    }
}
