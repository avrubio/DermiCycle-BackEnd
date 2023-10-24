package com.example.dermicyclebackend.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JwtUtils {
    Logger logger = Logger.getLogger(JwtUtils.class.getName());

    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("${jwt-expiration-ms}")
    private int jwtExpirationMs;
    /**
     * Generate a JWT token based on the provided user details.
     *
     * @param myUserDetails The user details to include in the JWT.
     * @return The generated JWT token.
     */
    public String generateJwtToken(MyUserDetails myUserDetails) {
        return Jwts.builder()
                .setSubject(myUserDetails.getUsername()) // Just the user email
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    /**
     * Get the username from a JWT token.
     *
     * @param token The JWT token to extract the username from.
     * @return The username extracted from the JWT token.
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validate a JWT token.
     *
     * @param authToken The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SecurityException e) {
            logger.log(Level.SEVERE, "Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.log(Level.SEVERE, "Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.log(Level.SEVERE, "JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.log(Level.SEVERE, "JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
