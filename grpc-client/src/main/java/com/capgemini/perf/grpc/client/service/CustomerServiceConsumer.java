package com.capgemini.perf.grpc.client.service;

import com.capgemini.perf.grpc.client.api.CustomerResponseMapper;
import com.capgemini.perf.lib.data.CustomerDTO;
import com.capgemini.perf.lib.proto.*;
import com.capgemini.perf.lib.proto.CustomerServiceGrpc.CustomerServiceBlockingStub;
import com.capgemini.perf.lib.util.EurekaUtil;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.stream.Collectors;

@EnableEurekaClient
@Component
public class CustomerServiceConsumer implements CustomerService {

    @Autowired
    private EurekaClient client;

    private CustomerServiceBlockingStub blockingStub;

    @PostConstruct
    void init() {
        // TODO remove from postconstruct
        final InstanceInfo instanceInfo = EurekaUtil.waitForRegistrationWithEureka(client, "grpc-server");
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort())
                .usePlaintext()
                .build();
        blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public Iterable<CustomerDTO> all() {
        final CustomersResponse response = blockingStub.all(Empty.newBuilder().build());
        return response.getCustomersList().stream().map(CustomerResponseMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> find(Long id) {
        final CustomerResponse response = blockingStub.find(CustomerRequest.newBuilder().setId(id).build());
        return Optional.ofNullable(CustomerResponseMapper.MAPPER.toDTO(response));
    }
}
