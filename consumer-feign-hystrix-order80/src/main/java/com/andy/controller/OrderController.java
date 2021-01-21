package com.andy.controller;

import com.andy.client.PaymentClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
//@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderController {

    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id){
        return paymentClient.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="6000")
//    })
//    @HystrixCommand
    public String timeout(@PathVariable("id") Integer id){
//        int i = 10/0;
        return paymentClient.paymentInfo_TimeOut(id);
    }

    public String timeoutFallback(@PathVariable("id") Integer id){
        return "系统繁忙";
    }

    public String globalFallbackMethod(){
        return "globalFallbackMethod";
    }


}
