/*
Navicat MySQL Data Transfer

Source Server         : tyh
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : itanylife

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2022-10-18 14:34:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_annex`
-- ----------------------------
DROP TABLE IF EXISTS `t_annex`;
CREATE TABLE `t_annex` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `path` varchar(200) DEFAULT NULL COMMENT '上传路径',
  `filename` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类型(服务图片1/服务商图片2/服务商执照图片3)',
  `keyid` int(10) DEFAULT NULL COMMENT '关联外键',
  `tabletype` int(11) DEFAULT NULL COMMENT '关联表的类型1审核2服务商3服务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_annex
-- ----------------------------

-- ----------------------------
-- Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '地区名称',
  `parentid` int(20) DEFAULT NULL COMMENT '父级地区ID',
  PRIMARY KEY (`id`),
  KEY `FK_AREA` (`parentid`),
  CONSTRAINT `FK_AREA` FOREIGN KEY (`parentid`) REFERENCES `t_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES ('1', '南京', null);
INSERT INTO `t_area` VALUES ('2', '玄武区', '1');
INSERT INTO `t_area` VALUES ('3', '秦淮区', '1');
INSERT INTO `t_area` VALUES ('4', '建邺区', '1');
INSERT INTO `t_area` VALUES ('5', '鼓楼区', '1');
INSERT INTO `t_area` VALUES ('6', '浦口区', '1');
INSERT INTO `t_area` VALUES ('7', '栖霞区', '1');
INSERT INTO `t_area` VALUES ('8', '雨花台区', '1');
INSERT INTO `t_area` VALUES ('9', '江宁区', '1');
INSERT INTO `t_area` VALUES ('10', '六合区', '1');
INSERT INTO `t_area` VALUES ('11', '溧水区', '1');
INSERT INTO `t_area` VALUES ('12', '高淳区', '1');

-- ----------------------------
-- Table structure for `t_examine`
-- ----------------------------
DROP TABLE IF EXISTS `t_examine`;
CREATE TABLE `t_examine` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '审核标题',
  `name` varchar(200) DEFAULT NULL COMMENT '服务/加盟商名称',
  `typeid` int(10) DEFAULT NULL COMMENT '服务类型',
  `createdate` date DEFAULT NULL COMMENT '提交日期',
  `linkman` varchar(200) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `userid` int(10) DEFAULT NULL COMMENT '申请人ID',
  `commpanycreatedate` date DEFAULT NULL COMMENT '服务商成立日期',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `scale` varchar(200) DEFAULT NULL COMMENT '规模',
  `gps` varchar(200) DEFAULT NULL COMMENT '坐标',
  `examinetype` int(10) DEFAULT NULL COMMENT '审核类型(1加盟审核,2服务审核)',
  `flag` int(10) DEFAULT NULL COMMENT '状态',
  `servertype` varchar(200) DEFAULT NULL COMMENT '服务范围格式(服务类型ID,服务类型ID..)形式存储',
  `serverarea` varchar(200) DEFAULT NULL COMMENT '服务地区格式以(地区ID,地区ID...)形式存储',
  `info` varchar(500) DEFAULT NULL COMMENT '服务商简介/服务简介',
  `commpanyid` int(10) DEFAULT NULL COMMENT '若是服务审核则存储发布人所在服务商ID',
  `examine_info` varchar(300) DEFAULT NULL COMMENT '备注',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`),
  KEY `FK_EX_USERID` (`userid`),
  CONSTRAINT `FK_EX_USERID` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_examine
-- ----------------------------

-- ----------------------------
-- Table structure for `t_manager_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_user`;
CREATE TABLE `t_manager_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(300) DEFAULT NULL COMMENT '密码',
  `commpanyid` int(10) DEFAULT NULL COMMENT '服务商ID若是平台人员则空',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `level` varchar(200) DEFAULT NULL COMMENT '会员等级',
  `price` varchar(200) DEFAULT NULL COMMENT '价格',
  `day` varchar(200) DEFAULT NULL COMMENT '会员天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('1', 'VIP体验', '10', '3');
INSERT INTO `t_member` VALUES ('2', '初级VIP', '50', '30');
INSERT INTO `t_member` VALUES ('3', '中级VIP', '100', '180');
INSERT INTO `t_member` VALUES ('4', '高级VIP', '200', '365');

-- ----------------------------
-- Table structure for `t_member_commpany`
-- ----------------------------
DROP TABLE IF EXISTS `t_member_commpany`;
CREATE TABLE `t_member_commpany` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `memberid` int(10) DEFAULT NULL COMMENT '会员等级ID',
  `commpanyid` int(10) DEFAULT NULL COMMENT '服务商ID',
  `startdate` date DEFAULT NULL COMMENT '会员开始日期',
  `enddate` date DEFAULT NULL COMMENT '会员结束日期',
  `flag` int(11) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`),
  KEY `FK_MC_MEMBER` (`memberid`),
  KEY `FK_MC_COMMPANYID` (`commpanyid`),
  CONSTRAINT `FK_MC_COMMPANYID` FOREIGN KEY (`commpanyid`) REFERENCES `t_server_commpany` (`id`),
  CONSTRAINT `FK_MC_MEMBER` FOREIGN KEY (`memberid`) REFERENCES `t_member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member_commpany
-- ----------------------------
INSERT INTO `t_member_commpany` VALUES ('1', '1', '1', '2022-03-08', '2022-03-31', null, null);
INSERT INTO `t_member_commpany` VALUES ('2', '2', '1', '2022-03-01', '2022-03-07', null, null);

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(20) NOT NULL DEFAULT '0',
  `name` varchar(200) DEFAULT NULL COMMENT '称呼',
  `msg` varchar(300) DEFAULT NULL COMMENT '留言内容',
  `phone` varchar(200) DEFAULT NULL COMMENT '联系号码',
  `area` varchar(200) DEFAULT NULL COMMENT '意向范围',
  `commpanyid` int(20) DEFAULT NULL COMMENT '留言服务商ID',
  `createdate` date DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`),
  KEY `FK_MSG_COMMPANYID` (`commpanyid`),
  CONSTRAINT `FK_MSG_COMMPANYID` FOREIGN KEY (`commpanyid`) REFERENCES `t_server_commpany` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for `t_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '通知标题',
  `info` varchar(300) DEFAULT NULL COMMENT '通知内容',
  `manageruserid` int(10) DEFAULT NULL COMMENT '发布人员ID',
  `userid` int(10) DEFAULT NULL COMMENT '要通知到的前台用户ID若是全体通知则留空',
  `flag` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` date DEFAULT NULL COMMENT '发送日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `parentid` int(10) NOT NULL COMMENT '父权限ID',
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleid` int(10) NOT NULL COMMENT '角色ID',
  `permissionid` int(10) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`),
  KEY `FK_RP` (`roleid`),
  KEY `FK_PR` (`permissionid`),
  CONSTRAINT `FK_PR` FOREIGN KEY (`permissionid`) REFERENCES `t_permission` (`id`),
  CONSTRAINT `FK_RP` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_server_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_server_area`;
CREATE TABLE `t_server_area` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `serverid` int(20) DEFAULT NULL COMMENT '服务外键',
  `areaid` int(20) DEFAULT NULL COMMENT '服务范围ID',
  PRIMARY KEY (`id`),
  KEY `FK_SA_SERVERID` (`serverid`),
  KEY `FK_SA_AREAID` (`areaid`),
  CONSTRAINT `FK_SA_AREAID` FOREIGN KEY (`areaid`) REFERENCES `t_area` (`id`),
  CONSTRAINT `FK_SA_SERVERID` FOREIGN KEY (`serverid`) REFERENCES `t_server_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_area
-- ----------------------------

-- ----------------------------
-- Table structure for `t_server_commpany`
-- ----------------------------
DROP TABLE IF EXISTS `t_server_commpany`;
CREATE TABLE `t_server_commpany` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '服务公司名称',
  `info` varchar(300) DEFAULT NULL COMMENT '服务公司简介',
  `address` varchar(300) DEFAULT NULL COMMENT '地址',
  `gps` varchar(200) DEFAULT NULL COMMENT '坐标(经度,纬度)',
  `scale` varchar(200) DEFAULT NULL COMMENT '规模',
  `createdate` date DEFAULT NULL COMMENT '成立日期',
  `joindate` date DEFAULT NULL COMMENT '入驻日期',
  `flag` int(10) DEFAULT NULL COMMENT '状态',
  `type` int(10) DEFAULT NULL COMMENT '生活1/商务服务2',
  `linkman` varchar(200) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(200) DEFAULT NULL COMMENT '公司电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_commpany
-- ----------------------------
INSERT INTO `t_server_commpany` VALUES ('1', 'xxx', '123', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_server_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_server_info`;
CREATE TABLE `t_server_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `servername` varchar(200) DEFAULT NULL COMMENT '服务名称',
  `info` varchar(500) DEFAULT NULL COMMENT '简介',
  `linkman` varchar(200) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `userid` int(20) DEFAULT NULL,
  `commpanyid` int(20) DEFAULT NULL COMMENT '发布公司ID',
  `createdate` date DEFAULT NULL COMMENT '发布日期',
  `flag` int(10) DEFAULT NULL COMMENT '状态',
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SERVER_USERID` (`userid`),
  KEY `FK_SERVER_COMMPANYID` (`commpanyid`),
  CONSTRAINT `FK_SERVER_COMMPANYID` FOREIGN KEY (`commpanyid`) REFERENCES `t_server_commpany` (`id`),
  CONSTRAINT `FK_SERVER_USERID` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_server_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_server_type`;
CREATE TABLE `t_server_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `typeid` int(10) DEFAULT NULL,
  `serverid` int(10) DEFAULT NULL COMMENT '服务ID',
  PRIMARY KEY (`id`),
  KEY `FK_SERVER_TYPEID` (`typeid`),
  KEY `FK_SERVER_SERVERID` (`serverid`),
  CONSTRAINT `FK_SERVER_SERVERID` FOREIGN KEY (`serverid`) REFERENCES `t_server_info` (`id`),
  CONSTRAINT `FK_SERVER_TYPEID` FOREIGN KEY (`typeid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '类型名称',
  `parentid` int(10) DEFAULT NULL COMMENT '父类型ID',
  `type` int(11) DEFAULT NULL COMMENT '服务类型的类型(1生活2商务)',
  PRIMARY KEY (`id`),
  KEY `FK_TYPE` (`parentid`),
  CONSTRAINT `FK_TYPE` FOREIGN KEY (`parentid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) DEFAULT NULL COMMENT '用户名',
  `password` varchar(300) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(200) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(200) DEFAULT NULL COMMENT '手机',
  `wechat` varchar(200) DEFAULT NULL COMMENT '微信',
  `qq` varchar(200) DEFAULT NULL COMMENT 'qq',
  `headimg` varchar(200) DEFAULT NULL COMMENT '头像',
  `sex` int(20) DEFAULT '1' COMMENT '性别(默认1)',
  `companyid` int(20) DEFAULT NULL COMMENT '服务商有值普通用户为NULL',
  `flag` int(10) DEFAULT NULL COMMENT '状态',
  `createdate` date DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(10) DEFAULT NULL COMMENT '用户ID',
  `roleid` int(10) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `FK_UR_ID` (`userid`),
  KEY `FK_RU_ID` (`roleid`),
  CONSTRAINT `FK_RU_ID` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_UR_ID` FOREIGN KEY (`userid`) REFERENCES `t_manager_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
