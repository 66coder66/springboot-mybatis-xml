DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `browse_ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL,
  `sys_role_id` bigint(20) DEFAULT NULL,
 `sys_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `descritpion` varchar(500) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
	`pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
	`permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;