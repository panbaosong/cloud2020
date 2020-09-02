package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: liulonganys
 * @Date: 2020/9/2 09:24
 * @Description:
 *feign提供了日志打印功能，可以通过配置调整日志级别，了解Feign中Http请求的细节
 *
 * 对Feign接口的调用情况进行监控和输出
 *
 * NONE 默认的 不显示任何日志
 * BASIC 仅记录方法、URL、响应状态码及执行时间
 * HEADERS 除了BASIC中定义的信息之外，还有请求和响应的头信息
 * FULL 除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
 *
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
