package de.johngockel.service.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("de.johngockel.service.core.entity")
@EnableJpaRepositories(basePackages = "de.johngockel.service.core")
public class CoreModuleConfiguration {
}
