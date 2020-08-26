package com.capgemini.perf.grpc.client.api;

import com.capgemini.perf.grpc.client.service.CustomerService;
import com.capgemini.perf.lib.data.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Slf4j
@Tag(name = "Customer API", description = "Customer Interface")
public class CustomerApi {

    final private CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @Operation(summary = "Request all customers")
    public Iterable<CustomerDTO> all() {
        log.info("all()");
        return customerService.all();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Request given customers by id")
    public Optional<CustomerDTO> find(@Parameter(description = "id of customer") @PathVariable("id") Long id) {
        log.info("find({})", id);
        return customerService.find(id);
    }
}
