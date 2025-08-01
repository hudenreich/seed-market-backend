package com.example.security.jwt;
import com.example.service.UserDetailsImpl; // Будет создан позже, используется для получения данных пользователя
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

<<<<<<< HEAD
    @Value("${seedstore.app.jwtSecret}")
    private String jwtSecret;

    @Value("${seedstore.app.jwtExpirationMs}")
    private int jwtExpirationMs;


=======
    @Value("${seedstore.app.jwtSecret}") // Получаем секретный ключ из application.properties
    private String jwtSecret;

    @Value("${seedstore.app.jwtExpirationMs}") // Получаем время жизни токена из application.properties
    private int jwtExpirationMs;

    // Метод для генерации JWT токена
>>>>>>> origin/main
    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

<<<<<<< HEAD

=======
    // Метод для получения имени пользователя из JWT токена
>>>>>>> origin/main
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

<<<<<<< HEAD

=======
    // Метод для валидации JWT токена
>>>>>>> origin/main
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}