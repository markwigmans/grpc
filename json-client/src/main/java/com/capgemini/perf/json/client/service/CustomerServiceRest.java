package com.capgemini.perf.json.client.service;

import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.util.EurekaUtil;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerServiceRest implements CustomerService {

    private final RestTemplate restTemplate;
    private final DiscoveryClient client;
    private String url = null;

    public CustomerServiceRest(RestTemplate restTemplate, DiscoveryClient client) {
        this.restTemplate = restTemplate;
        this.client = client;
    }

    @Override
    public Iterable<CustomerDTO> all() {
        final CustomerDTO[] result = restTemplate.getForObject(url() + "/customer/all", CustomerDTO[].class);
        return Arrays.stream(result).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> find(Long id) {
        final CustomerDTO result = restTemplate.getForObject(url() + "/customer/" + id, CustomerDTO.class);
        return Optional.ofNullable(result);
    }

    private String url() {
        if (url == null) {
            final Optional<ServiceInstance> instance = client.getInstances("json-server").stream().findFirst();
            instance.ifPresent(v -> url = v.getUri().toString());
        }
        return url;
    }
}
