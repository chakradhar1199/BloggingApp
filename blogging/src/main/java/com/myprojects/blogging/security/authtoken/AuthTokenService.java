package com.myprojects.blogging.security.authtoken;

import com.myprojects.blogging.users.UserEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthTokenService {
    private final AuthTokenRepository authTokenRepository;


    public AuthTokenService(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }

    public UUID createAuthToken(UserEntity userEntity){
        AuthToken authToken = new AuthToken();
        authToken.setUser(userEntity);
        var savedAuthToken = authTokenRepository.save(authToken);
        return savedAuthToken.getId();
    }

    public UserEntity getUserIdFromAuthToken(UUID authToken){
        var authTokenFromRepo = authTokenRepository.findById(authToken)
                .orElseThrow(() -> new BadCredentialsException("Invalid AuthToken"));

        return authTokenFromRepo.getUser();
    }

    
}
