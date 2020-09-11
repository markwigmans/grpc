package com.capgemini.perf.reference.service;

import com.capgemini.perf.reference.data.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> all();

    Optional<Customer> find(int id);
}
