package ru.uxair.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.config.JwtTokenProvider;
import ru.uxair.authorization.entity.AuthenticationRequest;
import ru.uxair.authorization.entity.User;
import ru.uxair.authorization.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class RestAuthControllerImpl implements RestAuthController {
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    @Autowired
    public RestAuthControllerImpl(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            User user = userService.getUser(username);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtTokenProvider.createToken(user);
                Map<Object, Object> model = new HashMap<>();
                model.put("username", username);
                model.put("token", token);
                return ResponseEntity.ok(model);
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return null;
    }

    @Override
    @GetMapping("/validateToken")
    public ResponseEntity<?> validateToken(HttpServletRequest request) {
        try {
            String token = getJwt(request);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromToken(token);
                Map<Object, Object> model = new HashMap<>();
                model.put("username", username);
                model.put("token", token);
                return ResponseEntity.ok(model);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private String getJwt(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
