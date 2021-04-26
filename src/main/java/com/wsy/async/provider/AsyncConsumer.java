package com.wsy.async.provider;

import com.wsy.async.provider.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async/provider/consumer.xml");

        RpcContext.getContext().setAttachment("consumer-key1", "consumer-value1");
        AsyncService asyncService = context.getBean(AsyncService.class);
        System.out.println(asyncService.sayHello("async call request"));
    }

}
