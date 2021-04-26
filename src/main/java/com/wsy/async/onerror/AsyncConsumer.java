package com.wsy.async.onerror;

import com.wsy.async.onerror.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author wangshuangyong 2021.4.26
 */

public class AsyncConsumer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/onerror/consumer.xml");

        AsyncService asyncService = context.getBean(AsyncService.class);

        asyncService.sayHello("world");
        CompletableFuture<String> f = RpcContext.getContext().getCompletableFuture();
        f.whenComplete((value, exception) -> {
            if (exception == null) {
                System.out.println("sayHello return : " + value);
            } else {
                System.out.println("sayHello exception : " + exception);
            }
        });

        System.out.println("before invoke ........");
        asyncService.sayHelloTimeout("timeout world");
        System.out.println("after invoke ........");
        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        String result = future.get();
        System.out.println(result);
        new CountDownLatch(1).await();
    }

}
