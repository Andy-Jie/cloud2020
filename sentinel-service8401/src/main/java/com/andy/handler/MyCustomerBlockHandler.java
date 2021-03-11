package com.andy.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.andy.entity.Payment;
import com.andy.entity.Result;

public class MyCustomerBlockHandler {

    public static Result<Payment> handlerException1(BlockException exception){
        return new Result<Payment>(400,exception.getMessage()+1);
    }

    public static Result<Payment> handlerException2(BlockException exception){
        return new Result<Payment>(400,exception.getMessage()+2);
    }

}
