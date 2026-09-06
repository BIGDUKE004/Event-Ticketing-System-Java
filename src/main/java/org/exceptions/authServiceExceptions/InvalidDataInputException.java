package org.exceptions.authServiceExceptions;

public class InvalidDataInputException extends RuntimeException {
    public InvalidDataInputException(String message) {
        super(message);
    }
}
