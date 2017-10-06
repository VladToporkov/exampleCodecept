package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.Link;
import org.openqa.selenium.WebElement;

class LinkImpl extends AbstractElement implements Link {
    protected LinkImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }

    @Override
    public boolean isClickable() {
        return true;
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }
}
