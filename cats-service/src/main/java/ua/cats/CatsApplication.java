package ua.cats;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cats Service", version = "1.0",
        description = "Service for CRUD operations with cats", contact =
@Contact(name = "Oleksandr Maksimov", email = "maxymov.olexandr@gmail.com")))
public class CatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatsApplication.class, args);
    }
}