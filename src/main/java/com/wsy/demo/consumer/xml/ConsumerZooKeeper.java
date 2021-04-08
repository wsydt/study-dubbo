package com.wsy.demo.consumer.xml;

import com.wsy.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.7
 */

public class ConsumerZooKeeper {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/consumer.xml");
        DemoService service = context.getBean(DemoService.class);
        System.out.println(service);
        String result = service.sayHello("wsy");
        System.out.println(result);
    }
}
