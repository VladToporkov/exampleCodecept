package com.actionmedia.autotest.selenium.elements;

import com.actionmedia.autotest.selenium.context.ErrorSender;
import org.openqa.selenium.WebElement;

public abstract class AbstractWebContainer implements WebContainer {

    @DoNotSearch
    private WebElement wrappedElement;
    private ErrorSender errorSender;

    @Override
    public void init(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    public ErrorSender getErrorSender() {
        return errorSender;
    }

    @Override

    public final boolean isVisible() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public void setErrorSender(final ErrorSender errorSender) {
        this.errorSender = errorSender;
    }

    @Override
    public WebElement getWrappedWebElement() {
        return wrappedElement;
    }
}
