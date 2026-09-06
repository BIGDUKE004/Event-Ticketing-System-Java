package org.dto.authservicedto.reponse;

import lombok.Data;

@Data
public class RegisterUserResponse {
    String id;
    String name;
    String email;
}
