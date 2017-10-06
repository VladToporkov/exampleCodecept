package com.actionmedia.autotest.selenium.ext;

import com.actionmedia.autotest.selenium.elements.Element;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <T extends Element> T create(Class<T> classOfElement, WebElement wrappedElement);
}
