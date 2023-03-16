package ru.uxair.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;
import ru.uxair.authorization.service.UserService;


import java.util.List;

// Контроллер api для роли ADMIN
@RestController
@RequestMapping("/api/admin")
public class RestAdminController {
    private final UserService userService;

    @Autowired
    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    // Получить всех пользователей их базы данных
    @PostMapping ("/users")
    public ResponseEntity<List<User>> getUser () {
        return ResponseEntity.ok().body(userService.getAll());
    }

    // Сохранить нового пользователя
    @PostMapping("/user")
    public ResponseEntity<User> saveUser (@RequestBody User user) throws Exception {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Сохранить новую роль
    @PostMapping("/role")
    public ResponseEntity<Role> saveRole (@RequestBody Role role) throws Exception {
        userService.saveRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Изменить пользователя
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Удалить пользователя
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
