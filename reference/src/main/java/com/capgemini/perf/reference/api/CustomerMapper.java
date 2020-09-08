package com.capgemini.perf.reference.api;

import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.reference.data.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}
