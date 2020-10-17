package com.capgemini.perf.json.server.api;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.shared.data.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class CustomerMapperTest {

    @Autowired
    CustomerMapper mapper;

    @Test
    public void toDTO() {
        int userId = 23;
        var customer = new Customer(null, userId, "ref", "Name");
        var customerDto = mapper.toDTO(customer);
        assertThat(customerDto.getUserId(), is(userId));
    }

    @Test
    public void fromDTO() {
        int userId = 23;
        var customerDto = new CustomerDTO(null, userId, "ref", "Name");
        var customer = mapper.fromDTO(customerDto);
        assertThat(customer.getUserId(), is(userId));
    }
}