package com.capgemini.perf.rsocket.client.api;

import com.capgemini.perf.rsocket.client.service.CustomerService;
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
public class RSocketCustomerApi {

    private final CustomerService customerService;

    @MessageMapping("customer.all")
    public Flux<CustomerDTO> all() {
        log.info("all()");
        return customerService.all();
    }

    @MessageMapping("customer.id")
    public Mono<CustomerDTO> find(@PathVariable int userId) {
        log.info("find({})", userId);
        return customerService.find(userId);
    }
}
