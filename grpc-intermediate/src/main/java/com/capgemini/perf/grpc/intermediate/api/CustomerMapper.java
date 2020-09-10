package com.capgemini.perf.grpc.intermediate.api;

import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.proto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(CustomerResponse dto);

    CustomerResponse fromDTO(CustomerDTO dto);
}