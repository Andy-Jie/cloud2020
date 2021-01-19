package com.andy.service.impl;

import com.andy.entity.Payment;
import com.andy.mapper.PaymentMapper;
import com.andy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment findById(Long id) {
        return paymentMapper.selectById(id);
    }

    @Override
    public Integer insert(Payment payment) {
        return paymentMapper.insert(payment);
    }
}
