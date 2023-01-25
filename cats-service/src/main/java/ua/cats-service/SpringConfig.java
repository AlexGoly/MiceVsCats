package ua.micevscats.cats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.micevscats.cats.model.Cat;

@Configuration
@ComponentScan("ua.micevscats")
public class SpringConfig {
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
