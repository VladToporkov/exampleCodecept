package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.EnabledElement;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

abstract class AbstractEnabledElement extends AbstractElement implements EnabledElement {

    protected final Log logger = LogFactory.getLog(getClass());

    protected AbstractEnabledElement(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public boolean isEnabled() {
        return getWrappedElement().isEnabled();
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }
}
