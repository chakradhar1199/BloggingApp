package com.myprojects.blogging.security;

import com.myprojects.blogging.security.authtoken.AuthTokenFilter;
import com.myprojects.blogging.security.authtoken.AuthTokenService;
import com.myprojects.blogging.security.jwt.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    @Autowired
    private AuthTokenService authTokenService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/article").permitAll()
                        .anyRequest().authenticated()
                );

        http.addFilterBefore(new JWTAuthenticationFilter(), AnonymousAuthenticationFilter.class);
        http.addFilterBefore(new AuthTokenFilter(authTokenService), AnonymousAuthenticationFilter.class);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        super.cofigure(http)
        return http.build();
    }

}
