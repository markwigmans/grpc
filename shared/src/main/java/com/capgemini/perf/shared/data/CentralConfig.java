package com.capgemini.perf.shared.data;

import org.mapstruct.MapperConfig;

@MapperConfig(uses = UUIDMapper.class, componentModel = "spring")
public interface CentralConfig {
}
