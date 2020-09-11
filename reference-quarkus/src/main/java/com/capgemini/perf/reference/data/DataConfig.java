package com.capgemini.perf.reference.data;

import com.capgemini.perf.reference.api.CustomerMapper;
import com.capgemini.perf.shared.util.DataSetGenerator;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import lombok.RequiredArgsConstructor;

import javax.enterprise.event.Observes;

@Startup
@RequiredArgsConstructor
public class DataConfig{

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    void init(@Observes StartupEvent ev) {
        DataSetGenerator.dataSet("Quarkus").stream().map(mapper::fromDTO).forEach(repository::save);
    }
}
