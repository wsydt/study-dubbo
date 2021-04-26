package com.wsy.async.generated.future.impl;

import com.wsy.async.generated.future.api.GreetingService;

/**
 * @author wangshuangyong 2021.4.26
 */

public class GreetingServiceImpl implements GreetingService {


    @Override
    public String greeting(String name) {
        System.out.println("provider receive : " + name);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("provider returned.");
        return replayGreeting(name);
    }

}
