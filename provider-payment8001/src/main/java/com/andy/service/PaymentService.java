package com.andy.service;

import com.andy.entity.Payment;

public interface PaymentService {
    Payment findById(Long id);

    Integer insert(Payment payment);
}
