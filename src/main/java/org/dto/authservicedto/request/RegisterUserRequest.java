package org.dto.authservicedto.request;

import lombok.Data;

import java.util.Random;
@Data
public class RegisterUserRequest {
    String id;
    String name;
    String email;
    String password;

    public void setId(){
        Random random = new Random();
        int randomNumber = random.nextInt(1, 16);
        String id = "" + randomNumber;
        this.id = id;
    }
}
