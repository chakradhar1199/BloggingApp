package com.myprojects.blogging.users;

import com.myprojects.blogging.commons.BaseEntity;
import jakarta.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {
    private String username;

    // to create the password authentication
    private String password;

    private String bio;
    private String image;
}
