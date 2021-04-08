package com.wsy.demo.consumer.annotation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wangshuangyong 2021.4.8
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.wsy.demo.consumer")
@PropertySource("classpath:dubbo/dubbo-consumer.properties")
@ComponentScan(basePackages = "com.wsy.demo.consumer")
public class AnnotationConsumerConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigApplicationContext.class);
        AnnotationDemoAction action = context.getBean(AnnotationDemoAction.class);
        String result = action.sayHello("xyy");
        System.out.println(result);
        context.close();
    }

}
