package com.wsy.notify.impl;

import com.wsy.notify.api.Notify;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshuangyong 2021.4.21
 */

public class NotifyImpl implements Notify {

    public Map<Integer, Object> ret = new HashMap<>();

    @Override
    public void onReturn(String name, int id) {
        ret.put(id, name);
        System.out.println("onReturn : " + name);
    }

    @Override
    public void onThrow(Throwable ex, int id) {
        ret.put(id, ex);
        System.out.println("onThrow : " + ex);
    }
}
