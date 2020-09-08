package com.capgemini.perf.json.server.api;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.json.server.service.CustomerService;
import com.capgemini.perf.lib.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    @GetMapping("/all")
    public List<CustomerDTO> all() {
        log.info("all()");
        final Iterable<Customer> customers = customerService.all();
        return StreamSupport.stream(customers.spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerDTO> find(@PathVariable("userId") int userId) {
        log.info("find({})", userId);
        final Optional<Customer> customer = customerService.find(userId);
        return customer.map(value -> ResponseEntity.ok(mapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
