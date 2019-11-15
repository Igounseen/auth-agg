use swx_oauth;


INSERT INTO `oauth_client_details`
VALUES ('webapp', 'res1', '$2a$10$vmqeEdxEk8wzornASdzUsu8DRZzW2b9L798YPQ/TX4g2VmTBZkXeu',
        'ROLE_ADMIN,ROLE_USER,ROLE_API', 'authorization_code,password,client_credentials,implicit',
        'http://www.baidu.com', 'p1,p2', NULL, NULL, NULL, NULL);

INSERT INTO `user`
VALUES (1, 'admin', '$2a$10$m2KNWzdK0U5Y1IZrSElOqe.vabueB5MFgiOeoIVAUNbAbJaKtBvZK', 0);

INSERT INTO `user_role`
VALUES (1, 1);

INSERT INTO `role`
VALUES (1, '管理员', NULL);

INSERT INTO `role_permission`
VALUES (1, 1);

INSERT INTO `permission`
VALUES (1, 'r1', NULL, 'r1', NULL, NULL);


commit;