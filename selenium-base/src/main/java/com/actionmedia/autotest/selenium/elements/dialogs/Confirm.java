package com.actionmedia.autotest.selenium.elements.dialogs;

import com.actionmedia.autotest.selenium.elements.Button;
import com.actionmedia.autotest.selenium.elements.checkers.ConfirmChecker;

public interface Confirm extends Alert {
    void clickTopClose();

    Button getContinue();

    Button getCancel();

    ConfirmChecker checkConfirm();
}
