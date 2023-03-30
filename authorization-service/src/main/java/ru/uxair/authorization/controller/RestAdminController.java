package ru.uxair.authorization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;

import java.util.List;

@Tag(name = "Админ панель", description = "Взаимодействует с админ панелью")
public interface RestAdminController {
    @PostMapping("/users")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Вернуть список пользователей", description = "Позволяет вернуть спсиок пользователей из бд")
    public ResponseEntity<List<User>> getUser ();

    // Сохранить нового пользователя
    @PostMapping("/user")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Сохранить нового пользователя", description = "Позволяет сохранить пользователя в бд")
    public ResponseEntity<User> saveUser (@RequestBody User user);

    // Сохранить новую роль
    @PostMapping("/role")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Сохранить новую роль", description = "Позволяет сохранить новую роль в бд")
    public ResponseEntity<Role> saveRole (@RequestBody Role role);

    // Изменить пользователя
    @PutMapping("/user")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Изменить пользователя", description = "Позволяет изменить пользователя в бд")
    public ResponseEntity<User> updateUser(@RequestBody User user);

    // Удалить пользователя
    @DeleteMapping("/user/{id}")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Удалить пользователя по id", description = "Позволяет удалить пользователя в бд")
    public ResponseEntity<User> deleteUser(@PathVariable("id") @Parameter(description = "ID пользователя") Long id);
}
