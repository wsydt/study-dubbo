package com.wsy.async.simple;

import com.wsy.async.simple.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncConsumer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/simple/consumer.xml");

        AsyncService asyncService = context.getBean(AsyncService.class);
        asyncService.sayHello("async world");

        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.whenComplete((value, exception) -> {
           if (exception == null) {
               System.out.println("return value : " + value);
           } else {
               exception.printStackTrace();
           }
        });

        CompletableFuture<String> f = RpcContext.getContext().asyncCall(() -> asyncService.sayHello("async call request"));
        System.out.println("async call return : " + f.get());

        RpcContext.getContext().asyncCall(() -> {
            asyncService.sayHello("async world");
        });

    }

}
