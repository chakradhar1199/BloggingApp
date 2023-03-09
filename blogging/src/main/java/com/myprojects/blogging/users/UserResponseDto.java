package com.myprojects.blogging.users;

import lombok.Data;

@Data
public class UserResponseDto {
    private long id;
    private String username;

    // to create the password authentication
//    private String password;

    private String bio;
    private String image;
    private String email;
    String token;
}
