package com.eventTickettingSystem.exceptions.authServiceExceptions;

public class InvalidDataInputException extends RuntimeException {
    public InvalidDataInputException(String message) {
        super(message);
    }
}
