package com.wsy.async.provider.impl;

import com.wsy.async.provider.api.AsyncService;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.log4j.Logger;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncServiceImpl implements AsyncService {

    Logger logger = Logger.getLogger(AsyncServiceImpl.class);

    @Override
    public String sayHello(String name) {
        AsyncContext asyncContext = RpcContext.startAsync();
        logger.info("sayHello start");
        new Thread(() -> {
            asyncContext.signalContextSwitch();
            logger.info("Attachment from consumer : " + RpcContext.getContext().getAttachment("consumer-key1"));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asyncContext.write("Hello " + name + ", response from provider");
            logger.info("async end");
        }).start();
        return "hello " + name;
    }
}
