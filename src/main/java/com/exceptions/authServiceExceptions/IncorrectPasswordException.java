package com.exceptions.authServiceExceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String invalidCredentials) {
        super(invalidCredentials);
    }
}
