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
    `client_id`               varchar(128) NOT NULL,
    `resource_ids`            varchar(256)  DEFAULT NULL,
    `client_secret`           varchar(256)  DEFAULT NULL,
    `scope`                   varchar(256)  DEFAULT NULL,
    `authorized_grant_types`  varchar(256)  DEFAULT NULL,
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
    `username` varchar(255),
    `password` varchar(255),
    `locked`   tinyint(1) default '0',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

## 用户角色表
create table `user_role`
(
    `user_id` bigint(20),
    `role_id` bigint(20)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

## 角色表
create table `role`
(
    `id`   bigint(20) unsigned not null auto_increment comment '',
    `name` varchar(255),
    `type` tinyint(1),
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

## 角色权限表
create table `role_permission`
(
    `role_id`       bigint(20),
    `permission_id` bigint(20)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

## 权限表
create table `permission`
(
    `id`         bigint(20) unsigned not null auto_increment comment '',
    `code`       varchar(32),
    `name`       varchar(32),
    `permission` varchar(128),
    `type`       tinyint(2),
    `sort`       tinyint(4),
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
