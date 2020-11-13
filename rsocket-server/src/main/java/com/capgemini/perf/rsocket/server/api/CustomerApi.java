package com.capgemini.perf.rsocket.server.api;

import com.capgemini.perf.rsocket.server.service.CustomerService;
import com.capgemini.perf.shared.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.StreamSupport;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    @MessageMapping("customer.all")
    public Flux<CustomerDTO> all() {
        log.info("all()");
        var customers = customerService.all();
        return Flux.fromStream(StreamSupport.stream(customers.spliterator(), false).map(mapper::toDTO));
    }

    @MessageMapping("customer.id")
    public Mono<CustomerDTO> find(@PathVariable int userId) {
        log.info("find({})", userId);
        var customer = customerService.find(userId);
        return Mono.justOrEmpty(customer.map(mapper::toDTO));
    }
}
