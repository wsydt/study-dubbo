package com.wsy.context;

import com.wsy.context.api.ContextService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.22
 */

public class ContextConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/consumer.xml");

        ContextService contextService = context.getBean(ContextService.class);
        for (int i = 0;i < 100;i++) {
            String result = contextService.sayHello("invoke " + i);
            System.out.println(result);
            Thread.sleep(500);
        }
    }

}
