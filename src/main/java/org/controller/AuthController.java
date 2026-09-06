package org.controller;

import org.dto.authservicedto.reponse.LogOutUserResponse;
import org.dto.authservicedto.reponse.LoginUserResponse;
import org.dto.authservicedto.reponse.RegisterUserResponse;
import org.dto.authservicedto.request.LogOutUserRequest;
import org.dto.authservicedto.request.LoginUserRequest;
import org.dto.authservicedto.request.RegisterUserRequest;
import org.service.AuthServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
public class AuthController {
    @Autowired
    private AuthServiceImplementation service;

    @PostMapping("/Register")
    public RegisterUserResponse registerUser (RegisterUserRequest request){
        return this.service.registerUser(request);
    }

    @GetMapping("/Login")
    public LoginUserResponse registerUser (LoginUserRequest request){
        return this.service.loginUser(request);
    }

    @GetMapping("/Login")
    public LogOutUserResponse registerUser (LogOutUserRequest request){
        return this.service.logoutUser(request);
    }
}
