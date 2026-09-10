package com.eventTickettingSystem.util;

import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;

public class Validator {

    public static void validateEventRequest(CreateEventRequest request){
        if(request.getName().isEmpty())
            throw new IllegalArgumentException("name cannot be empty");
        if(request.getName().isBlank())
            throw new IllegalArgumentException("name cannot be blank");
        if(request.getDescription().isEmpty())
            throw new IllegalArgumentException("description cannot be empty");
        if(request.getDescription().isBlank())
            throw new IllegalArgumentException("description cannot be blank");
    }
}
