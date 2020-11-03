package com.capgemini.perf.grpc.intermediate.api;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;

@GRpcGlobalInterceptor
@Slf4j
public class LogGrpcInterceptor implements ServerInterceptor {


    @Override
    public <Q, S> ServerCall.Listener<Q> interceptCall(ServerCall<Q, S> call, Metadata headers,
                                                       ServerCallHandler<Q, S> serverCallHandler) {
        log.info(call.getMethodDescriptor().getFullMethodName());
        return serverCallHandler.startCall(call, headers);
    }
}
