package com.yezi.springcloud.service.fallback;

import com.yezi.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "payment_OK 降级处理";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "payment_TimeOut 降级处理";
    }
}
