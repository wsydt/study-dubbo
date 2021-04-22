package com.wsy.notify.impl;

import com.wsy.notify.api.DemoService;

/**
 * @author wangshuangyong 2021.4.21
 */

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(int id) {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (id > 10 ) {
            throw new RuntimeException("the id is too large!");
        }
        return "hello id " + id;
    }
}
