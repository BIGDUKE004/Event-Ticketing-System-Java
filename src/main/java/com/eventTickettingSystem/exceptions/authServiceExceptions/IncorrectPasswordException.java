package com.eventTickettingSystem.exceptions.authServiceExceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String invalidCredentials) {
        super(invalidCredentials);
    }
}
