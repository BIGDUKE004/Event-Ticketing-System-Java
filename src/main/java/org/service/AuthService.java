package org.service;

import org.dto.authServiceDto.Request.LogOutUserRequest;
import org.dto.authServiceDto.Request.LoginUserRequest;
import org.dto.authServiceDto.Request.RegisterUserRequest;
import org.dto.authServiceDto.Response.LogOutUserResponse;
import org.dto.authServiceDto.Response.LoginUserResponse;
import org.dto.authServiceDto.Response.RegisterUserResponse;

public interface AuthService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginUserResponse loginUser(LoginUserRequest request);
    LogOutUserResponse registerUser(LogOutUserRequest request);
}
