use swx_oauth;


drop table if exists `oauth_code`;
drop table if exists `oauth_client_details`;
drop table if exists `user`;
drop table if exists `user_role`;
drop table if exists `role`;
drop table if exists `role_permission`;
drop table if exists `permission`;


CREATE TABLE `oauth_code`
(
    `code`           varchar(256) DEFAULT NULL,
    `authentication` blob
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `oauth_client_details`
(
    `client_id`               varchar(128) NOT NULL comment '客户端id',
    `resource_ids`            varchar(256)  DEFAULT NULL comment '资源id集合',
    `client_secret`           varchar(256)  DEFAULT NULL comment '客户端密码',
    `scope`                   varchar(256)  DEFAULT NULL comment '授权范围',
    `authorized_grant_types`  varchar(256)  DEFAULT NULL comment '授权类型集合',
    `web_server_redirect_uri` varchar(256)  DEFAULT NULL,
    `authorities`             varchar(256)  DEFAULT NULL,
    `access_token_validity`   int(11)       DEFAULT NULL,
    `refresh_token_validity`  int(11)       DEFAULT NULL,
    `additional_information`  varchar(4096) DEFAULT NULL,
    `autoapprove`             varchar(256)  DEFAULT NULL,
    PRIMARY KEY (`client_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


## 用户表
create table `user`
(
    `id`       bigint(20) unsigned not null auto_increment comment '',
    `username` varchar(255) unique not null comment '用户名',
    `password` varchar(255)        not null comment '密码',
    `mobile`   varchar(32) unique  default '' comment '电话',
    `email`    varchar(255) unique default '' comment '邮箱',
    `locked`   tinyint(1)          default '0',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户表';


## 用户角色表
create table `user_role`
(
    `user_id` bigint(20) not null comment '用户id',
    `role_id` bigint(20) not null comment '角色id'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户角色表';


## 角色表
create table `role`
(
    `id`   bigint(20) unsigned not null auto_increment comment '',
    `name` varchar(255)        not null comment '角色名称',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色表';


## 角色权限表
create table `role_permission`
(
    `role_id`       bigint(20) not null comment '角色id',
    `permission_id` bigint(20) not null comment '权限id'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色权限表';


## 权限表
create table `permission`
(
    `id`         bigint(20) unsigned not null auto_increment,
    `code`       varchar(32) comment '权限码',
    `name`       varchar(32)         not null comment '权限名称',
    `permission` varchar(128)        not null comment '权限标识',
    `type`       tinyint(2) comment '权限类型',
    `sort`       tinyint(4) comment '权限排序',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment ='权限表';
