/*
 Navicat Premium Data Transfer

 Source Server         : SmartMetro-dev
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : 192.168.100.46:3306
 Source Schema         : subway

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 23/09/2022 10:55:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for site_notice_source
-- ----------------------------
DROP TABLE IF EXISTS `site_notice_source`;
CREATE TABLE `site_notice_source`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) NULL DEFAULT NULL COMMENT '事件源id',
  `source_type` tinyint(4) NULL DEFAULT NULL COMMENT '事件源类型',
  `content_type` tinyint(4) NULL DEFAULT NULL COMMENT '内容类型',
  `source_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件源的内容',
  `remind_time` datetime(0) NULL DEFAULT NULL COMMENT '提示时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(2) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for site_notice_user
-- ----------------------------
DROP TABLE IF EXISTS `site_notice_user`;
CREATE TABLE `site_notice_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site_notice_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '是否已读 1:未读；2：已读',
  `read_time` datetime(0) NULL DEFAULT NULL,
  `deleted` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
