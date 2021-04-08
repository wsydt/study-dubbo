package com.wsy.demo.consumer.annotation;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @author wangshuangyong 2021.4.8
 */

@Component
public class AnnotationDemoAction {

    @DubboReference
    private DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

}
