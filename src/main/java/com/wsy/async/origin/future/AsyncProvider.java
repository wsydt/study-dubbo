package com.wsy.async.origin.future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/async/origin/future/provider.xml");
        new CountDownLatch(1).await();
    }

}
