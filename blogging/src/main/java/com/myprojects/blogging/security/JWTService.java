package com.myprojects.blogging.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private Algorithm algorithm = Algorithm.HMAC256("SECRET SIGNING KEY (should be in env or config)");

    public String createJWT(Integer userId){
        return createJWT(userId,
                new Date(),
                new Date(System.currentTimeMillis() + 1000 * 60 * 60 *24 *7)
        );
    }

    public Integer getUserIdFromJWT(String jwt){
        var verifier = JWT.require(algorithm).build();
        var decodeJWT = verifier.verify(jwt);
        var subject = decodeJWT.getSubject();
        return Integer.parseInt(subject);
    }

    protected String createJWT(Integer userId, Date iat, Date exp){
        String token = JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(iat)
                .withExpiresAt(exp)
                .sign(algorithm);
        return token;
    }

}
