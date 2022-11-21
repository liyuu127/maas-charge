/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.96(scm-dev)
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : 192.168.100.96:3306
 Source Schema         : scm

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 21/11/2022 14:59:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_flag` smallint(6) NOT NULL DEFAULT 1 COMMENT 'app标识 [暂不使用]',
  `app_type` smallint(6) NULL DEFAULT NULL COMMENT 'app类型 1-移动端(Android) 2-移动端(IOS) 3-车载端(Android) 4-PC端(Windows)',
  `version_number` int(11) NULL DEFAULT NULL COMMENT '版本号',
  `version_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '版本名称',
  `forced_updated_instructions` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '强制更新说明',
  `updated_instructions` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新说明',
  `min_version_number` int(11) NULL DEFAULT NULL COMMENT '最低版本',
  `upload_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '下载地址',
  `created_at` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(3) NULL DEFAULT NULL COMMENT '上次更新时间',
  `deleted` smallint(6) NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除 1-已删除',
  `valid` tinyint(4) NULL DEFAULT NULL COMMENT '是否是当前生效版本 0-否 1-是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = 'app管理表\r\n@author Laixiaopeng' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for color_dict
-- ----------------------------
DROP TABLE IF EXISTS `color_dict`;
CREATE TABLE `color_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '颜色名称',
  `value` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色RGB值',
  `source_type` int(2) NOT NULL COMMENT '1:职位',
  `deleted` int(2) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company_t
-- ----------------------------
DROP TABLE IF EXISTS `company_t`;
CREATE TABLE `company_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单位表ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `type` int(11) NULL DEFAULT NULL COMMENT '单位类型: 1:作业单位、2:运维单位、3:业主单位',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `res_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人名称',
  `res_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人联系方式',
  `inner_company` int(11) NULL DEFAULT NULL COMMENT '是否内部单位',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `supplier_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商代号',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单位(公司)表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department_t
-- ----------------------------
DROP TABLE IF EXISTS `department_t`;
CREATE TABLE `department_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门表ID',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '公司ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `res_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `res_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人手机号',
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lookup_child_t
-- ----------------------------
DROP TABLE IF EXISTS `lookup_child_t`;
CREATE TABLE `lookup_child_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) NOT NULL COMMENT '上级ID',
  `value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'value值',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `orders` int(11) NULL DEFAULT NULL COMMENT '内部排序',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态(0-禁用,1-启用)',
  `attr1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性1',
  `attr2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性2',
  `attr3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性3',
  `attr4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性4',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lookup_parent_t
-- ----------------------------
DROP TABLE IF EXISTS `lookup_parent_t`;
CREATE TABLE `lookup_parent_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'value值',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position_t
-- ----------------------------
DROP TABLE IF EXISTS `position_t`;
CREATE TABLE `position_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位信息表ID',
  `d_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `color_id` int(11) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 175 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_t
-- ----------------------------
DROP TABLE IF EXISTS `project_t`;
CREATE TABLE `project_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目介绍表ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背景图片',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource_t
-- ----------------------------
DROP TABLE IF EXISTS `resource_t`;
CREATE TABLE `resource_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `p_id` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型0菜单1子菜单2tab3功能',
  `group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限组',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NULL DEFAULT NULL COMMENT '是否可用0可用1不可用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60146 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色接口权限信息表\r\n@author Laixiaopeng' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_resource_t
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_t`;
CREATE TABLE `role_resource_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限关联表',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6422 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_t
-- ----------------------------
DROP TABLE IF EXISTS `role_t`;
CREATE TABLE `role_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `deleted` tinyint(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `deleted` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 385 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_internationalization
-- ----------------------------
DROP TABLE IF EXISTS `sys_internationalization`;
CREATE TABLE `sys_internationalization`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态 0-未启用，1-启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `request_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作IP',
  `type` int(11) NULL DEFAULT NULL COMMENT '操作类型 1 操作记录2异常记录',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作人',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作描述',
  `action_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方法',
  `action_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求参数',
  `ua` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '浏览器',
  `class_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类路径',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方法',
  `operate_type` int(11) NULL DEFAULT NULL COMMENT '操作类型',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '开始时间',
  `finish_time` timestamp(0) NULL DEFAULT NULL COMMENT '完成时间',
  `consuming_time` bigint(20) NULL DEFAULT NULL COMMENT '消耗时间',
  `ex_desc` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '异常详情信息',
  `ex_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '异常描述',
  `tenant_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_type`(`type`) USING BTREE COMMENT '日志类型'
) ENGINE = InnoDB AUTO_INCREMENT = 471425 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `client_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户端Id',
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端秘钥',
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '域',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限',
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自动放行',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端信息表' ROW_FORMAT = Dynamic;
INSERT INTO `client`.`sys_oauth_client_details`(`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('scm', NULL, '123456', 'server', 'password,authorization_code,client_credentials,refresh_token', 'https://www.haylion.com', NULL, 1728000, 1728000, NULL, 'false');

-- ----------------------------
-- Table structure for user_role_t
-- ----------------------------
DROP TABLE IF EXISTS `user_role_t`;
CREATE TABLE `user_role_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联表ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工信息表ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `head_icon_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '公司ID',
  `d_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `p_id` int(11) NULL DEFAULT NULL COMMENT '职位ID',
  `login_permission` int(11) NULL DEFAULT 0 COMMENT 'loginPermission',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `state` int(11) NULL DEFAULT 0 COMMENT '用户帐号状态 0待审核，1正常，2冻结状态',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password_modified` int(11) NULL DEFAULT 0 COMMENT '是否修改密码0：否 1：是',
  `message_state` int(11) NULL DEFAULT 1 COMMENT '是否开启短信提醒(0:否,1:是)',
  `remark` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'for_rail_car',
  `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
