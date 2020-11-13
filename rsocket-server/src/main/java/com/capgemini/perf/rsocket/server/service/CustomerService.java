package com.capgemini.perf.rsocket.server.service;

import com.capgemini.perf.rsocket.server.data.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> all();

    Optional<Customer> find(int id);
}
