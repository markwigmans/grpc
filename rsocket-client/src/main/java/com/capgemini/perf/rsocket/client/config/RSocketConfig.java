package com.capgemini.perf.rsocket.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
@Slf4j
public class RSocketConfig {

    @Value("${rsocket.server.host:localhost}")
    private String host;
    @Value("${rsocket.server.port:7000}")
    private int port;


    @Bean
    RSocketRequester socketRequester(RSocketRequester.Builder builder) {
        var requester = builder.connectTcp(host, port).retry().block();

        requester.rsocket()
                .onClose()
                .doOnError(error -> log.warn("Connection CLOSED"))
                .doFinally(consumer -> log.info("Client DISCONNECTED"))
                .subscribe();

        return requester;
    }
}
