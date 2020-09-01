package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: liulonganys
 * @Date: 2020/9/1 16:50
 * @Description:
 * Feign集成了Ribbon，只需要创建一个接口 并使用注解的方式来配置它
 *
 *  Feign在消费端使用
 *
 * 微服务调用接口 + @FeignClient
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
