package com.wsy.generic.impl;

import com.wsy.generic.impl.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.22
 */

public class GenericImplConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("generic/impl/consumer.xml");

        HelloService helloService = context.getBean(HelloService.class);
        try {
            String yy = helloService.sayHello("yy");
            System.out.println(yy);
        } catch (Exception e) {
            System.out.println("sayHello invoke failed!");
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CompletableFuture<String> yy2 = helloService.sayHelloAsync("yy2");
        yy2.whenComplete((value, throwable) -> {
            System.out.println("sayHelloAsync :  " + value);
            countDownLatch.countDown();
        });
        countDownLatch.await();

        String yy3 = helloService.notImplementedHello("yy3");
        System.out.println(yy3);

    }
}
