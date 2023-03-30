package ru.uxair.authorization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;
import ru.uxair.authorization.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Log4j2
public class RestAdminControllerImpl implements RestAdminController{
    private final UserService userService;

    @Autowired
    public RestAdminControllerImpl(UserService userService) {
        this.userService = userService;
    }

    // Получить всех пользователей их базы данных
    @Override
    public ResponseEntity<List<User>> getUser () {
        System.out.println("вызываю метод гет юзер");
        log.info("Rest admin controller, method getUser");
        return ResponseEntity.ok().body(userService.getAll());
    }

    // Сохранить нового пользователя
    @Override
    public ResponseEntity<User> saveUser (@RequestBody User user) {
        log.info("Rest admin controller, method saveUser");
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Сохранить новую роль
    @Override
    public ResponseEntity<Role> saveRole (@RequestBody Role role) {
        log.info("Rest admin controller, method saveRole");
        userService.saveRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Изменить пользователя
    @Override
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        log.info("Rest admin controller, method updateUser");
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Удалить пользователя
    @Override
    public ResponseEntity<User> deleteUser(@PathVariable("id") @Parameter(description = "ID пользователя") Long id) {
        log.info("Rest admin controller, method deleteUser");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
