package com.wsy.async.simple.impl;

import com.wsy.async.simple.api.AsyncService;

/**
 * @author wangshuangyong 2021.4.25
 */

public class AsyncServiceImpl implements AsyncService {

    @Override
    public String sayHello(String name) {
        System.out.println("async provider received: " + name);
        return "hello, " + name;
    }
}
