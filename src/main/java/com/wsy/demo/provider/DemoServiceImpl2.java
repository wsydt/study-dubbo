package com.wsy.demo.provider;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getName() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("忘记");
        nameList.add("就是我");
        nameList.add("伟大的渺小");
        nameList.add("过");
        return nameList;
    }
}
