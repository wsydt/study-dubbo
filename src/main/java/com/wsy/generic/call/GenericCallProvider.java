package com.wsy.generic.call;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.22
 */

public class GenericCallProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("generic/call/provider.xml");
        new CountDownLatch(1).await();
    }

}
