package com.andy.controller;

import com.andy.entity.Payment;
import com.andy.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String URL = "http://PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(URL+"/payment/zipkin",String.class);
        return result;
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "payment/" + id, Result.class, id);
    }

    @GetMapping("/2/{id}")
    public Result findById2(@PathVariable("id") Long id) {
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(URL + "payment/" + id, Result.class, id);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println(forEntity);
            return forEntity.getBody();
        }else {
            return Result.error(400,"查询失败");
        }
    }

    @GetMapping("/insert")
    public Result insert(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL + "payment", payment, Result.class);
    }

}
