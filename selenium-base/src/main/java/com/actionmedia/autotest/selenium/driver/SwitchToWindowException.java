package com.actionmedia.autotest.selenium.driver;

public class SwitchToWindowException extends RuntimeException {
    public SwitchToWindowException() {
    }

    public SwitchToWindowException(String message) {
        super(message);
    }

    public SwitchToWindowException(String message, Throwable cause) {
        super(message, cause);
    }
}
