package com.capgemini.perf.rsocket.server.api;

import com.capgemini.perf.rsocket.server.data.Customer;
import com.capgemini.perf.shared.data.CentralConfig;
import com.capgemini.perf.shared.data.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface CustomerMapper {

    CustomerDTO toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}
