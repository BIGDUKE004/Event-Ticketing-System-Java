package com.eventTickettingSystem.service;

import com.eventTickettingSystem.dto.authservicedto.reponse.LogOutUserResponse;
import com.eventTickettingSystem.dto.authservicedto.reponse.LoginUserResponse;
import com.eventTickettingSystem.dto.authservicedto.reponse.RegisterUserResponse;
import com.eventTickettingSystem.dto.authservicedto.request.LogOutUserRequest;
import com.eventTickettingSystem.dto.authservicedto.request.LoginUserRequest;
import com.eventTickettingSystem.dto.authservicedto.request.RegisterUserRequest;

public interface AuthService {
    RegisterUserResponse registerUser (RegisterUserRequest request);
    LoginUserResponse loginUser (LoginUserRequest request);
    LogOutUserResponse logoutUser (LogOutUserRequest request);
    void deleteAll();
}
