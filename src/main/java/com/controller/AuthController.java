package com.controller;

import com.dto.authservicedto.reponse.LogOutUserResponse;
import com.dto.authservicedto.reponse.LoginUserResponse;
import com.dto.authservicedto.reponse.RegisterUserResponse;
import com.dto.authservicedto.request.LogOutUserRequest;
import com.dto.authservicedto.request.LoginUserRequest;
import com.dto.authservicedto.request.RegisterUserRequest;
import com.service.AuthServiceImplementation;
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
    public LoginUserResponse loginUser (LoginUserRequest request){
        return this.service.loginUser(request);
    }

    @GetMapping("/Logout")
    public LogOutUserResponse logOutUser (LogOutUserRequest request){
        return this.service.logoutUser(request);
    }
}
