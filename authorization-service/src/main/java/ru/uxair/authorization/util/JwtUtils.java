package ru.uxair.authorization.util;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.uxair.authorization.entity.JwtAuthentication;
import ru.uxair.authorization.entity.Role;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(claims.get("roles", List.class));
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

//    private static Set<Role> getRoles(Claims claims) {
//        final List<String> roles = claims.get("roles", List.class);
//        return roles.stream()
//                .map(Role::valueOf)
//                .collect(Collectors.toSet());
//    }

}
