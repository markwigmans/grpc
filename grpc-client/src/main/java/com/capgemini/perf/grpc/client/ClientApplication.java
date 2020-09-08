package com.capgemini.perf.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(proxyBeanMethods = false, exclude = SpringDataWebAutoConfiguration.class)
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
