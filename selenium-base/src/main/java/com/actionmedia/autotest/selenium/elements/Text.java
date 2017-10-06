package com.actionmedia.autotest.selenium.elements;

import com.actionmedia.autotest.selenium.elements.checkers.Checker;

public interface Text extends Element {
    Checker<Element> check();
}
