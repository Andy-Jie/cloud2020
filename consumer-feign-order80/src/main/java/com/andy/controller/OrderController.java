package com.andy.controller;

import com.andy.entity.Payment;
import com.andy.entity.Result;
import com.andy.feign.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("/{id}")
    public Result<Payment> get(@PathVariable("id")Long id){
        Result<Payment> result = paymentClient.findOne(id);
        return result;
    }

    @GetMapping("/timeout")
    public Result<Payment> timeout(){
        Result<Payment> timeout = paymentClient.timeout();
        return timeout;
    }

}
