package com.chatapp.talky;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                            SignatureAlgorithm.HS256.getJcaName());

    public String createJwtAccessToken (String id, String email) {
        String jwtToken = Jwts.builder()
        .claim("email", email)
        .claim("id", id)
        .setIssuedAt(Date.from(Instant.now()))
        .setExpiration(Date.from(Instant.now().plus(15l, ChronoUnit.SECONDS)))
        .signWith(hmacKey)
        .compact();

        return jwtToken;
    }

    public Jws<Claims> decodeJwtToken (String token){
        Jws<Claims> jwt = Jwts.parserBuilder()
        .setSigningKey(hmacKey)
        .build()
        .parseClaimsJws(token);

        Claims claims = jwt.getBody();
        if (claims.getExpiration().before(new Date())) {
            throw new ExpiredJwtException(jwt.getHeader(), jwt.getBody(), "token expired");
        }
        return jwt;
    }
}
