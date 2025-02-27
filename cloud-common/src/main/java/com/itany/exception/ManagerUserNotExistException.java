package com.itany.exception;

public class ManagerUserNotExistException extends Exception {
    public ManagerUserNotExistException() {
    }

    public ManagerUserNotExistException(String message) {
        super(message);
    }

    public ManagerUserNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerUserNotExistException(Throwable cause) {
        super(cause);
    }

    public ManagerUserNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
