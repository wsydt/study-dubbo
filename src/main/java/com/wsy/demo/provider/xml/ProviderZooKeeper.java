package com.wsy.demo.provider.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.7
 */

public class ProviderZooKeeper {

    public static void main(String[] args) throws IOException {
        //zookeeper 单机
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/provider.xml");
        //zookeeper 集群
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/provider-cluster.xml");
        System.in.read();
    }

}
