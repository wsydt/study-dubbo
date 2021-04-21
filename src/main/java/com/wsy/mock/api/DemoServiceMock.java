package com.wsy.mock.api;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangshuangyong 2021.4.21
 */

@Slf4j
public class DemoServiceMock implements DemoService {
    @Override
    public String sayHello(String name) {
        log.warn("about to execute mock: " + DemoServiceMock.class.getSimpleName());
        return "mock " + name;
    }

    @Override
    public String sayHello1(String name) {
        log.warn("about to execute mock1: " + DemoServiceMock.class.getSimpleName());
        return "mock1 " + name;
    }
}
