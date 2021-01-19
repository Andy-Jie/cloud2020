package com.andy.comtroller;

import com.andy.entity.Payment;
import com.andy.entity.Result;
import com.andy.service.PaymentService;
import com.andy.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public Result<Payment> findOne(@PathVariable("id") Long id) {

        Payment payment = paymentService.findById(id);

        if (null != payment) {
            return Result.ok(200, "查询成功"+port, payment);
        }else {
            return Result.error(400, "查询失败:"+id);
        }
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Payment payment){
        Integer row = paymentService.insert(payment);

        if (row > 0){
            return Result.ok(200,"插入成功",row);
        }else {
            return Result.error(400,"插入失败");
        }

    }

    @GetMapping("/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();

        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");

        instances.forEach(instance->{
            System.out.println(instance.getServiceId()+"---"+instance.getHost()+"---"+instance.getPort()+"---"+instance.getUri());
        });

        return discoveryClient;
    }

}
