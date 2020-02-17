package de.johngockel.service.api.rest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestApiModuleConfiguration implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS");
    }

    @Bean
    public OpenAPI openAPI(@Value("${project.version}") String projectVersion) {
        return new OpenAPI().info(
                new Info().title("Spring Boot Multi Module Example API")
                .version(projectVersion)
                .description("Demo API")
        );
    }
}
