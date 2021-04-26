package com.wsy.async.origin.future.api;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    CompletableFuture<String> sayHello(String name);

}
