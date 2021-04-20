package com.wsy.demo.provider;

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
        return "Hello " + name + "!!!, version : 1.0";
    }

    @Override
    public List<String> getName() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("醉赤壁");
        nameList.add("爱笑的眼睛");
        nameList.add("小酒窝");
        nameList.add("曹操");
        nameList.add("记得");
        return nameList;
    }
}
