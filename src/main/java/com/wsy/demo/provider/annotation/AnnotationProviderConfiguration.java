package com.wsy.demo.provider.annotation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.8
 */
@PropertySource("classpath:/dubbo/dubbo-provider.properties")
@EnableDubbo(scanBasePackages = "com.wsy.demo.provider")
public class AnnotationProviderConfiguration {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationProviderConfiguration.class);
        System.in.read();
    }

}
