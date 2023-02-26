package com.myprojects.blogging.users;


import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String password;

    private String email;
}
