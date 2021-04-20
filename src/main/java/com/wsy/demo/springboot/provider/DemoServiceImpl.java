package com.wsy.demo.springboot.provider;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangshuangyong 2021.4.6
 */

@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("get name : " + name);
        return "Hello " + name + "!!!";
    }

    @Override
    public List<String> getName() {
        List<String> nameList = new ArrayList<>();
        nameList.add("对的时间点");
        return nameList;
    }
}

