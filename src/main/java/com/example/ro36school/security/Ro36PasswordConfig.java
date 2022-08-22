package com.example.ro36school.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Ro36PasswordConfig {
    @Bean
    PasswordEncoder getRo36PasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
