package com.capgemini.perf.reference.api;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDMapper {

    public String asString(UUID id) {
        return id != null ? id.toString() : null;
    }

    public UUID asUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}
