package ru.hh.nab.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.starter.NabProdConfig;

@Configuration
@Import(NabProdConfig.class)
public class TodoConfig {
    @Bean
    public TodoDAO todoDAO() {
        return new TodoDAO();
    }

}
