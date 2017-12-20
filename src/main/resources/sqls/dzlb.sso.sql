/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : 127.0.0.1:3306
Source Database       : dzlb.sso

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-12-20 20:51:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sso_authority
-- ----------------------------
DROP TABLE IF EXISTS `sso_authority`;
CREATE TABLE `sso_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) NOT NULL,
  `menu_url` varchar(2000) NOT NULL,
  `parent_id` bigint(20) NOT NULL COMMENT '父级菜单id(顶级菜单的父级id为0)',
  `menu_level` tinyint(4) NOT NULL COMMENT '菜单级别(0.顶级菜单,1.二级菜单,2.三级菜单)',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '菜单状态(0.正常,1.停用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for sso_role
-- ----------------------------
DROP TABLE IF EXISTS `sso_role`;
CREATE TABLE `sso_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL COMMENT '角色名',
  `description` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sso_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `sso_role_authority`;
CREATE TABLE `sso_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for sso_user
-- ----------------------------
DROP TABLE IF EXISTS `sso_user`;
CREATE TABLE `sso_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_key` varchar(255) NOT NULL COMMENT '用户key,程序生成字符串',
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `login_password` varchar(255) NOT NULL COMMENT '登录密码',
  `user_name` varchar(255) NOT NULL COMMENT '用户名(昵称)',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '账号状态(默认0.启用,1.停用)',
  `registry_time` datetime NOT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sso_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sso_user_role`;
CREATE TABLE `sso_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
