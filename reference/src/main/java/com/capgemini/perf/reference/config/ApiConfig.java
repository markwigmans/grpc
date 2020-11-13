package com.capgemini.perf.reference.config;

import com.capgemini.perf.shared.data.UUIDMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    UUIDMapper uuidMapper() {
        return new UUIDMapper();
    }
}
