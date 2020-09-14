package com.capgemini.perf.reference.quarkus.service;


import com.capgemini.perf.reference.quarkus.data.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> all();

    Optional<Customer> find(int id);
}
