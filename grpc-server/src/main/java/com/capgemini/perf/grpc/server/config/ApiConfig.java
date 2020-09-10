package com.capgemini.perf.grpc.server.config;

import com.capgemini.perf.shared.data.UUIDMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ApiConfig {
    @Bean
    UUIDMapper uuidMapper() {
        return new UUIDMapper();
    }
}
