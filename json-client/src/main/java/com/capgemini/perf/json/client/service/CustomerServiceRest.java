package com.capgemini.perf.json.client.service;

import com.capgemini.perf.lib.data.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

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
        final CustomerDTO[] result = restTemplate.getForObject(url + "/customer/all", CustomerDTO[].class);
        return Arrays.stream(result).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> find(int id) {
        final CustomerDTO result = restTemplate.getForObject(url + "/customer/" + id, CustomerDTO.class);
        return Optional.ofNullable(result);
    }
}
