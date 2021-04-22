package com.wsy.generic.type.impl;

import com.wsy.generic.type.api.User;
import com.wsy.generic.type.api.UserService;

import java.util.Map;

/**
 * @author wangshuangyong 2021.4.22
 */

public class UserServiceImpl implements UserService {
    @Override
    public User get(Map<String, String> param) {
        return new User(Integer.parseInt(param.get("id")), param.get("name"));
    }
}
