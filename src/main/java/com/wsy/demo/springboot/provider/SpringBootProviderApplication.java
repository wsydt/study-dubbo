package com.wsy.demo.springboot.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangshuangyong 2021.4.9
 */

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.wsy.demo.springboot.provider")
public class SpringBootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProviderApplication.class, args);
    }

}
