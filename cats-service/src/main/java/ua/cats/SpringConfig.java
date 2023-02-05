package ua.cats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.cats.model.Cat;

@Configuration
@ComponentScan(basePackages = {"ua.cats"})
public class SpringConfig {
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
