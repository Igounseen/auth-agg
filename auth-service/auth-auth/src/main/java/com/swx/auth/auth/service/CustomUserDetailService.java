package com.swx.auth.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.swx.auth.auth.dao.UserDao;
import com.swx.auth.auth.dto.UserDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiwenxiang
 * @date 2019/11/13
 */
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto user = userDao.getUserByUsername(s);
        if (null == user) {
            // 如果查不到用户，则返回null, 由provider抛异常
            return null;
        }
        String password = user.getPassword();
        List<String> permissions = userDao.findPermissionByUserId(user.getId());
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(JSONObject.toJSONString(user))
                .password(password)
                .authorities(permissionArray)
                .accountLocked(!StringUtils.equals("0", user.getLocked()))
                .build();
        return userDetails;
    }


}