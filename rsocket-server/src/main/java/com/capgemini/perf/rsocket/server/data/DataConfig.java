package com.capgemini.perf.rsocket.server.data;

import com.capgemini.perf.rsocket.server.api.CustomerMapper;
import com.capgemini.perf.shared.util.DataSetGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataConfig implements ApplicationListener<ApplicationReadyEvent> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        DataSetGenerator.dataSet("Json").stream().map(mapper::fromDTO).forEach(repository::save);
    }
}
