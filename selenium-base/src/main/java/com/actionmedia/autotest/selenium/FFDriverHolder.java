package com.actionmedia.autotest.selenium;

import org.openqa.selenium.WebDriver;

public class FFDriverHolder {

    private static ThreadLocal<FFDriverProvider> firefoxDriverProvider = new ThreadLocal<FFDriverProvider>();

    public static WebDriver getFirefoxDriver() {
        return firefoxDriverProvider.get().getDriver();
    }

    public static void setFirefoxDriverProvider(FFDriverProvider firefoxDriver) {
        firefoxDriverProvider.set(firefoxDriver);
    }

    public interface FFDriverProvider {

        WebDriver getDriver();
    }
}
