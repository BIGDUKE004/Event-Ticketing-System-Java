package org.dto.authServiceDto.Request;

import lombok.Data;

@Data
public class LoginUserRequest {
    String email;
    String password;
}
