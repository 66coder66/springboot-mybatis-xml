INSERT INTO `test`.`tb_user` (`user_id`, `user_name`, `type`, `browse_ip`) VALUES ('1', 'zhangsan', 'AI', '127.0.0.1');
INSERT INTO `test`.`tb_user` (`user_id`, `user_name`, `type`, `browse_ip`) VALUES ('2', 'wangwu', 'BI', '127.0.0.2');

insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER(id,sys_role_id,sys_user_id) values(1,1,1);
insert into SYS_ROLE_USER(id,sys_role_id,sys_user_id) values(2,2,2);

BEGIN;
INSERT INTO `Sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null), ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
COMMIT;

BEGIN;
INSERT INTO `Sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');
COMMIT;