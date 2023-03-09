package com.myprojects.blogging.security;


import com.myprojects.blogging.security.jwt.JWTService;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTServiceTest {
    private JWTService jwtService = new JWTService();
    @Test
    void canCreateJWTFromUSerId(){
        var userId = 1122;
        var jwt = jwtService.createJWT(userId, new Date(1678161317), new Date(1678766117));
        assertEquals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTIyIiwiZXhwIjoxNjc4NzY2LCJpYXQiOjE2NzgxNjF9._7fHAwRfQnWGt9wVltZ_zc_E1EBB6QwltAUuAMDFkcA", jwt);
    }

    @Test
    void canVerifyJWT(){
        var actualJWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTIyIiwiZXhwIjoxNjc4NzY1OTI1LCJpYXQiOjE2NzgxNjExMjV9.OqTIjR7LQ2VrPw8RYB_9GqWrPgr4OW9jQzyGSFxQ7DA";
        var userId = jwtService.getUserIdFromJWT(actualJWT);
        System.out.println("user id generated is "+userId);
        assertEquals(1122, userId);
    }
}
