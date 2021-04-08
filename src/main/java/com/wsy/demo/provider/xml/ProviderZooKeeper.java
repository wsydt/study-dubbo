package com.wsy.demo.provider.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.7
 */

public class ProviderZooKeeper {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("zookeeper/provider.xml");
        System.in.read();
    }

}
