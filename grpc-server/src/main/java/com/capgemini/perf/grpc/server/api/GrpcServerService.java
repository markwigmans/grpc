package com.capgemini.perf.grpc.server.api;

import com.capgemini.perf.grpc.server.data.Customer;
import com.capgemini.perf.grpc.server.service.CustomerService;
import com.capgemini.perf.lib.proto.*;
import org.lognet.springboot.grpc.GRpcService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@GRpcService
public class GrpcServerService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private final CustomerService customerService;

    GrpcServerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void all(Empty request, io.grpc.stub.StreamObserver<CustomersResponse> responseObserver) {
        final Iterable<Customer> customers = customerService.all();
        final List<CustomerResponse> dtos = StreamSupport.stream(customers.spliterator(), false)
                .map(CustomerMapper.MAPPER::customerToCustomerDTO)
                .collect(Collectors.toList());
        final CustomersResponse reply = CustomersResponse.newBuilder().addAllCustomers(dtos).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void find(CustomerRequest request, io.grpc.stub.StreamObserver<CustomerResponse> responseObserver) {
        final Optional<Customer> customer = customerService.find(request.getId());
        final CustomerResponse.Builder builder = CustomerResponse.newBuilder();
        if (customer.isPresent()) {
            builder.setId(customer.get().getId())
                    .setFirstName(customer.get().getFirstName())
                    .setLastName(customer.get().getLastName());
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
