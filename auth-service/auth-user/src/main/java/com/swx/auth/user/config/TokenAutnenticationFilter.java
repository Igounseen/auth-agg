package com.swx.auth.user.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swx.auth.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiwenxiang
 * @date 2019/11/18
 */
@Slf4j
@Component
public class TokenAutnenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("json-token");
        System.out.println("--------------token:" + token);
        if (token != null) {
            JSONObject jsonObject = JSON.parseObject(token);
            // 身份信息
            String principal = jsonObject.getString("principal");
            // 权限信息
            JSONArray authoritiesArray = jsonObject.getJSONArray("authorities");
            UserDto userDto = JSON.parseObject(principal, UserDto.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDto,
                    null,
                    AuthorityUtils.createAuthorityList(authoritiesArray.toArray(new String[0])));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //将authenticationToken填充到安全上下文
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
