package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.elements.Text;
import com.actionmedia.autotest.selenium.elements.checkers.Checker;
import org.openqa.selenium.WebElement;

public class TextImpl extends AbstractElement implements Text {
    protected TextImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public Checker<Element> check() {
        return new Checker<Element>(this, getErrorSender());
    }

    @Override
    public WebElement getWrappedWebElement() {
        return getWrappedElement();
    }
}
