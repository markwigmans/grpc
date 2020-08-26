package com.capgemini.perf.grpc.server.service;

import com.capgemini.perf.grpc.server.data.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> all();

    Optional<Customer> find(Long id);
}
