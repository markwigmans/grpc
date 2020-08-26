package com.capgemini.perf.grpc.server.api;

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
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        log.info(call.getMethodDescriptor().getFullMethodName());
        return serverCallHandler.startCall(call, headers);
    }
}
