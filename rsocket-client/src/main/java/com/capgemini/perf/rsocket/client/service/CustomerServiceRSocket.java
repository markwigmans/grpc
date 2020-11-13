package com.capgemini.perf.rsocket.client.service;

import com.capgemini.perf.shared.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceRSocket implements CustomerService {

    private final RSocketRequester socketRequester;

    @Override
    public Flux<CustomerDTO> all() {
        return socketRequester.route("customer.all").retrieveFlux(CustomerDTO.class);
    }

    @Override
    public Mono<CustomerDTO> find(int id) {
        return socketRequester.route("customer.id").data(Integer.valueOf(id)).retrieveMono(CustomerDTO.class);
    }
}
