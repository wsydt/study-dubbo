package com.wsy.async.origin.future;

import com.wsy.async.origin.future.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncConsumer {

    private static Logger logger = Logger.getLogger(AsyncConsumer.class);

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/origin/future/consumer.xml");

        AsyncService asyncService = context.getBean(AsyncService.class);
        RpcContext rpcContext = RpcContext.getContext();
        RpcContext serverContext = RpcContext.getServerContext();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        rpcContext.setAttachment("consumer-key1", "consumer-value1");
        CompletableFuture<String> future = asyncService.sayHello("call request origin future");
        future.whenComplete((value, t) -> {
            System.out.println(serverContext.getAttachment("provider-key1"));
            if(t == null) {
                logger.info("response : " + value);
            } else {
                logger.error("Exception : ", t);
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
    }

}
