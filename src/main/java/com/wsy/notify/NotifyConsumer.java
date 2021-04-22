package com.wsy.notify;

import com.wsy.notify.api.DemoService;
import com.wsy.notify.api.Notify;
import com.wsy.notify.impl.NotifyImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.21
 */

public class NotifyConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("notify/consumer.xml");

        DemoService demoService = context.getBean(DemoService.class);
        NotifyImpl notify = context.getBean(NotifyImpl.class);

        int id = 1;
        String result = demoService.sayHello(id);
        for (int i = 0; i < 10; i++) {
            if (!notify.ret.containsKey(id)) {
                Thread.sleep(200);
            } else {
                break;
            }
        }

        System.out.println("result : " + notify.ret.get(id));

    }

}
