package com.capgemini.perf.grpc.client.service;

import com.capgemini.perf.grpc.client.api.CustomerMapper;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.proto.*;
import com.capgemini.perf.shared.proto.CustomerServiceGrpc.CustomerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.sleuth.instrument.grpc.SpringAwareManagedChannelBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerServiceConsumer implements CustomerService, ApplicationListener<ApplicationReadyEvent> {

    private CustomerServiceBlockingStub blockingStub;
    private final CustomerMapper mapper;
    private final SpringAwareManagedChannelBuilder builder;

    @Value("${grpc.server.host:localhost}")
    private String host;
    @Value("${grpc.server.port:6565}")
    private int port;

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        final ManagedChannel channel = builder.forAddress(host, port).usePlaintext().build();
        blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public Iterable<CustomerDTO> all() {
        final CustomersResponse response = blockingStub.all(Empty.newBuilder().build());
        return response.getCustomersList().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> find(int id) {
        final CustomerResponse response = blockingStub.find(CustomerRequest.newBuilder().setId(id).build());
        return Optional.ofNullable(mapper.toDTO(response));
    }
}
