package com.wsy.stub;

import com.wsy.common.CommonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangshuangyong 2021.4.21
 */

public class StubConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("stub/consumer.xml");
        CommonService commonService = context.getBean(CommonService.class);
        String result = commonService.greeting("wsy");
        System.out.println(result);
    }

}
