package com.eventTickettingSystem.exceptions.authServiceExceptions;

public class InvalidPasswordLength extends RuntimeException {
    public InvalidPasswordLength(String message) {
        super(message);
    }
}
