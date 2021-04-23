package com.wsy.context.impl;

import com.wsy.context.api.HelloService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author wangshuangyong 2021.4.23
 */

public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        String clientIP = RpcContext.getContext().getRemoteHost();
        String remoteApplication = RpcContext.getContext().getRemoteApplicationName();
        String application = RpcContext.getContext().getUrl().getParameter("application");

        return "Hello " + name + ", response from provider ： " + RpcContext.getContext().getLocalAddress()
                + ", client : " + clientIP + ", local : " + application + ", remote : " + remoteApplication
                + ", isProviderSide : " + isProviderSide;
    }
}
