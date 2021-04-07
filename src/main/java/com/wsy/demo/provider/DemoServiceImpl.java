package com.wsy.demo.provider;

import com.wsy.demo.DemoService;

/**
 * @author wangshuangyong 2021.4.6
 */

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("get name : " + name);
        return "Hello " + name + "!!!";
    }
}
