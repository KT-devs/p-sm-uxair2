package ru.uxair1.authorizationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.uxair1.authorizationservice.entity.Role;
import ru.uxair1.authorizationservice.entity.User;
import ru.uxair1.authorizationservice.service.UserService;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (UserService userService) {
		return args -> {
			Role ROLE_SUPERADMIN = new Role("ROLE_SUPERADMIN");
			Role ROLE_ADMIN = new Role("ROLE_ADMIN");
			Role ROLE_MANAGER = new Role("ROLE_MANAGER");
			Role ROLE_CUSTOMER = new Role("ROLE_CUSTOMER");

			userService.saveRole(ROLE_SUPERADMIN);
			userService.saveRole(ROLE_ADMIN);
			userService.saveRole(ROLE_MANAGER);
			userService.saveRole(ROLE_CUSTOMER);

			userService.saveUser(new User("admin@mail.ru", "admin", Arrays.asList(ROLE_ADMIN, ROLE_MANAGER)));
			userService.saveUser(new User("user@mail.ru", "user", Arrays.asList(ROLE_CUSTOMER)));
		};
	}

}
