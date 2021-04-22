package com.wsy.generic.call.impl;

import com.wsy.generic.call.api.HelloService;
import com.wsy.generic.call.api.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.22
 */

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "sayHello : " + name;
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("sayHelloAsync : " + name);
        }).start();
        return future;
    }

    @Override
    public CompletableFuture<Person> sayHelloAsyncComplex(String name) {
        CompletableFuture<Person> future = new CompletableFuture<>();
        Person person = new Person(22, "complex " + name);
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete(person);
        }).start();
        return future;
    }

    @Override
    public CompletableFuture<List<Person>> sayHelloAsyncGenericComplex(String name) {
        CompletableFuture<List<Person>> future = new CompletableFuture<>();
        List<Person> list = new ArrayList<>();
        Person person = new Person(22, "complex generic : " + name);
        list.add(person);
        person = new Person(33, "complex generic : " + name);
        list.add(person);
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete(list);
        }).start();
        return future;
    }
}
