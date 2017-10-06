package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.CheckBox;
import org.openqa.selenium.WebElement;

class CheckBoxImpl extends AbstractEnabledElement implements CheckBox {
    protected CheckBoxImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }

    @Override
    public boolean isClickable() {
        return isEnabled() && isSelected();
    }

    @Override
    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }
}