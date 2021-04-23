package com.wsy.context.impl;

import com.wsy.context.api.ContextService;
import com.wsy.context.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;

import javax.annotation.Resource;

/**
 * @author wangshuangyong 2021.4.22
 */

public class ContextServiceImpl implements ContextService {

    @Resource
    private HelloService helloService;

    @Override
    public String sayHello(String name) {
        // RpcContext 上下文信息会在每次调用发生变化
        // 比如：A 调 B，B 再调 C，则 B 机器上，在 B 调 C 之前，RpcContext 记录的是 A 调 B 的信息，在 B 调 C 之后，RpcContext 记录的是 B 调 C 的信息。
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        String clientIP = RpcContext.getContext().getRemoteHost();
        String remoteApplication = RpcContext.getContext().getRemoteApplicationName();
        String application = RpcContext.getContext().getUrl().getParameter("application");
        String hello = "Hello " + name + ", response from provider ： " + RpcContext.getContext().getLocalAddress()
                + ", client : " + clientIP + ", local : " + application + ", remote : " + remoteApplication
                + ", isProviderSide : " + isProviderSide;
        System.out.println(hello);
        String result = helloService.hello(name);
        clientIP = RpcContext.getContext().getRemoteHost();
        remoteApplication = RpcContext.getContext().getRemoteApplicationName();
        application = RpcContext.getContext().getUrl().getParameter("application");
        isProviderSide = RpcContext.getContext().isProviderSide();
        return "Hello " + name + ", response from provider ： " + RpcContext.getContext().getLocalAddress()
                + ", client : " + clientIP + ", local : " + application + ", remote : " + remoteApplication
                + ", isProviderSide : " + isProviderSide;
    }
}
