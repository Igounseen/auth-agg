package com.swx.auth.auth.dao;

import com.swx.auth.auth.dto.PermissionDto;
import com.swx.auth.auth.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiwenxiang
 * @date 2019/11/14
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDto getUserByUsername(String usernmae) {
        String sql = "select id,username,password from t_user where username = ?";
        List<UserDto> result = jdbcTemplate.query(sql, new Object[]{usernmae}, new BeanPropertyRowMapper<>(UserDto.class));
        if (result == null && result.size() <= 0) {
            return null;
        }
        return result.get(0);
    }

    public List<String> findPermissionByUserId(Long userId) {
        String sql = "SELECT * FROM t_permission WHERE id IN (" +
                " SELECT permission_id FROM t_role_permission WHERE role_id IN (" +
                " SELECT role_id FROM t_user_role WHERE user_id = ? " +
                ")" +
                ")";
        List<PermissionDto> result = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(PermissionDto.class));
        List<String> permissions = new ArrayList<>();
        result.forEach(p -> permissions.add(p.getCode()));
        return permissions;

    }


}
