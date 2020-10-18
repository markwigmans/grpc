package com.capgemini.perf.reference.quarkus.service;

import com.capgemini.perf.reference.quarkus.data.Customer;
import com.capgemini.perf.reference.quarkus.data.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class CustomerServiceDB implements CustomerService {

    private final CustomerRepository repository;

    @Inject
    CustomerServiceDB(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Customer> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> find(int id) {
        return repository.findByUserId(id);
    }
}
