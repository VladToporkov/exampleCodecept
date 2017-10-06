package com.actionmedia.autotest.event.postpone.failure;

public class PostponedFailureException extends AssertionError {
    public PostponedFailureException(final String message) {
        super(message);
    }
}
