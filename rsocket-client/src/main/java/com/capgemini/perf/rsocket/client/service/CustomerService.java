package com.capgemini.perf.rsocket.client.service;

import com.capgemini.perf.shared.data.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface CustomerService {
    Flux<CustomerDTO> all();

    Mono<CustomerDTO> find(int id);
}
