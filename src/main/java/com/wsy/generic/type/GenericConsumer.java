package com.wsy.generic.type;

import com.wsy.generic.type.api.User;
import com.wsy.generic.type.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshuangyong 2021.4.22
 */

public class GenericConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("generic/type/consumer.xml");

        UserService userService = context.getBean(UserService.class);
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "wsy");

        User user = userService.get(map);
        System.out.println(user);

    }

}
