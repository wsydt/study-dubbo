package com.wsy.demo.provider.api;

import com.wsy.demo.DemoService;
import com.wsy.demo.provider.DemoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import java.io.IOException;

/**
 * @author wangshuangyong 2021.4.9
 */

public class ApiProviderConfiguration {

    public static void main(String[] args) throws IOException {
//        classicExport();
        bootstrapExport();
    }

    private static void classicExport() throws IOException {
        DemoService demoService = new DemoServiceImpl();

        ApplicationConfig application = new ApplicationConfig("api-provider");

        RegistryConfig registry = new RegistryConfig("zookeeper://localhost:2181");

        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20000);
        protocol.setThreads(200);

        ServiceConfig<DemoService> service = new ServiceConfig<>();
        service.setRegistry(registry);
//        service.setProtocol(protocol);
        service.setRef(demoService);
        service.setInterface(DemoService.class);
        service.setApplication(application);

        service.export();
        System.out.println("service started!");
        System.in.read();
    }

    private static void bootstrapExport(){
        ServiceConfig<DemoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setRef(new DemoServiceImpl());
        serviceConfig.setInterface(DemoService.class);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("bootstrap-provider"))
                .registry(new RegistryConfig("zookeeper://localhost:2181"))
                .service(serviceConfig)
                .start()
                .await();
    }


}
