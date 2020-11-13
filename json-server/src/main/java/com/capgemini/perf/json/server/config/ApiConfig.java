package com.capgemini.perf.json.server.config;

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
