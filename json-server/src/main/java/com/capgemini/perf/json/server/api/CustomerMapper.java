package com.capgemini.perf.json.server.api;

import com.capgemini.perf.json.server.data.Customer;
import com.capgemini.perf.lib.data.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "firstName", source = "entity.firstName"),
            @Mapping(target = "lastName", source = "entity.lastName")
    })
    CustomerDTO toDTO(Customer entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "firstName", source = "dto.firstName"),
            @Mapping(target = "lastName", source = "dto.lastName")
    })
    Customer fromDTO(CustomerDTO dto);
}
