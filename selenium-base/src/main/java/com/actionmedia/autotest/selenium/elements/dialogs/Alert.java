package com.actionmedia.autotest.selenium.elements.dialogs;

import com.actionmedia.autotest.selenium.elements.WebContainer;
import com.actionmedia.autotest.selenium.elements.checkers.AlertChecker;

public interface Alert extends WebContainer {
    void clickOk();

    void clickClose();

    String getTitle();

    String getIcon();

    AlertChecker checkAlert();
}
