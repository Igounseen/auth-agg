package com.swx.auth.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.swx.auth.user.client.OrderClient;
import com.swx.auth.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shiwenxiang
 * @date 2019/11/13
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    OrderClient orderClient;

    @GetMapping("/r0")
    public String r0() {
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
        UserDto userDTO = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "访问资源r2";
    }

    @GetMapping("/r3")
    @PreAuthorize("hasAnyAuthority('p3')")
    public String r3() {
        return "访问资源r3";
    }


    @GetMapping("/r4")
    public String r4() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        JSONObject json = new JSONObject();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        List<String> collect = authorities.stream().map(i -> ((GrantedAuthority) i).getAuthority()).collect(Collectors.toList());
//        json.put("principal", authentication.getPrincipal());
//        json.put("authorities", collect);
        Object order = orderClient.getOrder();
        log.info("r4 feign:{}", order);
        return "访问资源r4";
    }

}
