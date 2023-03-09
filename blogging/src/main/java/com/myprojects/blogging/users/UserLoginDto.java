package com.myprojects.blogging.users;

import lombok.Data;

@Data
public class UserLoginDto {
    private String username;
    private String password;
    private String token;
}
