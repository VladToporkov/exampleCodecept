package com.actionmedia.autotest.selenium.elements.checkers;

import com.actionmedia.autotest.selenium.context.ErrorSender;
import com.actionmedia.autotest.selenium.elements.dialogs.Alert;

public class AlertChecker extends Checker<Alert> {

    public AlertChecker(final Alert alert, final ErrorSender errorSender) {
        super(alert, errorSender);
    }
}
