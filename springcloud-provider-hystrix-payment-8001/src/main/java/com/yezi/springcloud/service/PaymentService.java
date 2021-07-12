package com.yezi.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "defaultFallBack")
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程： " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
        long time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程： " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + "  耗时(s)：" + time;
    }

    public String paymentInfo_TimeOutFallBack(Integer id) {
        return "线程： " + Thread.currentThread().getName() + " 这个请求超时或者出错，请稍后再试 id: " + id;
    }

    public String defaultFallBack() {
        return "这是一个默认的降级提示方法";
    }



}
