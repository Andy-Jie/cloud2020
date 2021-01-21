package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerFeignHystrixOrder80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerFeignHystrixOrder80.class, args);

    }

}
