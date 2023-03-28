package ru.uxair.authorization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.uxair.authorization.entity.Role;
import ru.uxair.authorization.entity.User;
import ru.uxair.authorization.service.UserService;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }

    // TO DO сделать liquibase UXAR2-22
    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {

            userService.saveUser(new User("admin@mail.ru", "admin", "adminFirst", "adminLast",
                    (Set<Role>) Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_MANAGER)));
            userService.saveUser(new User("user@mail.ru", "user", "userFirst", "userLast",
                    (Set<Role>) Arrays.asList(Role.ROLE_CUSTOMER)));

        };
    }
}
