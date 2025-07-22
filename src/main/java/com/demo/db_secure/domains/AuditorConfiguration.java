package com.demo.db_secure.domains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

// TODO Integrate Spring Security and return the actual USER for auditing and security.
@Configuration
public class AuditorConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("SYSTEM");
    }
}
