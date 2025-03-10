package com.itany.exception;

public class ServerCompanyExistException extends Exception{
    public ServerCompanyExistException() {
    }

    public ServerCompanyExistException(String message) {
        super(message);
    }

    public ServerCompanyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerCompanyExistException(Throwable cause) {
        super(cause);
    }

    public ServerCompanyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
