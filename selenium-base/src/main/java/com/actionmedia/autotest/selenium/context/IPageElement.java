package com.actionmedia.autotest.selenium.context;

import org.openqa.selenium.WebDriver;

public interface IPageElement {
    void init(WebDriver driver);

    void handleRedirect();

    ErrorSender getErrorSender();
}
