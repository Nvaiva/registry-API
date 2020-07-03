package com.rest.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableJpaRepositories
@EntityScan
@ComponentScan(basePackages = {"com.rest.registry.controllers", "com.rest.registry.services"})
@SpringBootApplication
@Configuration
public class RegistryApplication {

    public static void main(String[] args) {

        SpringApplication.run(RegistryApplication.class, args);
    }

}
