package com.wsy.cache;

import com.wsy.cache.api.CacheService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.21
 */

public class CacheConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cache/consumer.xml");

        CacheService cacheService = context.getBean(CacheService.class);

        // 验证缓存 相同参数多次调用返回相同的结果,(实际上服务提供者每次调用返回的数据都会加一)
        String pre = null;
        cacheService.findCache(0);
        for (int i = 0; i < 5; i++) {
            String result = cacheService.findCache(0);
            if (pre == null || pre.equals(result)) {
                System.out.println("pre OK, "+ result);
            } else {
                System.out.println("pre ERROR, " + result);
            }
            pre = result;
            Thread.sleep(500);
        }

        // lru 默认缓存大小为1000, 如果调用参数大于1000 则第一个缓存会失效
        String pre1 = null;
        for (int i = 0; i < 1001; i ++) {
            cacheService.findCache(i);
            for (int n = 0; n < 10; n++) {
                String result = cacheService.findCache(i);
                if (pre1 != null && !pre1.equals(result)) {
                    System.out.println("pre1 ERROR, " + result);
                }
                pre1 = result;
            }
        }

        //判断第一次调用缓存是否失效
        String result = cacheService.findCache(0);
        if (pre.equals(result)) {
            System.out.println("***ERROR, " + result);
        } else {
            System.out.println("***OK, " + result);
        }


    }

}
