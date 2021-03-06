package com.wsy.attachment.impl;

import com.wsy.attachment.api.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangshuangyong 2021.4.23
 */

@DubboService
public class AttachmentServiceImpl implements AttachmentService {

    Logger log = Logger.getLogger(AttachmentServiceImpl.class);

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RpcContext context = RpcContext.getContext();

        Object today = context.getObjectAttachment("today");
        log.info("receive attachment today : " + today);
        log.info("[ " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + " ] hello " + name + ", request consumer : " + context.getRemoteAddress());
        return "hello " + name + ", response from provider : " + context.getLocalAddress() + ", attachment - today : " + today;
    }
}
