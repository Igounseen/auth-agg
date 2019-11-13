package com.swx.auth.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiwenxiang
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        return "访问资源r1";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String r2() {
        return "访问资源r2";
    }

    @GetMapping("/r3")
    @PreAuthorize("hasAnyAuthority('p3')")
    public String r3() {
        return "访问资源r3";
    }

    @GetMapping("/r4")
    @PreAuthorize("hasAnyAuthority('p4')")
    public String r4() {
        return "访问资源r4";
    }

}
