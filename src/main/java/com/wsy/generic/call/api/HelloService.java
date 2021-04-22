package com.wsy.generic.call.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface HelloService {

    String sayHello(String name);

    CompletableFuture<String> sayHelloAsync(String name);

    CompletableFuture<Person> sayHelloAsyncComplex(String name);

    CompletableFuture<List<Person>> sayHelloAsyncGenericComplex(String name);

}
