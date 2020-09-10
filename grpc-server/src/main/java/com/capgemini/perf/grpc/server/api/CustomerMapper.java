package com.capgemini.perf.grpc.server.api;

import com.capgemini.perf.grpc.server.data.Customer;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.data.UUIDMapper;
import com.capgemini.perf.shared.proto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UUIDMapper.class)
public interface CustomerMapper {

    CustomerResponse toDTO(Customer entity);

    Customer fromDTO(CustomerDTO dto);
}