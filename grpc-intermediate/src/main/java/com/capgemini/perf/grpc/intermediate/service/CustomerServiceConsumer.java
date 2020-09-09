package com.capgemini.perf.grpc.intermediate.service;

import com.capgemini.perf.grpc.intermediate.api.CustomerMapper;
import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.proto.*;
import com.capgemini.perf.lib.proto.CustomerServiceGrpc.CustomerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerServiceConsumer implements CustomerService, ApplicationListener<ApplicationReadyEvent> {

    private CustomerServiceBlockingStub blockingStub;
    private final CustomerMapper mapper;

    @Value("${grpc.server.host:localhost}")
    private String host;
    @Value("${grpc.server.port:6565}")
    private int port;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public Iterable<CustomerDTO> all() {
        final CustomersResponse response = blockingStub.all(Empty.newBuilder().build());
        return response.getCustomersList().stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> find(int id) {
        final CustomerResponse response = blockingStub.find(CustomerRequest.newBuilder().setId(id).build());
        return Optional.ofNullable(mapper.toDTO(response));
    }
}
