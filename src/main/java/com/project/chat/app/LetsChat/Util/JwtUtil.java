package com.project.chat.app.LetsChat.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.sql.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.project.chat.app.LetsChat.Data.LoginDetails;

import io.jsonwebtoken.Claims;

@Component
public class JwtUtil {
	
	    private static final String SECRET_KEY = "yourSecretKey"; // Replace with your secret key
	    private static final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds

	    @SuppressWarnings("deprecation")
		public static String generateToken(LoginDetails login) {
			/*
			 * return Jwts.builder() .setSubject(login.getUsername()) .setExpiration(new
			 * Date(System.currentTimeMillis() + EXPIRATION_TIME))
			 * .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes()) .compact();
			 */
	    	
	    	 SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	    	 return Jwts.builder()
	    	            .setSubject(login.getUsername())
	    	            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	    	            .signWith(secretKey)  // Use the generated secure key
	    	            .compact();
	    }

	    public static Claims parseToken(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(SECRET_KEY.getBytes())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
}
