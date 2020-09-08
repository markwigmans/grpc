package com.capgemini.perf.json.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(proxyBeanMethods = false, exclude = SpringDataWebAutoConfiguration.class)
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
