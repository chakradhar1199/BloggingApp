package com.chakri.springsecurity.security.JWT;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;



@Component
public class JWTAuthenticationFilter extends AuthenticationFilter {
    public JWTAuthenticationFilter() {
        super(new JWTAuthenticator(), new JWTConverter() );

        // Important to handle the success handler other wise we get the 500 internal server error
        setSuccessHandler(((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }));
    }

    static class JWTConverter implements AuthenticationConverter {
        @Override
        public Authentication convert(HttpServletRequest request) {
            if(request.getHeader("Authorization") != null){
                String token  = request.getHeader("Authorization").split(" ")[1];
                return new JWTAuthentication(token);
            }
            return null;
        }
    }

    static class JWTAuthenticator implements AuthenticationManager {

        //ToDo: Auto wire this
        private JWTService jwtService = new JWTService();
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            if (authentication instanceof JWTAuthentication){
                JWTAuthentication jwtAuthentication = (JWTAuthentication) authentication;
                String token = jwtAuthentication.getCredentials();

                if(token != null){
                    var userId = jwtService.getUserIdFromJWT(token);
                    jwtAuthentication.setUserId(userId);

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    return authentication;
                }
            }
            return null;
        }
    }

}
