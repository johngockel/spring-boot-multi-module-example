package de.johngockel.service.app;

import de.johngockel.service.api.rest.RestApiModuleConfiguration;
import de.johngockel.service.core.CoreModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CoreModuleConfiguration.class, RestApiModuleConfiguration.class})
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
