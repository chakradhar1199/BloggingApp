package com.chakri.springsecurity.security;

import com.chakri.springsecurity.security.JWT.JWTAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();

        //exception handling for the unauthorized request
        http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        })
                .and();
        // public apis
        http.authorizeHttpRequests()
                .requestMatchers("/students/**").permitAll()
                //login page public api
                .requestMatchers("/api/public/**").permitAll()
                //private apis
                .anyRequest().authenticated();


        http.addFilterBefore(new JWTAuthenticationFilter(), AnonymousAuthenticationFilter.class);
        return http.build();
    }
}
