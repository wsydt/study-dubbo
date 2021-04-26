package com.wsy.async.onerror.impl;

import com.wsy.async.onerror.api.AsyncService;

/**
 * @author wangshuangyong 2021.4.26
 */

public class AsyncServiceImpl implements AsyncService {
    @Override
    public String sayHello(String name) {
        System.out.println("provider receive : " + name);
        return "hello : " + name;
    }

    @Override
    public String sayHelloTimeout(String name) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "method invoke timeout";
    }
}
