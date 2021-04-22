package com.wsy.generic.impl.api;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.22
 */

public interface HelloService {

    String sayHello(String name);

    CompletableFuture<String> sayHelloAsync(String name);

    String notImplementedHello(String name);

}
