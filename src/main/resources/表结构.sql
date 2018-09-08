-- 用户表
DROP TABLE IF EXISTS tb_basic_user;
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

-- 插入测试用户
INSERT INTO tb_basic_user(id, username, password) VALUE (1, 'admin', 'admin');
INSERT INTO tb_basic_user(id, username, password) VALUE (2, 'user', 'user');

-- 角色表
DROP TABLE IF EXISTS tb_basic_role;
CREATE TABLE tb_basic_role(
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  rolelabel varchar(50) COMMENT '角色标识',
  name VARCHAR(50) COMMENT '角色名称',
  memo VARCHAR(100) COMMENT '角色说明描述',
  PRIMARY KEY (id)
);

INSERT INTO tb_basic_role(id, rolelabel, name, memo) VALUE (1, 'ROLE_ADMIN','系统管理员', '');
INSERT INTO tb_basic_role(id, rolelabel, name, memo) VALUE (2, 'ROLE_USER' ,'普通用户', '');

-- 用户角色关联表
DROP TABLE IF EXISTS tb_basic_userrole;
CREATE TABLE tb_basic_userrole(
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  userid INT (11) COMMENT '用户id',
  roleid INT (11) COMMENT '角色id',
  PRIMARY KEY (id)
);

INSERT INTO tb_basic_userrole(id, userid, roleid) VALUE (1, 1, 1);
INSERT INTO tb_basic_userrole(id, userid, roleid) VALUE (2, 2, 2);



-- 权限表
DROP TABLE IF EXISTS tb_basic_authorities;
CREATE TABLE tb_basic_authorities(
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  name VARCHAR(20)  COMMENT '权限名称',
  authotype VARCHAR (50) NOT NULL COMMENT '权限类型，URL/BUTTON',
  authority VARCHAR(200) NOT NULL COMMENT '权限路径',
  memo VARCHAR (200) COMMENT '权限描述',
  PRIMARY KEY (id)
);

-- 插入测试用户权限
INSERT INTO tb_basic_authorities(id,name, authotype, authority) VALUE (1,'管理员页面', 'URL','/admin');
INSERT INTO tb_basic_authorities(id,name, authotype, authority) VALUE (2,'用户页面', 'URL', '/a/home');

-- 角色权限关联表
DROP TABLE IF EXISTS tb_basic_roleauthorities;
CREATE TABLE tb_basic_roleauthorities(
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  roleid INT (11) COMMENT '角色id',
  authorityid INT (11) COMMENT '权限id',
  PRIMARY KEY (id)
);

INSERT INTO tb_basic_roleauthorities(id,roleid, authorityid) VALUE (1,1,1);
INSERT INTO tb_basic_roleauthorities(id,roleid, authorityid) VALUE (2,2,2);
