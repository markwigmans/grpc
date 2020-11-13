package com.capgemini.perf.grpc.intermediate.api;

import com.capgemini.perf.shared.data.CentralConfig;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.proto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface CustomerMapper {

    CustomerDTO toDTO(CustomerResponse dto);

    CustomerResponse fromDTO(CustomerDTO dto);
}