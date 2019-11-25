package com.swx.auth.user.config;

import com.alibaba.fastjson.JSONObject;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shiwenxiang
 * @date 2019/11/25
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
    @Bean
    Logger.Level feignLoggerLevel() {
        //这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            JSONObject json = new JSONObject();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            List<String> collect = authorities.stream().map(i -> ((GrantedAuthority) i).getAuthority()).collect(Collectors.toList());
            json.put("principal", authentication.getPrincipal());
            json.put("authorities", collect);
            requestTemplate.header("json-token", json.toJSONString());
        }
    }
}
