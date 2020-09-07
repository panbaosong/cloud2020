package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"                                   ， paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    //失败
    /**
    * @Description: 服务端出错 响应时间长 自我fallback降级
    * @Param: [id]
    * @return: java.lang.String
    * @Author: liulonganys
    * @Date: 2020/9/3
    */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
//        int age = 10/0;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        System.out.println(id);
        return "o(╥﹏╥)o调用接口超时或异常，当前线程池名字："+Thread.currentThread().getName();
    }
}


