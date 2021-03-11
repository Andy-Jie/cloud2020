package com.andy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.andy.entity.Payment;
import com.andy.entity.Result;
import com.andy.handler.MyCustomerBlockHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/bySource")
    @SentinelResource(value = "bySource", blockHandler = "exception1")
    public Result bySource() {
        return new Result<Payment>(200, "成功", new Payment(1L, "奥迪"));
    }

    public Result exception1(BlockException exception) {
        return new Result(400, exception.getMessage());
    }

    @GetMapping("/bySource1")
    @SentinelResource(value = "bySource1")
    public Result bySource1() {
        return new Result<Payment>(200, "成功", new Payment(1L, "奥迪"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customer",blockHandlerClass = MyCustomerBlockHandler.class,blockHandler = "handlerException2")
    public Result<Payment> customerBlockHandler(){
        return new Result<Payment>(200,"成功",new Payment(1L,"奥迪"));
    }

}
