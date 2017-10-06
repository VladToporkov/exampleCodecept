package com.actionmedia.autotest.selenium.elements;

import com.actionmedia.autotest.selenium.context.ErrorSender;
import org.openqa.selenium.WebElement;

public interface Element {
    boolean isVisible();

    String getText();

    @Deprecated
    void setErrorSender(ErrorSender errorSender);

    WebElement getWrappedWebElement();
}
