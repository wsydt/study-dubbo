package com.wsy.validation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 *  dubbo 参数验证
 * @author wangshuangyong 2021.4.20
 */

public class ValidationProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("validation/provider.xml");
        new CountDownLatch(1).await();

    }

}
