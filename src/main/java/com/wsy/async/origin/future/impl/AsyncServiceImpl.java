package com.wsy.async.origin.future.impl;

import com.wsy.async.origin.future.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.log4j.Logger;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncServiceImpl implements AsyncService {

    private Logger logger = Logger.getLogger(AsyncServiceImpl.class);

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext context = RpcContext.getContext();
        RpcContext serverContext = RpcContext.getServerContext();
        return CompletableFuture.supplyAsync(() -> {
            String receive = context.getAttachment("consumer-key1");
            logger.info("attachment key from consumer : " + receive);
            serverContext.setAttachment("provider-key1", "server-" + receive);

            receive = context.getAttachment("filters");
            logger.info("filters from consumer attachment : " + receive);
            serverContext.setAttachment("filters", receive);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "async response from provider";
        });

    }
}
