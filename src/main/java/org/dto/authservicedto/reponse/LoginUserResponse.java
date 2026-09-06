package org.dto.authservicedto.reponse;

import lombok.Data;

@Data
public class LoginUserResponse {
    String email;
    boolean isLoggedIn;
}
