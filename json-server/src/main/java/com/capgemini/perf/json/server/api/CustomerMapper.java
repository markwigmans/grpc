package com.capgemini.perf.json.server.api;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.data.UUIDMapper;
import org.mapstruct.Mapper;

@Mapper(uses = UUIDMapper.class)
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}
