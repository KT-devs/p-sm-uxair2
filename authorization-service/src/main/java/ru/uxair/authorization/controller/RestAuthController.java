package ru.uxair.authorization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.entity.AuthenticationRequest;


import javax.servlet.http.HttpServletRequest;


@Tag(name = "Панель авторизации", description = "Пройти аутентификацию и получить JWT токен")
public interface RestAuthController {
    @Operation(summary = "Аутентификация", description = "Позволяет получить JWT токен, после прохождения аутентификации")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest data);

    @Operation(summary = "Проверка токена на валидность", description = "Позволяет проверить JWT токен на валидность")
    public ResponseEntity<?> validateToken(HttpServletRequest request);

}
