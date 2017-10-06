package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.context.ErrorSender;
import com.actionmedia.autotest.selenium.elements.Element;
import org.openqa.selenium.WebElement;

abstract class AbstractElement implements Element {
    private final WebElement wrappedElement;
    private ErrorSender errorSender;

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    public ErrorSender getErrorSender() {
        return errorSender;
    }

    protected AbstractElement(final WebElement element) {
        this.wrappedElement = element;
    }

    @Override
    public boolean isVisible() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public void setErrorSender(ErrorSender sender) {
        this.errorSender = sender;
    }

    @Override
    public WebElement getWrappedWebElement() {
        return wrappedElement;
    }

    public Object check() {
        return null;
    }
}
