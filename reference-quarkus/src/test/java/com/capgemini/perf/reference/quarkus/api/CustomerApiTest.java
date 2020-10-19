package com.capgemini.perf.reference.quarkus.api;

import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.util.DataSetGenerator;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
class CustomerApiTest {

    @Inject
    CustomerApi service;

    @Test
    public void testAll() {
        var customers= StreamSupport.stream(service.all().spliterator(), false).collect(Collectors.toList());
        assertThat("check size", customers.size(), Matchers.is(DataSetGenerator.DEFAULT_RECORDS));
        assertThat("check if all userId's are unique", customers.stream().map(CustomerDTO::getUserId).distinct().count(), is((long) customers.size()));
    }

    @Test
    public void testId() {
        final int id = 2;
        var response = service.find(id);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getUserId(), is(id));
    }
}