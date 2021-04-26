package com.wsy.async.generated.future;

import com.wsy.async.generated.future.api.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangshuangyong 2021.4.26
 */

public class AsyncConsumer {

    private static final byte signal = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/generated/future/consumer.xml");

        GreetingService greetingService = context.getBean(GreetingService.class);
        CompletableFuture<String> future = greetingService.greeting("async request call", signal);
        System.out.println("async call return : " + future.get());

        System.out.println("normal call return : " + greetingService.greeting("normal request call"));


    }

}
