package com.wsy.generic.impl.impl;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.22
 */

public class GenericImplOfHelloService implements GenericService {


    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if (method.equals("sayHello")) {
            System.out.println("executing sayHello. ");
            throw new RuntimeException("sayHello throws exception");
        } else if (method.equals("sayHelloAsync")) {
            System.out.println("executing sayHelloAsync. ");
            return CompletableFuture.completedFuture("sayHelloAsync : Hello " + args[0]);
        } else {
            try {
                return defaultOperation(method, parameterTypes, args);
            } catch (Exception e) {
                System.out.println("*****************************failed******************");
                throw new GenericException(e);
            }
        }
    }

    private Object defaultOperation(String method, String[] parameterTypes, Object[] args) {
        throw new UnsupportedOperationException("method does not exist");
    }
}
