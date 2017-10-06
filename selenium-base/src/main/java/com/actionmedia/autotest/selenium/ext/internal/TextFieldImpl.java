package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.TextField;
import org.openqa.selenium.WebElement;

class TextFieldImpl extends AbstractEnabledElement implements TextField {
    protected TextFieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String value) {
        getWrappedElement().sendKeys(value);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }

    @Override
    public void clearAndType(final String value) {
        clear();
        type(value);
    }
}
