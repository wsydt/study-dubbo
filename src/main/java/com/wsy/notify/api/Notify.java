package com.wsy.notify.api;

public interface Notify {

    void onReturn(String name, int id);

    void onThrow(Throwable ex, int id);
}
