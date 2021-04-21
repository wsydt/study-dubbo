package com.wsy.callback;

import com.wsy.callback.api.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.21
 */

public class CallbackConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("callback/consumer.xml");

        CallbackService callbackService = context.getBean(CallbackService.class);
        callbackService.addListener("callback", System.out::println);
        System.out.println("consumer end.");
        new CountDownLatch(1).await();
    }

}
