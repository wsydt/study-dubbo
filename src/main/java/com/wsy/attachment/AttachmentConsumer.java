package com.wsy.attachment;

import com.wsy.attachment.api.AttachmentService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author wangshuangyong 2021.4.23
 */

public class AttachmentConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("attachment/consumer.xml");

        AttachmentService attachmentService = context.getBean(AttachmentService.class);

        RpcContext.getContext().setAttachment("today", new Date());
        String result = attachmentService.sayHello("aaa");
        System.out.println(result);
    }

}
