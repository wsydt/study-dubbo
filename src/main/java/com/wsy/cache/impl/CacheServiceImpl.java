package com.wsy.cache.impl;

import com.wsy.cache.api.CacheService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangshuangyong 2021.4.21
 */

public class CacheServiceImpl implements CacheService {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public String findCache(int id) {
        return "request id : " + id + ", response : " + atomicInteger.getAndIncrement();
    }
}
