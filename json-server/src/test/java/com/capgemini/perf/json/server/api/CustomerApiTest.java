package com.capgemini.perf.json.server.api;

import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.util.DataSetGenerator;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApiTest {

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
    void all() {
        String response = restTemplate.getForEntity(baseUrl + "all", String.class).getBody();
        final List<CustomerDTO> customers = JsonPath.parse(response).read("$");
        assertThat(customers.size(), is(DataSetGenerator.DEFAULT_RECORDS));
    }

    @Test
    void id() {
        final int id = 2;
        String response = restTemplate.getForEntity(baseUrl + id, String.class).getBody();
        final CustomerDTO customer = JsonPath.parse(response).read("$", CustomerDTO.class);
        assertThat(customer.getUserId(), is(id));
    }
}