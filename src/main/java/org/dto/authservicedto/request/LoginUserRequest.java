package org.dto.authservicedto.request;

import lombok.Data;

@Data
public class LoginUserRequest {
    String email;
    String password;
}
