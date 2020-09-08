package com.capgemini.perf.grpc.server.api;

import com.capgemini.perf.grpc.server.data.Customer;
import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.proto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toDTO(Customer entity);
    Customer fromDTO(CustomerDTO dto);
}