package com.wsy.stub.api;

import com.wsy.common.CommonService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangshuangyong 2021.4.21
 */

@Slf4j
public class CommonServiceStub implements CommonService {

    private CommonService commonService;

    /**
     * 必须有一个远程服务代理对象的
     * @param commonService 远程服务代理对象实例
     */
    public CommonServiceStub (CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public String greeting(String name) {
        //参数前置处理
        log.info("stub parameter : " + name);
        name += ", 处理后的参数.";
        String result;
        try {
            //调用远程服务
            result = commonService.greeting(name);
            //结果后置处理
            result = "结果后置处理, " + result;
            return result;
        } catch (Exception e) {
            //远程服务调用失败,容错处理
            log.error("远程调用失败 : ", e);
            result = "";
        }
        return result;
    }
}
