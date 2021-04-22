package com.wsy.demo.consumer.api;

import com.wsy.demo.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author wangshuangyong 2021.4.9
 */

public class ApiConsumerConfiguration {

    public static void main(String[] args) {
//        classicReference();
        bootstrapReference();
    }

    private static void classicReference() {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
//        reference.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
        reference.setInterface(DemoService.class);
        reference.setApplication(new ApplicationConfig("api-consumer"));
        //点对点直连
        reference.setUrl("dubbo://localhost:30020");
        DemoService demoService = reference.get();
        String result = demoService.sayHello("api remote call");
        System.out.println(result);
    }

    private static void bootstrapReference(){
        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(DemoService.class);
        referenceConfig.setGeneric("true");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("bootStrap-consumer"))
                .registry(new RegistryConfig("zookeeper://localhost:2181"))
                .reference(referenceConfig);
        DemoService demoService = referenceConfig.get();
        String result = demoService.sayHello("bootstrap-consumer");
        System.out.println(result);

        GenericService genericService = (GenericService) demoService;
        Object genericResult = genericService.$invoke("sayHello", new String[]{String.class.getName()}, new Object[]{"genericService"});
        System.out.println(genericResult);
    }

}
