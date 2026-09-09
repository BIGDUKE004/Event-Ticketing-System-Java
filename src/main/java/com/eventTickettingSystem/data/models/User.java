package com.eventTickettingSystem.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    String id;
    String name;
    String email;
    String password;
    boolean isLoggedIn = false;
}
