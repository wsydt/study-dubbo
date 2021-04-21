package com.wsy.mock.impl;

import com.wsy.mock.api.DemoService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangshuangyong 2021.4.21
 */

@Slf4j
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        log.warn("demo service invoke, args : " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

    @Override
    public String sayHello1(String name) {
        log.warn("demo service invoke, args : " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello1 " + name;
    }
}
