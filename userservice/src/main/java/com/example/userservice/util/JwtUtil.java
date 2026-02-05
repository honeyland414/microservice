package com.example.userservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    private static Long EXPIRE = 604800000L;
    private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";

    public static String generateToken(String username) {
        Date now = new Date();
        Date expire = new Date(now.getTime() + EXPIRE);

        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static Claims getClaimsByToken(String token) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
