package com.capgemini.perf.json.server.service;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.json.server.data.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceDB implements CustomerService {

    private final CustomerRepository repository;

    CustomerServiceDB(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Customer> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> find(Long id) {
        return repository.findById(id);
    }
}
