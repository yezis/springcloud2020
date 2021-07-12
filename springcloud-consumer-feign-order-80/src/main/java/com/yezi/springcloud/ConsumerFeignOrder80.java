package com.yezi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages={"com.yezi.springcloud.service"})
public class ConsumerFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrder80.class, args);
    }
}
