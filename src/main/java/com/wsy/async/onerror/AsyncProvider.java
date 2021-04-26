package com.wsy.async.onerror;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.26
 */

public class AsyncProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/onerror/provider.xml");
        new CountDownLatch(1).await();
    }

}
