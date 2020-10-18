package com.capgemini.perf.reference.quarkus.api;

import com.capgemini.perf.shared.data.UUIDMapper;

import javax.enterprise.context.ApplicationScoped;

class UUIDMapperFactory {

    @ApplicationScoped
    UUIDMapper getUUIDMapper() {
        return new UUIDMapper();
    }
}
