package com.wsy.demo.consumer.xml;

import com.wsy.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.6
 */

public class Consumer {

    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        DemoService demo = (DemoService) context.getBean("demoService");
//        Thread.sleep(120000);
        String result = demo.sayHello("tdy");
        System.out.println(result);
//        System.in.read();

    }
}
