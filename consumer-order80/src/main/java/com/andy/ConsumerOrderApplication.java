package com.andy;

import com.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "PAYMENT-SERVICE",configuration = MyRule.class)
public class ConsumerOrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerOrderApplication.class,args);

    }

}
