package com.capgemini.perf.shared.data;

import java.util.UUID;

public class UUIDMapper {

    public String asString(UUID id) {
        return id != null ? id.toString() : null;
    }

    public UUID asUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}
