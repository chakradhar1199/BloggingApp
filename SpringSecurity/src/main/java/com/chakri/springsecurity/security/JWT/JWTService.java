package com.chakri.springsecurity.security.JWT;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
public class JWTService {
    private Algorithm algorithm = Algorithm.HMAC256("SECRET SIGNING KEY (should be in env or config)");

    public String createJWT(Long userId){
        return createJWT(userId,
                new Date(),
                new Date(System.currentTimeMillis() + 1000 * 60 * 60 *24 *7)
        );
    }

    public Long getUserIdFromJWT(String jwt){
        var verifier = JWT.require(algorithm).build();
        var decodeJWT = verifier.verify(jwt);
        var subject = decodeJWT.getSubject();
        return Long.parseLong(subject);
    }

    protected String createJWT(Long userId, Date iat, Date exp){
        String token = JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(iat)
                .withExpiresAt(exp)
                .sign(algorithm);
        return token;
    }
}
