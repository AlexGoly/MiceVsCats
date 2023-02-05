package ua.micehunt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ="ua.micehunt" )
//@EntityScan("ua.miceservice.model")
//@EnableJpaRepositories("ua.miceservice.repository")
@OpenAPIDefinition(info = @Info(title = "Mice hunt service",
        version = "1.0", description = "Service for hunt"))

public class MiceHuntApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiceHuntApplication.class, args);
    }



}

