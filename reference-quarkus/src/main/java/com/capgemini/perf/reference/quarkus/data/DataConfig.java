package com.capgemini.perf.reference.quarkus.data;

import com.capgemini.perf.reference.quarkus.api.CustomerMapper;
import com.capgemini.perf.shared.util.DataSetGenerator;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Startup
public class DataConfig {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Inject
    public DataConfig(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    void init(@Observes StartupEvent ev) {
        DataSetGenerator.dataSet("Quarkus").stream().map(mapper::fromDTO).forEach(repository::save);
    }
}
