package ua.micehunt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Mice hunt service",
        version = "1.0", description = "Service for hunt"))
@EnableFeignClients
public class MiceHuntApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiceHuntApplication.class, args);
    }


}

