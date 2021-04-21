package com.wsy.notify.impl;

import com.wsy.notify.api.DemoService;

/**
 * @author wangshuangyong 2021.4.21
 */

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(int id) {
        if (id > 10 ) {
            throw new RuntimeException("the id is too large!");
        }
        return "hello id " + id;
    }
}
