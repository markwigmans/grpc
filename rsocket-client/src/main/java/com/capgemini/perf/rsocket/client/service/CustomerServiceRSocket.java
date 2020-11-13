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

    private final Mono<RSocketRequester> socketRequester;

    @Override
    public Flux<CustomerDTO> all() {
        return socketRequester
                .map(r -> r.route("customer.all"))
                .flatMapMany(r -> r.retrieveFlux(CustomerDTO.class))
                .doOnNext(r -> log.info("result: {}", r));
    }

    @Override
    public Mono<CustomerDTO> find(int id) {
        return socketRequester
                .map(r -> r.route("customer.id").data(Integer.valueOf(id)))
                .flatMap(r -> r.retrieveMono(CustomerDTO.class))
                .doOnNext(r -> log.info("result"));
    }
}
