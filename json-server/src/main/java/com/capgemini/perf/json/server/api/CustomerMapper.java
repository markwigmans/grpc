package com.capgemini.perf.json.server.api;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.lib.data.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);
    Customer fromDTO(CustomerDTO dto);
}
