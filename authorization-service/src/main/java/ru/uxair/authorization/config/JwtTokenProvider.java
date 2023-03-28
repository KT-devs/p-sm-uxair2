package ru.uxair.authorization.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.uxair.authorization.entity.User;

import java.util.Calendar;


@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;


    public String createToken(User user) {

        Claims claims = Jwts.claims().setSubject(user.getUsername());

        Calendar now = Calendar.getInstance();
        Calendar expiration = Calendar.getInstance();
        expiration.setTimeInMillis(now.getTimeInMillis() + 3600000);

        return Jwts.builder()
                .setClaims(claims)
                .claim("roles", user.getRoles())
                .setIssuedAt(now.getTime())
                .setExpiration(expiration.getTime())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }
}
