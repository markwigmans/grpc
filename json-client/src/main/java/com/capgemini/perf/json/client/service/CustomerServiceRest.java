package com.capgemini.perf.json.client.service;

import com.capgemini.perf.shared.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerServiceRest implements CustomerService {

    private final RestTemplate restTemplate;

    @Value("${json.server.host:localhost}")
    private String host;
    @Value("${json.server.port:8090}")
    private int port;
    private String url;

    @PostConstruct
    private void init() {
        url = String.format("http://%s:%s", host, port);
    }

    @Override
    public Iterable<CustomerDTO> all() {
        var result = restTemplate.getForObject(url + "/customer/all", CustomerDTO[].class);
        return Optional.ofNullable(result).map(Arrays::asList).orElseGet(ArrayList::new);
    }

    @Override
    public Optional<CustomerDTO> find(int id) {
        var result = restTemplate.getForObject(url + "/customer/" + id, CustomerDTO.class);
        return Optional.ofNullable(result);
    }
}
