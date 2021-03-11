package com.andy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {

/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

//        int age = 10/0;
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "hotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p",required = false) String p
            ,@RequestParam(value = "p1",required = false) String p1){
        int age =10/0;
        return p+p1;
    }

    public String deal_testHotKey(String p , String p1, BlockException exception){
        return p+p+p1+p1;
    }

}
