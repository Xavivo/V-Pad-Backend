package com.tfg.Vpad.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
// Made to handle CORS issues with Vite server, allowing requests from http://localhost:5173 to access our API
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Previously only GET and POST were allowed, now we allow all common HTTP methods
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
