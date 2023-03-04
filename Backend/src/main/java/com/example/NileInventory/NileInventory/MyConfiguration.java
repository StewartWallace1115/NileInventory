package com.example.NileInventory.NileInventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        // TODO: NEED to add auth
        return (web) -> web.ignoring().requestMatchers("/**");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // TODO: Move to config.
                registry.addMapping("/**").allowedOrigins("http://localhost:5173/").allowedHeaders("*").allowCredentials(false).maxAge(3600);

            }
        };
    }
}