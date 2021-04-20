package com.wsy.validation;

import com.wsy.validation.api.ValidationParameter;
import com.wsy.validation.api.ValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * dubbo 参数验证
 * @author wangshuangyong 2021.4.20
 */

public class ValidationConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("validation/consumer.xml");
        ValidationService service = context.getBean(ValidationService.class);
        ValidationParameter parameter = new ValidationParameter();
        parameter.setName("yydstw");
        parameter.setAge(18);
        parameter.setEmail("180@163.com");
        parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000L));
        parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000L));
        String result = service.save(parameter);
        System.out.println("save ok! " + result);

        try {
            parameter = new ValidationParameter();
            parameter.setName("aaaaaaa");
            result = service.update(parameter);
            System.out.println("save ok! " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
