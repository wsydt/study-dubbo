package com.wsy.generic.type.api;

public interface Service<P,V> {

    V get(P param);

}
