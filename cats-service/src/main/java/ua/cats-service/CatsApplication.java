package ua.micevscats.cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.springdoc", "ua.micevscats.cats"})
//@OpenAPIDefinition(info = @Info(title = "Cats Service", version = "1.0", description = "Service for CRUD operations with cats"))
public class CatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatsApplication.class, args);
    }
}