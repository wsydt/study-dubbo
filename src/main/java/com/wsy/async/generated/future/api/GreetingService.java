package com.wsy.async.generated.future.api;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.26
 */

public interface GreetingService {

    String greeting(String name);

    default String replayGreeting(String name) {
        return "ya hello : " + name;
    }

    default CompletableFuture<String> greeting(String name, byte signal) {
        return CompletableFuture.completedFuture(greeting(name));
    }

}
