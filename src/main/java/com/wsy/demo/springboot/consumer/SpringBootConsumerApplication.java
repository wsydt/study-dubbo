package com.wsy.demo.springboot.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangshuangyong 2021.4.9
 */

@SpringBootApplication
//@EnableDubbo(scanBasePackages = "com.wsy.demo.springboot.consumer")
public class SpringBootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumerApplication.class, args);
    }

}
