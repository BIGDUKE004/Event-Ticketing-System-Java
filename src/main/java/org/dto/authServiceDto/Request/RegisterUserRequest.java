package org.dto.authServiceDto.Request;
import java.util.Random;
import lombok.Data;

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
