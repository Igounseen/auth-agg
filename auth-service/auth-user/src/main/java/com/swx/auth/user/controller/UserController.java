package com.swx.auth.user.controller;

import com.swx.auth.user.dto.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/r0")
    public String r4() {
        return "访问资源";
    }

    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        UserDto userDTO = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("User Info:" + userDTO);
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


}
