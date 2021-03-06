package com.capgemini.perf.grpc.intermediate.api;

import com.capgemini.perf.grpc.intermediate.service.CustomerService;
import com.capgemini.perf.shared.data.CustomerDTO;
import com.capgemini.perf.shared.proto.*;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@GRpcService
@RequiredArgsConstructor
public class GrpcServerService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    @Override
    public void all(Empty request, io.grpc.stub.StreamObserver<CustomersResponse> responseObserver) {
        final Iterable<CustomerDTO> customers = customerService.all();
        final CustomersResponse.Builder builder = CustomersResponse.newBuilder();
        StreamSupport.stream(customers.spliterator(), false).map(mapper::fromDTO).forEach(builder::addCustomers);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void find(CustomerRequest request, io.grpc.stub.StreamObserver<CustomerResponse> responseObserver) {
        final Optional<CustomerDTO> customer = customerService.find(request.getId());
        final CustomerResponse.Builder builder = CustomerResponse.newBuilder();
        customer.ifPresent(value -> builder.setId(value.getId())
                .setUserId(value.getUserId())
                .setRef(value.getRef())
                .setName(value.getName()));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
