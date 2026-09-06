package org;

import org.dto.authservicedto.reponse.RegisterUserResponse;
import org.dto.authservicedto.request.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.service.AuthServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthServiceImplementation service;

    @Test
    public void testThatUserCreatesAnAccount(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("mirjsdunf");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());
    }
}
