package com.capgemini.perf.json.client.service;

import com.capgemini.perf.shared.data.CustomerDTO;

import java.util.Optional;

public interface CustomerService {
    Iterable<CustomerDTO> all();

    Optional<CustomerDTO> find(int id);
}
