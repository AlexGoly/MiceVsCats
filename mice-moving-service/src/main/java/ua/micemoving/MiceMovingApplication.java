package ua.micemoving;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Mice moving Service", version = "1.0",
        description = "Service for....", contact =
@Contact(name = "Oleksandr Maksimov", email = "maxymov.olexandr@gmail.com")))
public class MiceMovingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiceMovingApplication.class, args);
    }


}
