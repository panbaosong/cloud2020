package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: liulonganys
 * @Date: 2020/8/26 16:34
 * @Description:
 *  RestTemplate是Spring用于同步client端的核心类，简化了与http服务的通信，
 *  并满足RestFul原则，程序代码可以给它提供URL，并提取结果。默认情况下，
 *  RestTemplate默认依赖jdk的HTTP连接工具。当然你也可以
 *  通过setRequestFactory属性切换到不同的HTTP源，比如Apache HttpComponents、Netty和OkHttp。
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
