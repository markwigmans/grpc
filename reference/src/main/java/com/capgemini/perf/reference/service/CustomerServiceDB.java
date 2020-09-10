package com.capgemini.perf.reference.service;

import com.capgemini.perf.reference.data.Customer;
import com.capgemini.perf.reference.data.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceDB implements CustomerService {

    private final CustomerRepository repository;

    @Override
    @Cacheable(value = "customers")
    public Iterable<Customer> all() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "customer")
    public Optional<Customer> find(int id) {
        return repository.findByUserId(id);
    }
}
