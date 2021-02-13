package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamRabbitMQProvider8801 {

    public static void main(String[] args) {

        SpringApplication.run(StreamRabbitMQProvider8801.class, args);

    }

}
