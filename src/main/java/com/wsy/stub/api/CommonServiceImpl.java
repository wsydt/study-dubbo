package com.wsy.stub.api;

import com.wsy.common.CommonService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangshuangyong 2021.4.21
 */

@Slf4j
public class CommonServiceImpl implements CommonService {
    @Override
    public String greeting(String name) {
        log.info("parameter : " + name);
        return "greeting : " + name;
    }
}
