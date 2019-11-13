package com.swx.auth.auth.service;

import com.swx.auth.auth.dto.UserDto;
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
@Service
public class SpringDataUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto user = getUserByUsername(s);
        if (null == user) {
            // 如果查不到用户，则返回null, 由provider抛异常
            return null;
        }
        List<String> permissions = findPermissionsByUserId(user.getId());
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(permissions.toArray(new String[0]))
                .build();
    }

    /**
     * 模拟数据库操作
     *
     * @param username
     * @return
     */
    private UserDto getUserByUsername(String username) {
        UserDto user1 = new UserDto(1L, "张三", new BCryptPasswordEncoder().encode("123456"));
        UserDto user2 = new UserDto(2L, "李四", new BCryptPasswordEncoder().encode("123456"));
        Map<String, UserDto> map = new HashMap<>(16);
        map.put(user1.getUsername(), user1);
        map.put(user2.getUsername(), user2);
        return map.get(username);
    }

    /**
     * 模拟数据库操作
     *
     * @param id
     * @return
     */
    private List<String> findPermissionsByUserId(Long id) {
        Map<Long, List<String>> map = new HashMap<>(16);
        map.put(1L, Arrays.asList("p1", "p3"));
        map.put(2L, Arrays.asList("p2", "p4"));
        return map.get(id);
    }

}
