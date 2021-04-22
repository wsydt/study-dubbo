package com.wsy.demo.consumer.xml;

import com.wsy.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author wangshuangyong 2021.4.7
 */

public class ConsumerZooKeeper {

    public static void main(String[] args) throws IOException {
        //zookeeper 单机
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/consumer.xml");
        //zookeeper 集群
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/consumer-cluster.xml");
        DemoService service = (DemoService) context.getBean("demoService");
        System.out.println(service);
//        String result = service.sayHello("wsy");
//        System.out.println(result);
        List<String> nameList = service.getName();
        System.out.println(nameList);
        DemoService service1 = (DemoService) context.getBean("demoService1");
        System.out.println(service);
        String result1 = service1.sayHello("wsy");
        System.out.println(result1);
        System.in.read();
    }
}
