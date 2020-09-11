package com.capgemini.perf.reference.service;

import com.capgemini.perf.reference.data.Customer;
import com.capgemini.perf.reference.data.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceDB implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Iterable<Customer> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> find(int id) {
        return repository.findByUserId(id);
    }
}
