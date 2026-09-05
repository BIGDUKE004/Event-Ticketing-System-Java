package org.data.models;

import lombok.Data;

@Data
public class User {
    String id;
    String name;
    String email;
    String password;
    Role role;
}
