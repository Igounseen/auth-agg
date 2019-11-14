package com.swx.auth.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author shiwenxiang
 * @date 2019/11/14
 */

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private List<Role> authorities;

}
