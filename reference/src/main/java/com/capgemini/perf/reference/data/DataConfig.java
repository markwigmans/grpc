package com.capgemini.perf.reference.data;

import com.capgemini.perf.lib.util.DataSetGenerator;
import com.capgemini.perf.reference.api.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataConfig implements ApplicationListener<ApplicationReadyEvent> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        DataSetGenerator.dataSet("Ref").stream()
                .map(mapper::fromDTO).forEach(repository::save);
    }
}
