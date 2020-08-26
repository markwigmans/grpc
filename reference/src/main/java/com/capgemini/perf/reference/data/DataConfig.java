package com.capgemini.perf.reference.data;

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
        repository.save(new Customer(1L, "Ref", "Bauer"));
        repository.save(new Customer(2L, "Ref", "O'Brian"));
        repository.save(new Customer(3L, "Ref", "Johnson"));
        repository.save(new Customer(4L, "Ref", "Palmer"));
        repository.save(new Customer(5L, "Ref", "Dessler"));
    }
}
