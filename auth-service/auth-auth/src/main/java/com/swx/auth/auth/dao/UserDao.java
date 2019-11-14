package com.swx.auth.auth.dao;

import com.swx.auth.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author shiwenxiang
 * @date 2019/11/14
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername() {
        return null;
    }


}
