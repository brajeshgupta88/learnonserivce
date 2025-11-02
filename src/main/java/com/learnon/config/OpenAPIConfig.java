package com.learnon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Development server");

        return new OpenAPI()
                .info(new Info()
                        .title("Local Services API")
                        .version("1.0.0")
                        .description("API documentation for Local Services Application")
                        .contact(new Contact()
                                .name("Brajesh Gupta")
                                .email("contact@localservices.app")))
                .servers(List.of(devServer));
    }
}
