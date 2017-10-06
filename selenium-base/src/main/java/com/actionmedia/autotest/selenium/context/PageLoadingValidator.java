package com.actionmedia.autotest.selenium.context;

import org.openqa.selenium.WebDriver;

public interface PageLoadingValidator {
    void assertLoaded(WebDriver driver);
}
