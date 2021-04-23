package com.wsy.attachment.controller;

import com.wsy.attachment.api.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public String hello(String name) {
        log.info("method hello parameter : " + name);
        return attachmentService.sayHello(name);
    }

}
