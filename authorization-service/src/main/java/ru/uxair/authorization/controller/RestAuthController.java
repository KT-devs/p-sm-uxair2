package ru.uxair.authorization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.entity.User;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Панель авторизации", description = "Взаимодействует с админ панелью")
@Log4j2
public class RestAuthController {
    @PostMapping ("/login")
    @Operation(summary = "Получить jwt токен с помощью логина и пароля", description = "Позволяет получить токен")
    public ResponseEntity<HttpStatus> login(@RequestBody User user){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
