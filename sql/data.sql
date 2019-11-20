use swx_oauth;


INSERT INTO `oauth_client_details`(client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                   web_server_redirect_uri)
VALUES ('webapp', 'user,business', '$2a$10$vmqeEdxEk8wzornASdzUsu8DRZzW2b9L798YPQ/TX4g2VmTBZkXeu',
        'ROLE_ADMIN,ROLE_USER,ROLE_API', 'authorization_code,password,client_credentials,implicit,refresh_token',
        'http://www.baidu.com');
INSERT INTO `oauth_client_details`(client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                   web_server_redirect_uri)
VALUES ('app', 'user', '$2a$10$vmqeEdxEk8wzornASdzUsu8DRZzW2b9L798YPQ/TX4g2VmTBZkXeu',
        'ROLE_ADMIN,ROLE_USER,ROLE_API', 'authorization_code,password,client_credentials,implicit,refresh_token',
        'http://www.baidu.com');


INSERT INTO `user`(id, username, password, mobile, email, locked)
VALUES (1, 'admin', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', '13100000000',
        'admin@pmlabs.com.cn', 0);
INSERT INTO `user`(id, username, password, mobile, email, locked)
VALUES (2, 'shiwenxiang', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', '13100717110',
        'shiwenxiang@pmlabs.com.cn', 0);
INSERT INTO `user`(id, username, password, mobile, email, locked)
VALUES (3, 'luganyi', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', '13111111111',
        'luganyi@pmlabs.com.cn', 0);
INSERT INTO `user`(id, username, password, mobile, email, locked)
VALUES (4, 'chenwei', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', '13122222222',
        'chenwei@pmlabs.com.cn', 0);
INSERT INTO `user`(id, username, password, mobile, email, locked)
VALUES (5, 'xuxiangjuan', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', '13144444444',
        'xuxiangjuan@pmlabs.com.cn', 0);


INSERT INTO `user_role`(user_id, role_id)
VALUES (1, 1);
insert into `user_role`(user_id, role_id)
values (2, 2);
insert into `user_role`(user_id, role_id)
values (3, 2);
insert into `user_role`(user_id, role_id)
values (4, 2);
insert into `user_role`(user_id, role_id)
values (5, 2);


INSERT INTO `role`(id, name)
VALUES (1, '管理员');
INSERT INTO `role`(id, name)
VALUES (2, '普通用户');

INSERT INTO `role_permission`(role_id, permission_id)
VALUES (1, 1);
INSERT INTO `role_permission`(role_id, permission_id)
VALUES (1, 2);

INSERT INTO `role_permission`(role_id, permission_id)
VALUES (2, 2);

INSERT INTO `permission`(id, code, name, permission, type, sort)
VALUES (1, '', '', 'p1', NULL, 1);
INSERT INTO `permission`(id, code, name, permission, type, sort)
VALUES (2, '', '', 'p2', NULL, 2);


commit;