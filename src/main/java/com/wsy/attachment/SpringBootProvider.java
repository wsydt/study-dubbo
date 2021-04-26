package com.wsy.attachment;

import com.wsy.attachment.controller.AttachmentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshuangyong 2021.4.23
 */

@SpringBootApplication
@Profile("provider")
@ComponentScan(excludeFilters={@ComponentScan.Filter({RestController.class}), @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value = SpringBootConsumer.class)})
public class SpringBootProvider {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProvider.class);
    }

}
