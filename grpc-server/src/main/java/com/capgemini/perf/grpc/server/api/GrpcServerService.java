package com.capgemini.perf.grpc.server.api;

import com.capgemini.perf.grpc.server.data.Customer;
import com.capgemini.perf.grpc.server.service.CustomerService;
import com.capgemini.perf.lib.proto.*;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@GRpcService
@RequiredArgsConstructor
public class GrpcServerService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    public void all(Empty request, io.grpc.stub.StreamObserver<CustomersResponse> responseObserver) {
        final Iterable<Customer> customers = customerService.all();
        final CustomersResponse.Builder builder = CustomersResponse.newBuilder();
        StreamSupport.stream(customers.spliterator(), false).map(customerMapper::toDTO).forEach(builder::addCustomers);
        responseObserver.onNext( builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void find(CustomerRequest request, io.grpc.stub.StreamObserver<CustomerResponse> responseObserver) {
        final Optional<Customer> customer = customerService.find(request.getId());
        final CustomerResponse.Builder builder = CustomerResponse.newBuilder();
        customer.ifPresent(value -> builder.setId(value.getId())
                .setFirstName(value.getFirstName())
                .setLastName(value.getLastName()));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
