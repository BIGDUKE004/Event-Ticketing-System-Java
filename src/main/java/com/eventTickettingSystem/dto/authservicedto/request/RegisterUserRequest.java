package com.eventTickettingSystem.dto.authservicedto.request;

import lombok.Data;

import java.util.Random;
@Data
public class RegisterUserRequest {
    String name;
    String email;
    String password;
}
