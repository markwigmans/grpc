package com.capgemini.perf.grpc.client.api;

import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.proto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerResponseMapper {
    CustomerResponseMapper MAPPER = Mappers.getMapper(CustomerResponseMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "firstName", source = "entity.firstName"),
            @Mapping(target = "lastName", source = "entity.lastName")
    })
    CustomerResponse fromDTO(CustomerDTO entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "firstName", source = "dto.firstName"),
            @Mapping(target = "lastName", source = "dto.lastName")
    })
    CustomerDTO toDTO(CustomerResponse dto);
}
