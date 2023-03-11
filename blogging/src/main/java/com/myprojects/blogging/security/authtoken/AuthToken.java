package com.myprojects.blogging.security.authtoken;

import com.myprojects.blogging.commons.BaseEntity;
import com.myprojects.blogging.users.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.SimpleTimeZone;
import java.util.UUID;

@Entity(name = "auth_tokens")
@Data
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne

    private UserEntity user;
}
