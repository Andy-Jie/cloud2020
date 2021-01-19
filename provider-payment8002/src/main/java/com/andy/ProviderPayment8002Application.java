package com.andy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.andy.mapper")
public class ProviderPayment8002Application {

    public static void main(String[] args) {

        SpringApplication.run(ProviderPayment8002Application.class , args);

    }

}
