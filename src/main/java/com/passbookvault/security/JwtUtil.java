package com.passbookvault.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET =
	        "mySuperSecretKeyForPassbookVaultJwtAuthentication2026MyVeryStrongSecretKey";

    private final Key key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 24))
                .signWith(key)
                .compact();
    }
    
    public String extractUsername(String token) {
    	return Jwts.parser()
    			.verifyWith((SecretKey) key)
    			.build()
    			.parseSignedClaims(token)
    			.getPayload()
    			.getSubject();
    }
    
    public boolean isTokenValid(String token) {
    	try {
    		Jwts.parser()
    		.verifyWith((SecretKey) key)
    		.build()
    		.parseSignedClaims(token);
    		
    		return true;
    		
    	} catch (Exception e) {
    		return false;
    	}
    }
}