package com.capgemini.perf.json.server.data;

import com.capgemini.perf.json.server.api.CustomerMapper;
import com.capgemini.perf.shared.util.DataSetGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataConfig implements ApplicationListener<ApplicationReadyEvent> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        DataSetGenerator.dataSet("Json").stream()
                .map(mapper::fromDTO).forEach(repository::save);
    }
}
