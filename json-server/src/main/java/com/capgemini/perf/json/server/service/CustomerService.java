package com.capgemini.perf.json.server.service;

import com.capgemini.perf.json.server.data.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> all();

    Optional<Customer> find(Long id);
}
