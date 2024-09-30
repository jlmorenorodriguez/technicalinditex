package com.jlmr.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Dev Server");

        Server prodServer = new Server();
        prodServer.setUrl("https://test.com/api");
        prodServer.setDescription("Production Server");

        Contact contact = new Contact();
        contact.setEmail("jlmorenorodriguez@gmail.com");
        contact.setName("Jose Luis Moreno Rodriguez");
        contact.setUrl("https://www.linkedin.com/in/josele-moreno-rodriguez/");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Test Inditex API")
                .version("1.0")
                .contact(contact)
                .description("Esta API es para una prueba técnica.")
                .termsOfService("https://choosealicense.com/licenses/mit/")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}