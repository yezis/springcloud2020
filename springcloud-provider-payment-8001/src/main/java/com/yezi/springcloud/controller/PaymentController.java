package com.yezi.springcloud.controller;

import com.yezi.springcloud.entities.CommonResult;
import com.yezi.springcloud.entities.Payment;
import com.yezi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        }
        else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查出结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询数据成功", payment);
        }
        else {
            return new CommonResult(444, "没有对应记录：" + id, null);
        }
    }

}
