package ru.hh.nab.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TodoResource.class, CORSResponseFilter.class})
public class TodoJerseyConfig {
    @Bean
    CORSResponseFilter corsResponseFilter() {
        return new CORSResponseFilter();
    }
}
