package com.capgemini.perf.reference.api;

import com.capgemini.perf.reference.data.Customer;
import com.capgemini.perf.shared.data.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UUIDMapper.class)
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}
