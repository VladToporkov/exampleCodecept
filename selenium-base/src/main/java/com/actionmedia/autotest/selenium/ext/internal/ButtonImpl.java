package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.Button;
import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractEnabledElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }

    @Override
    public boolean isClickable() {
        return isEnabled();
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }
}