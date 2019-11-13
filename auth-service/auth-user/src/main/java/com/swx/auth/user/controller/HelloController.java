package com.swx.auth.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swx
 */
@RestController
@RequestMapping("/echo")
public class HelloController {

    @GetMapping("/")
    public String e() {
        return "hello";
    }
}
