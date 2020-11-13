package com.capgemini.perf.rsocket.client.api;

import com.capgemini.perf.rsocket.client.service.CustomerService;
import com.capgemini.perf.shared.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class RestCustomerApi {

    private final CustomerService customerService;

    @GetMapping("/all")
    public Iterable<CustomerDTO> all() {
        log.info("all()");
        return customerService.all().collectList().block();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerDTO> find(@PathVariable int userId) {
        log.info("find({})", userId);
        var customer = customerService.find(userId).blockOptional();
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
