package com.eventTickettingSystem.dto.authservicedto.reponse;

import lombok.Data;

@Data
public class LoginUserResponse {
    String email;
    boolean isLoggedIn;

    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
}
