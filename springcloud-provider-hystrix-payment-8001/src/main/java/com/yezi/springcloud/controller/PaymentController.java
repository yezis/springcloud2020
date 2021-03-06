package com.yezi.springcloud.controller;

import com.yezi.springcloud.service.PaymentService;
import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_OK(id);
        log.info("*******ok result " + res);
        return res;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_TimeOut(id);
        log.info("*******timeout result " + res);
        return res;
    }

}
