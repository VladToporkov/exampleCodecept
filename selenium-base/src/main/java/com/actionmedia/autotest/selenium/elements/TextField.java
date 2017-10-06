package com.actionmedia.autotest.selenium.elements;

public interface TextField extends EnabledElement {
    void type(final String value);

    void clear();

    void clearAndType(final String value);
}
