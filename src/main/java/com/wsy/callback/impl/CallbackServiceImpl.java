package com.wsy.callback.impl;

import com.wsy.callback.api.CallbackListener;
import com.wsy.callback.api.CallbackService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangshuangyong 2021.4.21
 */

@Slf4j
public class CallbackServiceImpl implements CallbackService {

    private Map<String, CallbackListener> listeners = new ConcurrentHashMap<>();

    public CallbackServiceImpl(){
        Thread t = new Thread(()->{
            int i = 0;
            while (true) {
                try {
                    for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
                        System.out.println("thread start " + i++);
                        entry.getValue().change(getChange(entry.getKey()));
                    }
                    Thread.sleep(5000); //定时发送变更通知
                } catch (Exception e) {
                    log.error("failed , ", e);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener callbackListener) {
        listeners.put(key, callbackListener);
        callbackListener.change(getChange(key)); //发送变更通知
    }

    private String getChange(String key) {
        return "Changed : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


}
