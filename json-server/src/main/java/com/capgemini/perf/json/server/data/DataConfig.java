package com.capgemini.perf.json.server.data;

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
        repository.save(new Customer(1L, "Json", "Bauer"));
        repository.save(new Customer(2L, "Json", "O'Brian"));
        repository.save(new Customer(3L, "Json", "Johnson"));
        repository.save(new Customer(4L, "Json", "Palmer"));
        repository.save(new Customer(5L, "Json", "Dessler"));
    }
}
