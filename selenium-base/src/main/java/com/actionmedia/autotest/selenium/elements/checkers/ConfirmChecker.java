package com.actionmedia.autotest.selenium.elements.checkers;

import com.actionmedia.autotest.selenium.context.ErrorSender;
import com.actionmedia.autotest.selenium.elements.Button;
import com.actionmedia.autotest.selenium.elements.dialogs.Confirm;
import org.testng.Reporter;

import static com.actionmedia.autotest.utils.StringUtils.deleteHyphens;

public class ConfirmChecker extends Checker<Confirm> {

    public ConfirmChecker(final Confirm confirm, final ErrorSender errorSender) {
        super(confirm, errorSender);
    }

    private void textInButton(final Button button, final String buttonText) throws AssertionError {
        if (!textByNoThrow(buttonText)) {
            final String errorMessage = "ERROR: " + button.getClass().getSimpleName() + " contains '" + button.getText() +
                    "' text instead of '" + buttonText + "'";
            Reporter.log(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    private void textInButtonByPostponedFail(final Button button, final String buttonText) throws AssertionError {
        if (getErrorSender() != null) {
            if (!textInButtonByNoThrow(button, buttonText)) {
                final String errorMessage = "ERROR: " + button.getClass().getSimpleName() + " contains '" + getElement().getText() +
                        "' text instead of '" + buttonText + "'";
                getErrorSender().setPostponedTestFail(errorMessage);
            }
        } else {
            textInButton(button, buttonText);
        }
    }

    private boolean textInButtonByNoThrow(final Button button, final String nameOfTheTab) {
        return nameOfTheTab.equalsIgnoreCase(deleteHyphens(button.getText()));
    }

    public void textInSaveButton(final String buttonText) throws AssertionError {
        textInButton(getElement().getContinue(), buttonText);
    }

    public void textInCancelButton(final String buttonText) throws AssertionError {
        textInButton(getElement().getCancel(), buttonText);
    }

    public void textInSaveButtonByPostponedFail(final String buttonText) throws AssertionError {
        textInButtonByPostponedFail(getElement().getContinue(), buttonText);
    }

    public void textInCancelButtonByPostponedFail(final String buttonText) throws AssertionError {
        textInButtonByPostponedFail(getElement().getCancel(), buttonText);
    }
}
