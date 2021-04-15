package com.wsy.demo.springboot.consumer;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshuangyong 2021.4.12
 */

@RestController
@RequestMapping("/demo")
public class DemoAction {

    @DubboReference
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        System.out.println("************************receive name : " + name);
        return demoService.sayHello(name);
    }

}
