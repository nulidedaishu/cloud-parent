package com.itany.exception;

public class PasswordConfirmationException extends Exception{
    public PasswordConfirmationException() {
    }

    public PasswordConfirmationException(String message) {
        super(message);
    }

    public PasswordConfirmationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordConfirmationException(Throwable cause) {
        super(cause);
    }

    public PasswordConfirmationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
