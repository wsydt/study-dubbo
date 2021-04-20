package com.wsy.validation.impl;

import com.wsy.validation.api.ValidationParameter;
import com.wsy.validation.api.ValidationService;

/**
 * @author wangshuangyong 2021.4.20
 */

public class ValidationServiceImpl implements ValidationService {
    @Override
    public String save(ValidationParameter parameter) {
        System.out.println(parameter);
        return "save, 1.0.0";
    }

    @Override
    public String update(ValidationParameter parameter) {
        System.out.println(parameter);
        return "update, 1.0.0";
    }
}
