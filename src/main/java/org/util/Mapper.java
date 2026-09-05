package org.util;

import jdk.jfr.Registered;
import org.data.models.User;
import org.dto.authServiceDto.Request.RegisterUserRequest;

public class Mapper {
    public User mapToUser(RegisterUserRequest request){
        User user = new User();
        user.setId(request.getId());
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        return user;
    }
}
