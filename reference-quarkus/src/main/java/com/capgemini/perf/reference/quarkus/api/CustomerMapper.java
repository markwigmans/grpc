package com.capgemini.perf.reference.quarkus.api;

import com.capgemini.perf.reference.quarkus.data.Customer;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.data.UUIDMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = UUIDMapper.class)
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}
