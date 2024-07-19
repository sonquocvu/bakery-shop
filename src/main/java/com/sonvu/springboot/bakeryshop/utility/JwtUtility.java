package com.sonvu.springboot.bakeryshop.utility;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtility {

	@Value("${security.jwt.secret-key}")
    private String secretKey;
	
	@Value("${security.jwt.expiration-time}")
	private long jwtExpiration;

    public Boolean isTokenvalid(String token, UserDetails userDetails) 
    {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    public String extractUsername(String token) 
    {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) 
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    public String generateToken(String username) 
    {
        return createToken(username);
    }
    
    public long getExpirationTime()
    {
    	return jwtExpiration;
    }

    private Claims extractAllClaims(String token) 
    {
        return Jwts.parser().decryptWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
    }

    private Boolean isTokenExpired(String token) 
    {
        return extractExpiration(token).before(new Date());
    }
    
    private Date extractExpiration(String token) 
    {
        return extractClaim(token, Claims::getExpiration);
    }

    private String createToken(String subject) 
    {
    	return Jwts.builder()
    			.subject(subject)
    			.issuedAt(new Date(System.currentTimeMillis()))
    			.expiration(new Date(System.currentTimeMillis() + jwtExpiration))
    			.signWith(getSecretKey(), SIG.HS256)
    			.compact();	
    }

    private SecretKey getSecretKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
