package com.util;

import com.data.models.User;
import com.dto.authservicedto.request.RegisterUserRequest;

public class Mapper {
    public static User mapToUser(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setId(registerUserRequest.getId());
        user.setEmail(registerUserRequest.getEmail());
        user.setName(registerUserRequest.getName());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

}
