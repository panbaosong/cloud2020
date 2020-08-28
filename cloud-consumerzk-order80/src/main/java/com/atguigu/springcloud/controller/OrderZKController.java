package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: liulonganys
 * @Date: 2020/8/28 11:47
 * @Description:
 */
@RestController
@Slf4j
public class OrderZKController {
    @Resource
    private RestTemplate restTemplate;

    public static final String INVOME_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String payment (){
        String result = restTemplate.getForObject(INVOME_URL+"/payment/zk",String.class);
        return result;
    }
}
