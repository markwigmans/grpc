package com.capgemini.perf.json.client.api;

import com.capgemini.perf.json.client.service.CustomerService;
import com.capgemini.perf.shared.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerApi {

    final private CustomerService customerService;

    @GetMapping("/all")
    public Iterable<CustomerDTO> all() {
        log.info("all()");
        return customerService.all();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerDTO> find(@PathVariable int userId) {
        log.info("find({})", userId);
        final Optional<CustomerDTO> customer = customerService.find(userId);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
