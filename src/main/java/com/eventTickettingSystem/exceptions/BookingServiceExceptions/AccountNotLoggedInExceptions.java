package com.eventTickettingSystem.exceptions.BookingServiceExceptions;

public class AccountNotLoggedInExceptions extends RuntimeException{
    public AccountNotLoggedInExceptions(String message){
        super(message);
    }
}
