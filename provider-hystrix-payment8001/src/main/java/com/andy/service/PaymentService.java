package com.andy.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    String paymentInfoOK(Integer id);

    String paymentInfoTimeOut(Integer id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
