package com.capgemini.perf.grpc.intermediate.service;

import com.capgemini.perf.shared.data.CustomerDTO;

import java.util.Optional;

public interface CustomerService {
    Iterable<CustomerDTO> all();

    Optional<CustomerDTO> find(int id);
}
