package com.capgemini.perf.rsocket.server.service;

import com.capgemini.perf.rsocket.server.data.Customer;
import com.capgemini.perf.rsocket.server.data.CustomerRepository;
import org.springframework.data.domain.Sort;
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
        return repository.findAll(Sort.by("userId").ascending());
    }

    @Override
    public Optional<Customer> find(int id) {
        return repository.findByUserId(id);
    }
}
