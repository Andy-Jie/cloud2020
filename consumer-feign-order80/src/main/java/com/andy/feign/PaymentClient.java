package com.andy.feign;

import com.andy.entity.Payment;
import com.andy.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/payment")
@FeignClient("PAYMENT-SERVICE")
public interface PaymentClient {

    @GetMapping("/{id}")
    public Result<Payment> findOne(@PathVariable("id") Long id);

    @GetMapping("/timeout")
    public Result<Payment> timeout();
}
