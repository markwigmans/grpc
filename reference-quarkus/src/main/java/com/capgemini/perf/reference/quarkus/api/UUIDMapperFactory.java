package com.capgemini.perf.reference.quarkus.api;

import com.capgemini.perf.shared.data.UUIDMapper;

import javax.enterprise.inject.Produces;

public class UUIDMapperFactory {

    @Produces
    public UUIDMapper getUUIDMapper() {
        return new UUIDMapper();
    }
}
