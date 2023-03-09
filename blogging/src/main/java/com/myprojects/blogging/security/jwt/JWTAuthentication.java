package com.myprojects.blogging.security.jwt;

import com.myprojects.blogging.users.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class JWTAuthentication implements Authentication {
    private String token;
    private Long userId;

    public JWTAuthentication(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Long getPrincipal() {
        return userId;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean isAuthenticated() {
        return userId != null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
