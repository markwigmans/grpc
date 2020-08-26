package com.capgemini.perf.grpc.server.data;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DataConfig {

    private final CustomerRepository repository;

    DataConfig(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void init() {
        // save a few customers
        repository.save(new Customer(1L, "Grpc", "Bauer"));
        repository.save(new Customer(2L, "Grpc", "O'Brian"));
        repository.save(new Customer(3L, "Grpc", "Johnson"));
        repository.save(new Customer(4L, "Grpc", "Palmer"));
        repository.save(new Customer(5L, "Grpc", "Dessler"));
    }
}
