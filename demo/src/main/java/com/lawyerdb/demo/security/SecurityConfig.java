package com.lawyerdb.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .formLogin(form -> {
                form
                    .loginPage("/login") // Ensure this URL is correct and accessible
                    .permitAll(); // Allow everyone to access the login page
            })
            .authorizeHttpRequests(auth -> {
                auth
                    .requestMatchers("/req/login").permitAll() // Allow access to /req/login without authentication
                    .anyRequest().authenticated(); // All other requests require authentication
            });

        return http.build(); // Build the SecurityFilterChain
    }
}

