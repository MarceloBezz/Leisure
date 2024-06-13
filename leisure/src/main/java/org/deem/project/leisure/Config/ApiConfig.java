package org.deem.project.leisure.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
 
    @Bean
    public String apiUrl() {
        return "https://suntech.eco.br/api/upload"; // Defina sua URL aqui
    }
}