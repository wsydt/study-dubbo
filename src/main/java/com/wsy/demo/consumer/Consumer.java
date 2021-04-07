package com.wsy.demo.consumer;

import com.wsy.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.6
 */

public class Consumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DemoService demo = (DemoService) context.getBean("demoService");
        Thread.sleep(120000);
        String result = demo.sayHello("tdy");
        System.out.println(result);

    }
}
