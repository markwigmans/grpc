package com.capgemini.perf.reference.server.api;

import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.util.DataSetGenerator;
import com.capgemini.perf.reference.data.Customer;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cache.CacheManager;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CacheManager cacheManager;
    private String baseUrl;

    @BeforeEach
    void init() {
        baseUrl = "http://localhost:" + port + "/customer/";
    }

    @Test
    void all() {
        String response = restTemplate.getForEntity(baseUrl + "all", String.class).getBody();
        final List<Customer> customers = JsonPath.parse(response).read("$");
        assertThat(customers.size(), is(DataSetGenerator.DEFAULT_RECORDS));
    }

    @Test
    void id() {
        final int id = 2;
        String response = restTemplate.getForEntity(baseUrl + id, String.class).getBody();
        final CustomerDTO customer = JsonPath.parse(response).read("$", CustomerDTO.class);
        assertThat(customer.getUserId(), is(id));
    }

    @Test
    void idCached() {
        final int id = 34;
        final String cacheName = "customer";
        // clear cache
        cacheManager.getCache(cacheName).clear();

        String response = restTemplate.getForEntity(baseUrl + id, String.class).getBody();
        final Customer customer = (Customer) cacheManager.getCache(cacheName).get(id).get();
        assertThat(customer.getUserId(), is(id));
    }
}