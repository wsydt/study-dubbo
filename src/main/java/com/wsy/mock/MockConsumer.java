package com.wsy.mock;

import com.wsy.mock.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.21
 */

public class MockConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mock/consumer.xml");
        DemoService demoService = context.getBean(DemoService.class);
        String result = demoService.sayHello1("mock service");
        System.out.println(result);
        result = demoService.sayHello("mock service");
        System.out.println(result);
    }

}
