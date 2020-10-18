package com.capgemini.perf.json.server.api;

import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.util.DataSetGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApiTest {

    static final ObjectMapper MAPPER = new ObjectMapper();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl;

    @BeforeEach
    void init() {
        baseUrl = "http://localhost:" + port + "/customer/";
    }

    @Test
    void all() throws JsonProcessingException {
        String response = restTemplate.getForEntity(baseUrl + "all", String.class).getBody();
        var customers = Arrays.asList(MAPPER.readValue(response, CustomerDTO[].class));
        assertThat("check size", customers.size(), is(DataSetGenerator.DEFAULT_RECORDS));
        assertThat("check all userId's are unique", customers.stream().map(CustomerDTO::getUserId).distinct().count(), CoreMatchers.is((long) customers.size()));
    }

    @Test
    void id() throws JsonProcessingException {
        final int id = 2;
        String response = restTemplate.getForEntity(baseUrl + id, String.class).getBody();
        var customer = MAPPER.readValue(response, CustomerDTO.class);
        assertThat(customer.getUserId(), is(id));
    }
}