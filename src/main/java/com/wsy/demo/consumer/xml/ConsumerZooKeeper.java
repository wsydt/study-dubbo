package com.wsy.demo.consumer.xml;

import com.wsy.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.7
 */

public class ConsumerZooKeeper {

    public static void main(String[] args) throws IOException {
        //zookeeper 单机
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/consumer.xml");
        //zookeeper 集群
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/consumer-cluster.xml");
        DemoService service = context.getBean(DemoService.class);
        System.out.println(service);
        String result = service.sayHello("wsy");
        System.out.println(result);
        System.in.read();
    }
}
