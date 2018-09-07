-- 用户表
CREATE TABLE `tb_basic_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `userId` varchar(32) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `headimg` varchar(200) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `memo` varchar(50) DEFAULT NULL,
  `credate` datetime DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- 权限表
CREATE TABLE tb_basic_authorities(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  username varchar(20) NOT NULL ,
  authority varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

-- 插入测试用户
INSERT INTO tb_basic_user(username, password) VALUE ('admin', 'admin');
INSERT INTO tb_basic_user(username, password) VALUE ('user', 'user');

-- 插入测试用户权限
INSERT INTO tb_basic_authorities(username, authority) VALUE ('admin','ROLE_ADMIN');
INSERT INTO tb_basic_authorities(username, authority) VALUE ('admin','ROLE_USER');