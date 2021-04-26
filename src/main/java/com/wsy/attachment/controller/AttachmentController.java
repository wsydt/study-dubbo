package com.wsy.attachment.controller;

import com.wsy.attachment.api.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * @author wangshuangyong 2021.4.23
 */

@Slf4j
@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @DubboReference
    private AttachmentService attachmentService;

    @GetMapping("/hello")
    public CompletableFuture<String> hello(String name) {
        RpcContext.getContext().setAttachment("today", new Date());
        log.info("method hello parameter : " + name);
        CompletableFuture<String> result = new CompletableFuture<>();
        new Thread(() -> {
            result.complete(attachmentService.sayHello(name));
        }).start();
        log.info("返回結果 ： " + result);
        return result;
    }

}
