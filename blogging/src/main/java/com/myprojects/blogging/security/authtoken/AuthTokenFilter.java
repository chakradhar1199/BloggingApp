package com.myprojects.blogging.security.authtoken;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

import java.util.UUID;

public class AuthTokenFilter extends AuthenticationFilter {
    public AuthTokenFilter(AuthTokenService authTokenService) {
        super(new AuthTokenManager(authTokenService), new AuthTokenConverter());
        setSuccessHandler(((request, response, authentication) ->
                SecurityContextHolder.getContext().setAuthentication(authentication)));
    }

    static class AuthTokenConverter implements AuthenticationConverter{
        @Override
        public Authentication convert(HttpServletRequest request) {
            if(request.getHeader("X-Auth-Token")!=null){
                String token = request.getHeader("X-Auth-Token");
                return new AuthTokenAuthentication(token);
            }
            return null;
        }
    }
    static class AuthTokenManager implements AuthenticationManager{
        private AuthTokenService authTokenService;
        public AuthTokenManager(AuthTokenService authTokenService) {
            this.authTokenService=authTokenService;
        }

        @Override
        public Authentication authenticate(Authentication authentication)
                throws AuthenticationException {

            if(authentication instanceof AuthTokenAuthentication) {

                AuthTokenAuthentication authTokenAuthentication = (AuthTokenAuthentication) authentication;
                UUID authToken = UUID.fromString(authTokenAuthentication.getCredentials());

                var userId = authTokenService.getUserIdFromAuthToken(authToken);
                authTokenAuthentication.setUserId(userId);
                return authTokenAuthentication;
            }
            return null;
        }
    }


}
