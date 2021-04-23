package com.wsy.context;

import com.wsy.context.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.22
 */

public class ContextProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/provider.xml");
        HelloService bean = context.getBean(HelloService.class);
        bean.hello("ss");
        new CountDownLatch(1).await();
    }

}
