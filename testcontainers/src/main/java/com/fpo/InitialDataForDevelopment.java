package com.fpo;

import com.fpo.entity.User;
import com.fpo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataForDevelopment {

    @Bean
    @ConditionalOnProperty(name = "data.initialize", havingValue = "true")
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> userRepository.save(new User("John", "Doe", "john.doe@gmail.com"));
    }
}
