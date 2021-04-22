package com.wsy.generic.impl;

import com.wsy.generic.impl.impl.GenericImplOfHelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangshuangyong 2021.4.22
 */

public class GenericImplProvider {

    public static void main(String[] args) {
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        ServiceConfig<GenericService> service = new ServiceConfig<>();
        service.setInterface("com.wsy.generic.impl.api.HelloService");
        service.setRef(new GenericImplOfHelloService());
        bootstrap.application(new ApplicationConfig("generic-impl-provider"))
                .registry(new RegistryConfig("zookeeper://localhost:2181"))
                .service(service)
                .start()
                .await();

    }

}
