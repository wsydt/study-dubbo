package com.wsy.demo.provider;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author wangshuangyong 2021.4.6
 */

@DubboService
public class DemoServiceImpl2 implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("get name : " + name);
        return "Hello " + name + "!!!, version : 2.0";
    }
}
