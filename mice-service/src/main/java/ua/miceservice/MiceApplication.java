package ua.miceservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Mice Service", version = "1.0", description = "Service for CRUD operations with mice"))
public class MiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiceApplication.class, args);
    }
}