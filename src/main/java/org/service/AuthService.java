package org.service;

import org.dto.authservicedto.reponse.LogOutUserResponse;
import org.dto.authservicedto.reponse.LoginUserResponse;
import org.dto.authservicedto.reponse.RegisterUserResponse;
import org.dto.authservicedto.request.LogOutUserRequest;
import org.dto.authservicedto.request.LoginUserRequest;
import org.dto.authservicedto.request.RegisterUserRequest;

public interface AuthService {
    RegisterUserResponse registerUser (RegisterUserRequest request);
    LoginUserResponse loginUser (LoginUserRequest request);
    LogOutUserResponse logoutUser (LogOutUserRequest request);
}
