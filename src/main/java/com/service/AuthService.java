package com.service;

import com.dto.authservicedto.reponse.LogOutUserResponse;
import com.dto.authservicedto.reponse.LoginUserResponse;
import com.dto.authservicedto.reponse.RegisterUserResponse;
import com.dto.authservicedto.request.LogOutUserRequest;
import com.dto.authservicedto.request.LoginUserRequest;
import com.dto.authservicedto.request.RegisterUserRequest;

public interface AuthService {
    RegisterUserResponse registerUser (RegisterUserRequest request);
    LoginUserResponse loginUser (LoginUserRequest request);
    LogOutUserResponse logoutUser (LogOutUserRequest request);
    void deleteAll();
}
