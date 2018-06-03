/*
Navicat MySQL Data Transfer

Source Server         : kenhome
Source Server Version : 80011
Source Host           : 120.79.35.34:3306
Source Database       : scheduler

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-06-03 20:58:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_acl
-- ----------------------------
DROP TABLE IF EXISTS `t_acl`;
CREATE TABLE `t_acl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `acl_no` bigint(20) DEFAULT NULL COMMENT '资源编号',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改者',
  `acl_name` varchar(255) DEFAULT NULL COMMENT '资源名',
  `acl_url` varchar(255) DEFAULT NULL COMMENT '资源地址，注：地址不带上服务器部分，方便日后迁移服务器',
  `acl_grade` int(11) DEFAULT NULL COMMENT '资源等级，1:父菜单，2:子菜单，3：第三级；',
  `acl_type` int(11) DEFAULT NULL COMMENT '资源类型',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `parent_no` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `acl_no` (`acl_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_acl
-- ----------------------------
INSERT INTO `t_acl` VALUES ('1', '20180414220301', '2018-04-14 21:14:43', null, 'admin', 'admin', '后台管理', 'javascript:;', '0', '0', '', null, '0', '1');
INSERT INTO `t_acl` VALUES ('2', '20180414220302', '2018-04-14 21:14:44', null, 'admin', 'admin', '首页', '/manager/info', '1', '1', 'manager:info', 'glyphicon glyphicon-home', '20180414220301', '2');
INSERT INTO `t_acl` VALUES ('3', '20180414220303', '2018-04-14 21:14:45', null, 'admin', 'admin', '任务管理', 'javascript:;', '1', '1', 'manager:product', 'glyphicon glyphicon-shopping-cart', '20180414220301', '3');
INSERT INTO `t_acl` VALUES ('4', '20180414220304', '2018-04-14 21:14:46', null, 'admin', 'admin', '任务中心', '/job/list', '2', '2', 'manager:jon:list', null, '20180414220303', '4');
