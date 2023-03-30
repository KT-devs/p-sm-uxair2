package ru.uxair.flight.config

-service.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Flight Service API")
                        .version("1.0")
                        .description("REST API for managing flights and seats")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your_email@example.com")))
                .servers(List.of(new Server()
                        .url("http://localhost:8080/")
                        .description("Local server")));
    }

}

