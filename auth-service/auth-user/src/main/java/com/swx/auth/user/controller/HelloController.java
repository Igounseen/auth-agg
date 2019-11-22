package com.swx.auth.user.controller;

import com.netflix.discovery.converters.Auto;
import com.swx.auth.user.client.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swx
 */
@Slf4j
@RestController
@RequestMapping("/register")
public class HelloController {


    @Autowired
    OrderClient orderClient;


    @GetMapping("/hello")
    public String e() {
       // log.info(" feign 调用：{}", orderClient.getOrder());
        return "hello";
    }
}
