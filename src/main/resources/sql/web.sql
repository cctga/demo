/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : web

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 19/11/2019 23:29:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `authority_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`authority_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, '用户管理', '/users');
INSERT INTO `authority` VALUES (2, '角色管理', '/roles');
INSERT INTO `authority` VALUES (3, '系统日志', '/logs');
INSERT INTO `authority` VALUES (4, '人员维护', '/persons');
INSERT INTO `authority` VALUES (5, '单位维护', '/companies');

-- ----------------------------
-- Table structure for man
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(255) NULL DEFAULT NULL,
  `like` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '测试表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man
-- ----------------------------
INSERT INTO `man` VALUES ('maoludong', 12, 0, '游戏');
INSERT INTO `man` VALUES ('wanglu', 18, 1, 'boy_friend');

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood`  (
  `id` bigint(20) NOT NULL COMMENT '使用snowflack生成',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `praise_num` int(11) NULL DEFAULT NULL,
  `publish_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mood_user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mood
-- ----------------------------
INSERT INTO `mood` VALUES (383050970038272, '今天的第一条说说.', 11, 0, '2019-11-19 15:15:19');
INSERT INTO `mood` VALUES (383841390821376, '今天的第一条说说.', 11, 0, '2019-11-19 23:18:27');
INSERT INTO `mood` VALUES (384009557245952, '今天的第一条说说.', 11, 0, '2019-11-19 23:19:08');

-- ----------------------------
-- Table structure for rele_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `rele_role_authority`;
CREATE TABLE `rele_role_authority`  (
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-用户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rele_role_authority
-- ----------------------------
INSERT INTO `rele_role_authority` VALUES (1, 1);
INSERT INTO `rele_role_authority` VALUES (1, 2);
INSERT INTO `rele_role_authority` VALUES (1, 3);
INSERT INTO `rele_role_authority` VALUES (2, 4);
INSERT INTO `rele_role_authority` VALUES (2, 5);

-- ----------------------------
-- Table structure for rele_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rele_user_role`;
CREATE TABLE `rele_user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rele_user_role
-- ----------------------------
INSERT INTO `rele_user_role` VALUES (1, 1);
INSERT INTO `rele_user_role` VALUES (1, 2);
INSERT INTO `rele_user_role` VALUES (1001, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `used` int(1) NULL DEFAULT NULL COMMENT '有效标志',
  `create_user` bigint(255) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 1, 1, '2018-12-22 17:11:36');
INSERT INTO `role` VALUES (2, '普通用户', 1, 1, '2018-12-22 17:11:49');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `photo` blob NULL COMMENT '照片',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'admin@mybatis.tk', '管理员', NULL, '2016-04-01 17:00:58');
INSERT INTO `user` VALUES (2, 'test', '123456', 'test@mybatis.tk', '测试用户', NULL, '2018-12-22 16:44:17');
INSERT INTO `user` VALUES (3, 'maoludong', '123456', 'maoludong@mybatis.tk', '毛鲁动', NULL, '2019-11-11 22:45:27');
INSERT INTO `user` VALUES (4, 'wanglu', '123456', 'wanglu@mybatis.tk', '王露', NULL, '2019-11-11 22:46:01');

SET FOREIGN_KEY_CHECKS = 1;
