package com.exceptions.BookingServiceExceptions;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String message){
        super(message);
    }
}
