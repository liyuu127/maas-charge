/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.204mc-dev
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : 192.168.100.204:3306
 Source Schema         : mass_charge

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 22/11/2022 17:33:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `app_flag` smallint(0) NOT NULL DEFAULT 1 COMMENT 'app标识 [暂不使用]',
  `app_type` smallint(0) NULL DEFAULT NULL COMMENT 'app类型 1-移动端(Android) 2-移动端(IOS) 3-车载端(Android) 4-PC端(Windows)',
  `version_number` int(0) NULL DEFAULT NULL COMMENT '版本号',
  `version_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '版本名称',
  `forced_updated_instructions` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '强制更新说明',
  `updated_instructions` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新说明',
  `min_version_number` int(0) NULL DEFAULT NULL COMMENT '最低版本',
  `upload_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '下载地址',
  `created_at` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(3) NULL DEFAULT NULL COMMENT '上次更新时间',
  `deleted` smallint(0) NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除 1-已删除',
  `valid` tinyint(0) NULL DEFAULT NULL COMMENT '是否是当前生效版本 0-否 1-是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = 'app管理表\r\n@author Laixiaopeng' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_info
-- ----------------------------

-- ----------------------------
-- Table structure for color_dict
-- ----------------------------
DROP TABLE IF EXISTS `color_dict`;
CREATE TABLE `color_dict`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '颜色名称',
  `value` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '颜色RGB值',
  `source_type` int(0) NOT NULL COMMENT '1:职位',
  `deleted` int(0) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color_dict
-- ----------------------------
INSERT INTO `color_dict` VALUES (1, '运维人员', '#fff2cc', 1, 0);
INSERT INTO `color_dict` VALUES (13, '管理员', '#f2f2f2', 1, 0);
INSERT INTO `color_dict` VALUES (14, '供应商', '#d9d9d9', 1, 0);

-- ----------------------------
-- Table structure for company_t
-- ----------------------------
DROP TABLE IF EXISTS `company_t`;
CREATE TABLE `company_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '单位表ID',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `type` int(0) NULL DEFAULT NULL COMMENT '单位类型: 1:作业单位、2:运维单位、3:业主单位',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `color` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `res_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '责任人名称',
  `res_mobile` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '责任人联系方式',
  `inner_company` int(0) NULL DEFAULT NULL COMMENT '是否内部单位',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `supplier_code` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '供应商代号',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '单位(公司)表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_t
-- ----------------------------
INSERT INTO `company_t` VALUES (1, '深圳市君兰电子有限公司', 2, '', '', '', 'liyu', '15626250969', 0, '翻斗花园', 'gys1', NULL, NULL, 'liyu', '2022-05-24 16:45:59', 0);
INSERT INTO `company_t` VALUES (6, '深圳市渊联技术有限公司', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'gys1', 'liyu', '2022-05-24 16:45:52', 'a17666111890', '2022-09-30 14:49:00', 0);
INSERT INTO `company_t` VALUES (7, '供应商公司1', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '22', 'liyu', '2022-05-24 16:46:37', 'liyu', '2022-10-18 16:31:40', 0);
INSERT INTO `company_t` VALUES (8, '测试新建', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '9gt', 'liyu', '2022-10-18 16:18:38', 'liyu', '2022-10-18 16:35:26', 0);
INSERT INTO `company_t` VALUES (9, '11', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '11', 'a17666111890', '2022-10-18 16:39:32', NULL, NULL, 0);

-- ----------------------------
-- Table structure for department_t
-- ----------------------------
DROP TABLE IF EXISTS `department_t`;
CREATE TABLE `department_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '部门表ID',
  `c_id` int(0) NULL DEFAULT NULL COMMENT '公司ID',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `res_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `res_mobile` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '负责人手机号',
  `color` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `create_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_t
-- ----------------------------
INSERT INTO `department_t` VALUES (6, 1, '生产管理部', NULL, NULL, NULL, NULL, NULL, 'liyu', '2022-05-24 15:27:03', 'a17666111890', '2022-09-30 12:14:22', 0);
INSERT INTO `department_t` VALUES (11, 6, 'IT部', NULL, NULL, NULL, NULL, NULL, 'a17666111890', '2022-09-30 14:16:27', NULL, NULL, 0);
INSERT INTO `department_t` VALUES (12, 7, '222', NULL, NULL, NULL, NULL, NULL, 'a17666111890', '2022-10-18 15:40:42', NULL, NULL, 0);

-- ----------------------------
-- Table structure for lookup_child_t
-- ----------------------------
DROP TABLE IF EXISTS `lookup_child_t`;
CREATE TABLE `lookup_child_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(0) NOT NULL COMMENT '上级ID',
  `value` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'value值',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `orders` int(0) NULL DEFAULT NULL COMMENT '内部排序',
  `status` int(0) NULL DEFAULT 1 COMMENT '状态(0-禁用,1-启用)',
  `attr1` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '属性1',
  `attr2` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '属性2',
  `attr3` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '属性3',
  `attr4` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '属性4',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lookup_child_t
-- ----------------------------

-- ----------------------------
-- Table structure for lookup_parent_t
-- ----------------------------
DROP TABLE IF EXISTS `lookup_parent_t`;
CREATE TABLE `lookup_parent_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `value` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'value值',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `app_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lookup_parent_t
-- ----------------------------

-- ----------------------------
-- Table structure for position_t
-- ----------------------------
DROP TABLE IF EXISTS `position_t`;
CREATE TABLE `position_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职位信息表ID',
  `d_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `color_id` int(0) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 175 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position_t
-- ----------------------------
INSERT INTO `position_t` VALUES (165, 6, '系统管理员', NULL, 14, NULL, 'liyu', '2022-05-24 16:40:35', NULL, NULL, 0);
INSERT INTO `position_t` VALUES (171, 11, '开发工程师', NULL, 1, NULL, 'a17666111890', '2022-09-30 14:16:44', NULL, NULL, 0);
INSERT INTO `position_t` VALUES (172, 11, '测试工程师', NULL, 13, NULL, 'a17666111890', '2022-09-30 14:16:59', 'a17666111890', '2022-09-30 14:32:12', 0);
INSERT INTO `position_t` VALUES (173, 12, '222', NULL, 13, NULL, 'a17666111890', '2022-10-18 15:40:53', NULL, NULL, 0);
INSERT INTO `position_t` VALUES (174, 11, 'jj', NULL, 1, NULL, 'liyu', '2022-11-03 17:04:07', NULL, NULL, 0);

-- ----------------------------
-- Table structure for project_t
-- ----------------------------
DROP TABLE IF EXISTS `project_t`;
CREATE TABLE `project_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '项目介绍表ID',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '背景图片',
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_t
-- ----------------------------

-- ----------------------------
-- Table structure for resource_t
-- ----------------------------
DROP TABLE IF EXISTS `resource_t`;
CREATE TABLE `resource_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `p_id` int(0) NULL DEFAULT NULL COMMENT '父级ID',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型0菜单1子菜单2tab3功能',
  `group` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限组',
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `method` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '方法',
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '路径',
  `note` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(0) NULL DEFAULT NULL COMMENT '是否可用0可用1不可用',
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60146 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色接口权限信息表\r\n@author Laixiaopeng' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_t
-- ----------------------------
INSERT INTO `resource_t` VALUES (1, '首页', 0, 0, '首页', 'default', NULL, '/projectIntroduction', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (2, '基础权限', 0, 0, '基础权限', 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3, '单位管理', 0, 0, '单位管理', 'default', NULL, '/unitManagement', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4, '系统设置', 0, 0, '系统设置', 'default', NULL, '/setting', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (5, '告警管理', 0, 0, '告警管理', 'default', NULL, '/alarmManagement', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6, '订单管理', 0, 0, '订单管理', 'default', NULL, '/order-management', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7, '字典管理', 0, 0, '字典管理', 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (201, '查询人员详情', 2, 3, '基础权限', 'user:select', '/user/info', '/unitManagement/index/user/:detail', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (202, '修改密码', 2, 3, '基础权限', 'user:password', '/user/password/update', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (203, '资源列表', 2, 3, '基础权限', 'resource:list', '/resource/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (204, '消息管理', 2, 2, '基础权限', 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (301, '公司', 3, 2, '单位管理', 'default', NULL, '/unitManagement/index/company', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (302, '部门', 3, 2, '单位管理', 'default', NULL, '/unitManagement/index/department', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (303, '职位', 3, 2, '单位管理', 'default', NULL, '/unitManagement/index/job', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (304, '人员', 3, 2, '单位管理', 'default', NULL, '/unitManagement/index/staff', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (401, 'APP管理', 4, 1, '系统设置', 'default', NULL, '/setting/app', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (402, '角色管理', 4, 1, '系统设置', 'default', '', '/setting/role', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (403, 'lookup管理', 4, 1, '系统设置', 'default', NULL, '/setting/lookup', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (404, '国际化配置管理', 4, 1, '系统设置', 'default', '/internationalization', '/setting/internationalization', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (501, '告警管理', 5, 1, '告警管理', 'default', NULL, '/alarmManagement', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (601, '订单协同', 6, 1, '订单管理', 'default', NULL, '/order-management/orderCollaboration', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (602, '单品码查收与打印', 6, 1, '订单管理', 'default', NULL, '/order-management/itemCode', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (603, '质量协同', 6, 1, '订单管理', 'default', NULL, '/order-management/qualityCollaboration', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (604, '供应商门户', 6, 1, '订单管理', 'default', NULL, '/order-management/supplierPortal', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (701, '颜色字典', 7, 2, '字典管理', 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (2041, '消息通知', 204, 3, '基础权限', 'notice:select', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (2042, '消息阅读', 204, 3, '基础权限', 'notice:read', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (2043, '消息删除', 204, 3, '基础权限', 'notice:delete', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3011, '公司列表', 301, 3, '单位管理', 'company:list', '/company/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3012, '公司信息', 301, 3, '单位管理', 'company:info', '/company/info', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3013, '公司新增', 301, 3, '单位管理', 'company:insert', '/company/insert', '/unitManagement/index/company/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3014, '公司更新', 301, 3, '单位管理', 'company:update', '/company/update', '/unitManagement/index/company/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3015, '公司删除', 301, 3, '单位管理', 'company:delete', '/company/delete', '/unitManagement/index/company/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3021, '部门列表', 302, 3, '单位管理', 'department:list', '/department/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3022, '部门信息', 302, 3, '单位管理', 'department:info', '/department/info', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3023, '部门新增', 302, 3, '单位管理', 'department:insert', '/department/insert', '/unitManagement/index/department/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3024, '部门更新', 302, 3, '单位管理', 'department:update', '/department/update', '/unitManagement/index/department/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3025, '部门删除', 302, 3, '单位管理', 'department:delete', '/department/delete', '/unitManagement/index/department/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3031, '职位列表', 303, 3, '单位管理', 'position:list', '/position/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3032, '职位信息', 303, 3, '单位管理', 'position:info', '/position/info', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3033, '职位新增', 303, 3, '单位管理', 'position:insert', '/position/insert', '/unitManagement/index/job/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3034, '职位更新', 303, 3, '单位管理', 'position:update', '/position/update', '/unitManagement/index/job/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3035, '职位删除', 303, 3, '单位管理', 'position:delete', '/position/delete', '/unitManagement/index/job/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3036, '审核', 304, 3, '单位管理', 'default', NULL, '/unitManagement/index/user/:review', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3041, '用户新建', 304, 3, '单位管理', 'user:insert', '/user/insert', '/unitManagement/index/user/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3042, '用户删除', 304, 3, '单位管理', 'user:delete', '/user/delete', '/unitManagement/index/user/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3043, '用户更新', 304, 3, '单位管理', 'user:update', '/user/update', '/unitManagement/index/user/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3044, '修改人员状态信息', 304, 3, '单位管理', 'user:state:update', '/user/state/update', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3045, '查询人员列表', 304, 3, '单位管理', 'user:list', '/user/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (3046, '修改账号手机号', 304, 3, '单位管理', 'user:phone:update', '/user/phone/update', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4011, 'APP管理', 401, 2, '系统设置', 'default', NULL, '/setting/app/app', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4021, '角色管理', 402, 2, '系统设置', 'default', NULL, '/setting/role/roleSetting', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4031, 'lookup管理', 403, 2, '系统设置', 'default', NULL, '/setting/lookup', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4032, 'lookup子项', 403, 2, '系统设置', 'lookup:child:list', NULL, '', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4041, '分页查询国际化配置列表', 404, 2, '系统设置', 'internationalization:list', '/internationalization', '/setting/internationalization/internationalizationList', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4042, '新增国际化配置', 404, 3, '系统设置', 'internationalization:insert', '/internationalization', '/setting/internationalization/internationalizationList/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4043, '编辑国际化配置', 404, 3, '系统设置', 'internationalization:audit', '/internationalization', '/setting/internationalization/internationalizationList/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (4044, '删除国际化配置', 404, 3, '系统设置', 'internationalization:delete', '/internationalization', '/setting/internationalization/internationalizationList/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (5011, '告警管理', 501, 2, '告警管理', 'default', NULL, '/alarmManagement/index/alarmList', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6011, '订单列表', 601, 2, '订单管理', 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6012, '订单详情', 601, 2, NULL, 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6013, '订单跟踪', 601, 2, NULL, 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6014, '报工', 601, 2, NULL, 'default', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6021, '单品码列表', 602, 3, '订单管理', 'itemCode:list', '/itemCode/list', '/order/itemcode/index', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6022, '单品码查询', 602, 3, '订单管理', 'itemCode:select', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6023, '单品码新增', 602, 3, '订单管理', 'itemCode:insert', NULL, '/itemCode/add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6024, '单品码信息修改', 602, 3, '订单管理', 'itemCode:list', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6025, '单品码-物料模糊查询', 602, 3, '订单管理', 'itemCode:select', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6026, '单品码导出', 602, 3, '订单管理', 'default', NULL, '/itemCode/export', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6027, '单品码打印', 602, 3, '订单管理', 'default', NULL, '/itemCode/print', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6031, '质量协同列表', 603, 3, '订单管理', 'quality:list', NULL, '/quality/info', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6032, '质量协同统计', 603, 3, '订单管理', 'quality:count', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (6033, '质量协同详情', 603, 3, '订单管理', 'quality:info', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7011, '颜色新增', 701, 3, '字典管理', 'color:insert', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7012, '颜色编辑', 701, 3, '字典管理', 'color:update', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7013, '颜色列表', 701, 3, '字典管理', 'color:list', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7014, '颜色详情', 701, 3, '字典管理', 'color:info', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (7015, '颜色删除', 701, 3, '字典管理', 'color:delete', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40111, '新建', 4011, 3, '系统设置', 'default', NULL, '/setting/app/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40112, '下载APP', 4011, 3, '系统设置', 'default', NULL, '/setting/app/:download', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40113, '修改', 4011, 3, '系统设置', 'default', NULL, '/setting/app/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40114, '发布', 4011, 3, '系统设置', 'default', NULL, '/setting/app/:release', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40221, '角色列表查看', 4021, 3, '系统设置', 'role:list', '/role/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40222, '角色信息查询', 4021, 3, '系统设置', 'role:info', '/role/info', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40223, '角色新增', 4021, 3, '系统设置', 'role:insert', '/role/insert', '/setting/role/:add', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40224, '角色更新', 4021, 3, '系统设置', 'role:update', '/role/update', '/setting/role/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40225, '角色删除', 4021, 3, '系统设置', 'role:delete', '/role/delete', '/setting/role/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40311, '列表查看', 4031, 3, '系统设置', 'lookup:list', NULL, '/setting/lookup', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40312, '新增', 4031, 3, '系统设置', 'lookup:insert', NULL, '/setting/lookup/:insert', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40313, '编辑', 4031, 3, '系统设置', 'lookup:update', NULL, '/setting/lookup/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40314, '删除', 4031, 3, '系统设置', 'lookup:delete', NULL, '/setting/lookup/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40315, '详情', 4031, 3, '系统设置', 'lookup:info', NULL, '/setting/lookup/:info', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40321, '子项新增', 4032, 3, '系统设置', 'lookup:child:add', NULL, '/setting/lookup/child/:insert', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40322, '子项编辑', 4032, 3, '系统设置', 'lookup:child:update', NULL, '/setting/lookup/child/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (40323, '子项删除', 4032, 3, '系统设置', 'lookup:child:delete', NULL, '/setting/lookup/child/:delete', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (50111, '告警分页查询', 5011, 3, '告警管理', 'warn:list', '/warn', '/alarmManagement/index/alarmList', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (50112, '告警查询', 5011, 3, '告警管理', 'warn:select', '/warn', '/alarmManagement/index/alarmList/:detail', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (50113, '告警信息更新', 5011, 3, '告警管理', 'warn:audit', '/warn', '/alarmManagement/index/alarmList/:update', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60111, '订单列表查询', 6011, 3, '订单管理', 'order:list', '/order/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60112, '订单状态统计', 6011, 3, '订单管理', 'order:statistics:status', '/order/statistics/status', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60113, '订单同步任务', 6011, 3, '订单管理', 'job:trigger', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60121, '订单详情查询', 6012, 3, '订单管理', 'order:info', '/order/info', '/order/info', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60131, '订单状态流转', 6013, 3, '订单管理', 'order:operate:state', '/order/operate/state', '/order/operate/state', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60132, '订单状态流转记录', 6013, 3, '订单管理', 'order:operate:records', '/order/operate/record/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60141, '报工记录查询', 6014, 3, '订单管理', 'order:report:list', '/order/report/list', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60142, '报工记录更新', 6014, 3, '订单管理', 'order:report:update', '/order/report/update', '/order/report/edit', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60143, '报工记录删除', 6014, 3, '订单管理', 'order:report:delete', '/order/report/delete', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60144, '已报工数量查询', 6014, 3, '订单管理', 'order:report:count', '/order/report/count', NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `resource_t` VALUES (60145, '新增报工记录', 6014, 3, '订单管理', 'order:report:add', '/order/report/add', '/order/report/add', NULL, 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_resource_t
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_t`;
CREATE TABLE `role_resource_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色权限关联表',
  `role_id` int(0) NOT NULL COMMENT '角色ID',
  `resource_id` int(0) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6422 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource_t
-- ----------------------------
INSERT INTO `role_resource_t` VALUES (5764, 17, 1);
INSERT INTO `role_resource_t` VALUES (5765, 17, 2);
INSERT INTO `role_resource_t` VALUES (5766, 17, 201);
INSERT INTO `role_resource_t` VALUES (5767, 17, 202);
INSERT INTO `role_resource_t` VALUES (5768, 17, 203);
INSERT INTO `role_resource_t` VALUES (5769, 17, 204);
INSERT INTO `role_resource_t` VALUES (5770, 17, 2041);
INSERT INTO `role_resource_t` VALUES (5771, 17, 2042);
INSERT INTO `role_resource_t` VALUES (5772, 17, 2043);
INSERT INTO `role_resource_t` VALUES (5773, 17, 3);
INSERT INTO `role_resource_t` VALUES (5774, 17, 301);
INSERT INTO `role_resource_t` VALUES (5775, 17, 3011);
INSERT INTO `role_resource_t` VALUES (5776, 17, 3012);
INSERT INTO `role_resource_t` VALUES (5777, 17, 3013);
INSERT INTO `role_resource_t` VALUES (5778, 17, 3014);
INSERT INTO `role_resource_t` VALUES (5779, 17, 3015);
INSERT INTO `role_resource_t` VALUES (5780, 17, 302);
INSERT INTO `role_resource_t` VALUES (5781, 17, 3021);
INSERT INTO `role_resource_t` VALUES (5782, 17, 3022);
INSERT INTO `role_resource_t` VALUES (5783, 17, 3023);
INSERT INTO `role_resource_t` VALUES (5784, 17, 3024);
INSERT INTO `role_resource_t` VALUES (5785, 17, 3025);
INSERT INTO `role_resource_t` VALUES (5786, 17, 303);
INSERT INTO `role_resource_t` VALUES (5787, 17, 3031);
INSERT INTO `role_resource_t` VALUES (5788, 17, 3032);
INSERT INTO `role_resource_t` VALUES (5789, 17, 3033);
INSERT INTO `role_resource_t` VALUES (5790, 17, 3034);
INSERT INTO `role_resource_t` VALUES (5791, 17, 3035);
INSERT INTO `role_resource_t` VALUES (5792, 17, 304);
INSERT INTO `role_resource_t` VALUES (5793, 17, 3036);
INSERT INTO `role_resource_t` VALUES (5794, 17, 3041);
INSERT INTO `role_resource_t` VALUES (5795, 17, 3042);
INSERT INTO `role_resource_t` VALUES (5796, 17, 3043);
INSERT INTO `role_resource_t` VALUES (5797, 17, 3044);
INSERT INTO `role_resource_t` VALUES (5798, 17, 3045);
INSERT INTO `role_resource_t` VALUES (5799, 17, 3046);
INSERT INTO `role_resource_t` VALUES (5800, 17, 5);
INSERT INTO `role_resource_t` VALUES (5801, 17, 501);
INSERT INTO `role_resource_t` VALUES (5802, 17, 5011);
INSERT INTO `role_resource_t` VALUES (5803, 17, 50111);
INSERT INTO `role_resource_t` VALUES (5804, 17, 50112);
INSERT INTO `role_resource_t` VALUES (5805, 17, 50113);
INSERT INTO `role_resource_t` VALUES (5806, 17, 6);
INSERT INTO `role_resource_t` VALUES (5807, 17, 601);
INSERT INTO `role_resource_t` VALUES (5808, 17, 6011);
INSERT INTO `role_resource_t` VALUES (5809, 17, 60111);
INSERT INTO `role_resource_t` VALUES (5810, 17, 60112);
INSERT INTO `role_resource_t` VALUES (5811, 17, 6012);
INSERT INTO `role_resource_t` VALUES (5812, 17, 60121);
INSERT INTO `role_resource_t` VALUES (5813, 17, 6013);
INSERT INTO `role_resource_t` VALUES (5814, 17, 60131);
INSERT INTO `role_resource_t` VALUES (5815, 17, 60132);
INSERT INTO `role_resource_t` VALUES (5816, 17, 6014);
INSERT INTO `role_resource_t` VALUES (5817, 17, 60141);
INSERT INTO `role_resource_t` VALUES (5818, 17, 60142);
INSERT INTO `role_resource_t` VALUES (5819, 17, 60143);
INSERT INTO `role_resource_t` VALUES (5820, 17, 60144);
INSERT INTO `role_resource_t` VALUES (5821, 17, 60145);
INSERT INTO `role_resource_t` VALUES (5822, 17, 602);
INSERT INTO `role_resource_t` VALUES (5823, 17, 6021);
INSERT INTO `role_resource_t` VALUES (5824, 17, 6022);
INSERT INTO `role_resource_t` VALUES (5825, 17, 6023);
INSERT INTO `role_resource_t` VALUES (5826, 17, 6024);
INSERT INTO `role_resource_t` VALUES (5827, 17, 6025);
INSERT INTO `role_resource_t` VALUES (5828, 17, 603);
INSERT INTO `role_resource_t` VALUES (5829, 17, 6031);
INSERT INTO `role_resource_t` VALUES (5830, 17, 6032);
INSERT INTO `role_resource_t` VALUES (5831, 17, 6033);
INSERT INTO `role_resource_t` VALUES (5832, 17, 604);
INSERT INTO `role_resource_t` VALUES (6093, 3, 1);
INSERT INTO `role_resource_t` VALUES (6094, 3, 2);
INSERT INTO `role_resource_t` VALUES (6095, 3, 201);
INSERT INTO `role_resource_t` VALUES (6096, 3, 202);
INSERT INTO `role_resource_t` VALUES (6097, 3, 203);
INSERT INTO `role_resource_t` VALUES (6098, 3, 204);
INSERT INTO `role_resource_t` VALUES (6099, 3, 2041);
INSERT INTO `role_resource_t` VALUES (6100, 3, 2042);
INSERT INTO `role_resource_t` VALUES (6101, 3, 2043);
INSERT INTO `role_resource_t` VALUES (6102, 3, 5);
INSERT INTO `role_resource_t` VALUES (6103, 3, 501);
INSERT INTO `role_resource_t` VALUES (6104, 3, 5011);
INSERT INTO `role_resource_t` VALUES (6105, 3, 50111);
INSERT INTO `role_resource_t` VALUES (6106, 3, 50112);
INSERT INTO `role_resource_t` VALUES (6107, 3, 50113);
INSERT INTO `role_resource_t` VALUES (6108, 3, 6);
INSERT INTO `role_resource_t` VALUES (6109, 3, 601);
INSERT INTO `role_resource_t` VALUES (6110, 3, 6011);
INSERT INTO `role_resource_t` VALUES (6111, 3, 60111);
INSERT INTO `role_resource_t` VALUES (6112, 3, 60112);
INSERT INTO `role_resource_t` VALUES (6113, 3, 6012);
INSERT INTO `role_resource_t` VALUES (6114, 3, 60121);
INSERT INTO `role_resource_t` VALUES (6115, 3, 6013);
INSERT INTO `role_resource_t` VALUES (6116, 3, 60131);
INSERT INTO `role_resource_t` VALUES (6117, 3, 60132);
INSERT INTO `role_resource_t` VALUES (6118, 3, 6014);
INSERT INTO `role_resource_t` VALUES (6119, 3, 60141);
INSERT INTO `role_resource_t` VALUES (6120, 3, 60142);
INSERT INTO `role_resource_t` VALUES (6121, 3, 60143);
INSERT INTO `role_resource_t` VALUES (6122, 3, 60144);
INSERT INTO `role_resource_t` VALUES (6123, 3, 60145);
INSERT INTO `role_resource_t` VALUES (6124, 3, 602);
INSERT INTO `role_resource_t` VALUES (6125, 3, 6021);
INSERT INTO `role_resource_t` VALUES (6126, 3, 6022);
INSERT INTO `role_resource_t` VALUES (6127, 3, 6023);
INSERT INTO `role_resource_t` VALUES (6128, 3, 6024);
INSERT INTO `role_resource_t` VALUES (6129, 3, 6025);
INSERT INTO `role_resource_t` VALUES (6130, 3, 6026);
INSERT INTO `role_resource_t` VALUES (6131, 3, 6027);
INSERT INTO `role_resource_t` VALUES (6132, 3, 603);
INSERT INTO `role_resource_t` VALUES (6133, 3, 6031);
INSERT INTO `role_resource_t` VALUES (6134, 3, 6032);
INSERT INTO `role_resource_t` VALUES (6135, 3, 6033);
INSERT INTO `role_resource_t` VALUES (6136, 3, 604);
INSERT INTO `role_resource_t` VALUES (6137, 2, 4);
INSERT INTO `role_resource_t` VALUES (6138, 2, 402);
INSERT INTO `role_resource_t` VALUES (6139, 2, 4021);
INSERT INTO `role_resource_t` VALUES (6140, 2, 6);
INSERT INTO `role_resource_t` VALUES (6141, 2, 601);
INSERT INTO `role_resource_t` VALUES (6142, 2, 6014);
INSERT INTO `role_resource_t` VALUES (6143, 2, 602);
INSERT INTO `role_resource_t` VALUES (6144, 2, 1);
INSERT INTO `role_resource_t` VALUES (6145, 2, 2);
INSERT INTO `role_resource_t` VALUES (6146, 2, 201);
INSERT INTO `role_resource_t` VALUES (6147, 2, 202);
INSERT INTO `role_resource_t` VALUES (6148, 2, 203);
INSERT INTO `role_resource_t` VALUES (6149, 2, 204);
INSERT INTO `role_resource_t` VALUES (6150, 2, 2041);
INSERT INTO `role_resource_t` VALUES (6151, 2, 2042);
INSERT INTO `role_resource_t` VALUES (6152, 2, 2043);
INSERT INTO `role_resource_t` VALUES (6153, 2, 3);
INSERT INTO `role_resource_t` VALUES (6154, 2, 301);
INSERT INTO `role_resource_t` VALUES (6155, 2, 3011);
INSERT INTO `role_resource_t` VALUES (6156, 2, 3012);
INSERT INTO `role_resource_t` VALUES (6157, 2, 3013);
INSERT INTO `role_resource_t` VALUES (6158, 2, 3014);
INSERT INTO `role_resource_t` VALUES (6159, 2, 3015);
INSERT INTO `role_resource_t` VALUES (6160, 2, 302);
INSERT INTO `role_resource_t` VALUES (6161, 2, 3021);
INSERT INTO `role_resource_t` VALUES (6162, 2, 3022);
INSERT INTO `role_resource_t` VALUES (6163, 2, 3023);
INSERT INTO `role_resource_t` VALUES (6164, 2, 3024);
INSERT INTO `role_resource_t` VALUES (6165, 2, 3025);
INSERT INTO `role_resource_t` VALUES (6166, 2, 303);
INSERT INTO `role_resource_t` VALUES (6167, 2, 3031);
INSERT INTO `role_resource_t` VALUES (6168, 2, 3032);
INSERT INTO `role_resource_t` VALUES (6169, 2, 3033);
INSERT INTO `role_resource_t` VALUES (6170, 2, 3034);
INSERT INTO `role_resource_t` VALUES (6171, 2, 3035);
INSERT INTO `role_resource_t` VALUES (6172, 2, 304);
INSERT INTO `role_resource_t` VALUES (6173, 2, 3036);
INSERT INTO `role_resource_t` VALUES (6174, 2, 3041);
INSERT INTO `role_resource_t` VALUES (6175, 2, 3042);
INSERT INTO `role_resource_t` VALUES (6176, 2, 3043);
INSERT INTO `role_resource_t` VALUES (6177, 2, 3044);
INSERT INTO `role_resource_t` VALUES (6178, 2, 3045);
INSERT INTO `role_resource_t` VALUES (6179, 2, 3046);
INSERT INTO `role_resource_t` VALUES (6180, 2, 40221);
INSERT INTO `role_resource_t` VALUES (6181, 2, 5);
INSERT INTO `role_resource_t` VALUES (6182, 2, 501);
INSERT INTO `role_resource_t` VALUES (6183, 2, 5011);
INSERT INTO `role_resource_t` VALUES (6184, 2, 50111);
INSERT INTO `role_resource_t` VALUES (6185, 2, 50112);
INSERT INTO `role_resource_t` VALUES (6186, 2, 50113);
INSERT INTO `role_resource_t` VALUES (6187, 2, 6011);
INSERT INTO `role_resource_t` VALUES (6188, 2, 60111);
INSERT INTO `role_resource_t` VALUES (6189, 2, 60112);
INSERT INTO `role_resource_t` VALUES (6190, 2, 6012);
INSERT INTO `role_resource_t` VALUES (6191, 2, 60121);
INSERT INTO `role_resource_t` VALUES (6192, 2, 6013);
INSERT INTO `role_resource_t` VALUES (6193, 2, 60131);
INSERT INTO `role_resource_t` VALUES (6194, 2, 60132);
INSERT INTO `role_resource_t` VALUES (6195, 2, 60141);
INSERT INTO `role_resource_t` VALUES (6196, 2, 60144);
INSERT INTO `role_resource_t` VALUES (6197, 2, 60145);
INSERT INTO `role_resource_t` VALUES (6198, 2, 6021);
INSERT INTO `role_resource_t` VALUES (6199, 2, 6022);
INSERT INTO `role_resource_t` VALUES (6200, 2, 6025);
INSERT INTO `role_resource_t` VALUES (6201, 2, 6026);
INSERT INTO `role_resource_t` VALUES (6202, 2, 603);
INSERT INTO `role_resource_t` VALUES (6203, 2, 6031);
INSERT INTO `role_resource_t` VALUES (6204, 2, 6032);
INSERT INTO `role_resource_t` VALUES (6205, 2, 6033);
INSERT INTO `role_resource_t` VALUES (6206, 2, 604);
INSERT INTO `role_resource_t` VALUES (6313, 1, 1);
INSERT INTO `role_resource_t` VALUES (6314, 1, 2);
INSERT INTO `role_resource_t` VALUES (6315, 1, 201);
INSERT INTO `role_resource_t` VALUES (6316, 1, 202);
INSERT INTO `role_resource_t` VALUES (6317, 1, 203);
INSERT INTO `role_resource_t` VALUES (6318, 1, 204);
INSERT INTO `role_resource_t` VALUES (6319, 1, 2041);
INSERT INTO `role_resource_t` VALUES (6320, 1, 2042);
INSERT INTO `role_resource_t` VALUES (6321, 1, 2043);
INSERT INTO `role_resource_t` VALUES (6322, 1, 3);
INSERT INTO `role_resource_t` VALUES (6323, 1, 301);
INSERT INTO `role_resource_t` VALUES (6324, 1, 3011);
INSERT INTO `role_resource_t` VALUES (6325, 1, 3012);
INSERT INTO `role_resource_t` VALUES (6326, 1, 3013);
INSERT INTO `role_resource_t` VALUES (6327, 1, 3014);
INSERT INTO `role_resource_t` VALUES (6328, 1, 3015);
INSERT INTO `role_resource_t` VALUES (6329, 1, 302);
INSERT INTO `role_resource_t` VALUES (6330, 1, 3021);
INSERT INTO `role_resource_t` VALUES (6331, 1, 3022);
INSERT INTO `role_resource_t` VALUES (6332, 1, 3023);
INSERT INTO `role_resource_t` VALUES (6333, 1, 3024);
INSERT INTO `role_resource_t` VALUES (6334, 1, 3025);
INSERT INTO `role_resource_t` VALUES (6335, 1, 303);
INSERT INTO `role_resource_t` VALUES (6336, 1, 3031);
INSERT INTO `role_resource_t` VALUES (6337, 1, 3032);
INSERT INTO `role_resource_t` VALUES (6338, 1, 3033);
INSERT INTO `role_resource_t` VALUES (6339, 1, 3034);
INSERT INTO `role_resource_t` VALUES (6340, 1, 3035);
INSERT INTO `role_resource_t` VALUES (6341, 1, 304);
INSERT INTO `role_resource_t` VALUES (6342, 1, 3036);
INSERT INTO `role_resource_t` VALUES (6343, 1, 3041);
INSERT INTO `role_resource_t` VALUES (6344, 1, 3042);
INSERT INTO `role_resource_t` VALUES (6345, 1, 3043);
INSERT INTO `role_resource_t` VALUES (6346, 1, 3044);
INSERT INTO `role_resource_t` VALUES (6347, 1, 3045);
INSERT INTO `role_resource_t` VALUES (6348, 1, 3046);
INSERT INTO `role_resource_t` VALUES (6349, 1, 4);
INSERT INTO `role_resource_t` VALUES (6350, 1, 401);
INSERT INTO `role_resource_t` VALUES (6351, 1, 4011);
INSERT INTO `role_resource_t` VALUES (6352, 1, 40111);
INSERT INTO `role_resource_t` VALUES (6353, 1, 40112);
INSERT INTO `role_resource_t` VALUES (6354, 1, 40113);
INSERT INTO `role_resource_t` VALUES (6355, 1, 40114);
INSERT INTO `role_resource_t` VALUES (6356, 1, 402);
INSERT INTO `role_resource_t` VALUES (6357, 1, 4021);
INSERT INTO `role_resource_t` VALUES (6358, 1, 40221);
INSERT INTO `role_resource_t` VALUES (6359, 1, 40222);
INSERT INTO `role_resource_t` VALUES (6360, 1, 40223);
INSERT INTO `role_resource_t` VALUES (6361, 1, 40224);
INSERT INTO `role_resource_t` VALUES (6362, 1, 40225);
INSERT INTO `role_resource_t` VALUES (6363, 1, 403);
INSERT INTO `role_resource_t` VALUES (6364, 1, 4031);
INSERT INTO `role_resource_t` VALUES (6365, 1, 40311);
INSERT INTO `role_resource_t` VALUES (6366, 1, 40312);
INSERT INTO `role_resource_t` VALUES (6367, 1, 40313);
INSERT INTO `role_resource_t` VALUES (6368, 1, 40314);
INSERT INTO `role_resource_t` VALUES (6369, 1, 40315);
INSERT INTO `role_resource_t` VALUES (6370, 1, 4032);
INSERT INTO `role_resource_t` VALUES (6371, 1, 40321);
INSERT INTO `role_resource_t` VALUES (6372, 1, 40322);
INSERT INTO `role_resource_t` VALUES (6373, 1, 40323);
INSERT INTO `role_resource_t` VALUES (6374, 1, 404);
INSERT INTO `role_resource_t` VALUES (6375, 1, 4041);
INSERT INTO `role_resource_t` VALUES (6376, 1, 4042);
INSERT INTO `role_resource_t` VALUES (6377, 1, 4043);
INSERT INTO `role_resource_t` VALUES (6378, 1, 4044);
INSERT INTO `role_resource_t` VALUES (6379, 1, 5);
INSERT INTO `role_resource_t` VALUES (6380, 1, 501);
INSERT INTO `role_resource_t` VALUES (6381, 1, 5011);
INSERT INTO `role_resource_t` VALUES (6382, 1, 50111);
INSERT INTO `role_resource_t` VALUES (6383, 1, 50112);
INSERT INTO `role_resource_t` VALUES (6384, 1, 50113);
INSERT INTO `role_resource_t` VALUES (6385, 1, 6);
INSERT INTO `role_resource_t` VALUES (6386, 1, 601);
INSERT INTO `role_resource_t` VALUES (6387, 1, 6011);
INSERT INTO `role_resource_t` VALUES (6388, 1, 60111);
INSERT INTO `role_resource_t` VALUES (6389, 1, 60112);
INSERT INTO `role_resource_t` VALUES (6390, 1, 60113);
INSERT INTO `role_resource_t` VALUES (6391, 1, 6012);
INSERT INTO `role_resource_t` VALUES (6392, 1, 60121);
INSERT INTO `role_resource_t` VALUES (6393, 1, 6013);
INSERT INTO `role_resource_t` VALUES (6394, 1, 60131);
INSERT INTO `role_resource_t` VALUES (6395, 1, 60132);
INSERT INTO `role_resource_t` VALUES (6396, 1, 6014);
INSERT INTO `role_resource_t` VALUES (6397, 1, 60141);
INSERT INTO `role_resource_t` VALUES (6398, 1, 60142);
INSERT INTO `role_resource_t` VALUES (6399, 1, 60143);
INSERT INTO `role_resource_t` VALUES (6400, 1, 60144);
INSERT INTO `role_resource_t` VALUES (6401, 1, 60145);
INSERT INTO `role_resource_t` VALUES (6402, 1, 602);
INSERT INTO `role_resource_t` VALUES (6403, 1, 6021);
INSERT INTO `role_resource_t` VALUES (6404, 1, 6022);
INSERT INTO `role_resource_t` VALUES (6405, 1, 6023);
INSERT INTO `role_resource_t` VALUES (6406, 1, 6024);
INSERT INTO `role_resource_t` VALUES (6407, 1, 6025);
INSERT INTO `role_resource_t` VALUES (6408, 1, 6026);
INSERT INTO `role_resource_t` VALUES (6409, 1, 6027);
INSERT INTO `role_resource_t` VALUES (6410, 1, 603);
INSERT INTO `role_resource_t` VALUES (6411, 1, 6031);
INSERT INTO `role_resource_t` VALUES (6412, 1, 6032);
INSERT INTO `role_resource_t` VALUES (6413, 1, 6033);
INSERT INTO `role_resource_t` VALUES (6414, 1, 604);
INSERT INTO `role_resource_t` VALUES (6415, 1, 7);
INSERT INTO `role_resource_t` VALUES (6416, 1, 701);
INSERT INTO `role_resource_t` VALUES (6417, 1, 7011);
INSERT INTO `role_resource_t` VALUES (6418, 1, 7012);
INSERT INTO `role_resource_t` VALUES (6419, 1, 7013);
INSERT INTO `role_resource_t` VALUES (6420, 1, 7014);
INSERT INTO `role_resource_t` VALUES (6421, 1, 7015);

-- ----------------------------
-- Table structure for role_t
-- ----------------------------
DROP TABLE IF EXISTS `role_t`;
CREATE TABLE `role_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `color` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_t
-- ----------------------------
INSERT INTO `role_t` VALUES (1, '超级管理员', 'admin', NULL, NULL, NULL, NULL, NULL, '2022-10-24 17:30:20', 'yonghu1');
INSERT INTO `role_t` VALUES (2, '君兰', '2153120848', NULL, NULL, NULL, '2022-09-30 10:24:48', 'a17666111890', '2022-10-18 18:45:54', 'a17666111890');
INSERT INTO `role_t` VALUES (3, '供应商', '203792421221830', NULL, NULL, NULL, '2022-09-30 10:12:50', 'a17666111890', '2022-10-18 18:45:38', 'a17666111890');
INSERT INTO `role_t` VALUES (17, '管理员', '316492970221592', NULL, NULL, NULL, '2022-10-18 16:40:39', 'liyu', NULL, NULL);

-- ----------------------------
-- Table structure for site_notice_source
-- ----------------------------
DROP TABLE IF EXISTS `site_notice_source`;
CREATE TABLE `site_notice_source`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `source_id` int(0) NULL DEFAULT NULL COMMENT '事件源id',
  `source_type` tinyint(0) NULL DEFAULT NULL COMMENT '事件源类型',
  `content_type` tinyint(0) NULL DEFAULT NULL COMMENT '内容类型',
  `source_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '事件源的内容',
  `remind_time` datetime(0) NULL DEFAULT NULL COMMENT '提示时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` tinyint(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site_notice_source
-- ----------------------------

-- ----------------------------
-- Table structure for site_notice_user
-- ----------------------------
DROP TABLE IF EXISTS `site_notice_user`;
CREATE TABLE `site_notice_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `site_notice_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `state` tinyint(0) NULL DEFAULT NULL COMMENT '是否已读 1:未读；2：已读',
  `read_time` datetime(0) NULL DEFAULT NULL,
  `deleted` tinyint(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 385 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site_notice_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_internationalization
-- ----------------------------
DROP TABLE IF EXISTS `sys_internationalization`;
CREATE TABLE `sys_internationalization`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编码',
  `value` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '值',
  `status` int(0) NOT NULL DEFAULT 1 COMMENT '状态 0-未启用，1-启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_internationalization
-- ----------------------------
INSERT INTO `sys_internationalization` VALUES (25, 'scm.user.old_password_error', '密码输入不正确', 1, '2022-05-17 15:10:13', NULL);
INSERT INTO `sys_internationalization` VALUES (26, 'scm.user.username_already_exist', '用户名已存在', 1, '2022-05-19 17:41:46', NULL);
INSERT INTO `sys_internationalization` VALUES (27, 'scm.user.tel_already_exist', '手机号已存在', 1, '2022-05-19 17:42:19', NULL);
INSERT INTO `sys_internationalization` VALUES (28, 'scm.user.user_not_found', '用户不存在', 1, '2022-05-19 17:42:49', NULL);
INSERT INTO `sys_internationalization` VALUES (29, 'scm.user.color_name_repeat', '颜色名重复', 1, '2022-05-19 17:43:19', NULL);
INSERT INTO `sys_internationalization` VALUES (30, 'scm.user.user_with_position_not_null', '职位下用户不为空', 1, '2022-05-19 17:43:55', NULL);
INSERT INTO `sys_internationalization` VALUES (31, 'scm.user.position_with_department_not_null', '部门下职位不为空', 1, '2022-05-19 17:44:27', NULL);
INSERT INTO `sys_internationalization` VALUES (32, 'scm.user.department_with_company_not_null', '公司下部门不为空', 1, '2022-05-19 17:44:53', NULL);
INSERT INTO `sys_internationalization` VALUES (33, 'scm.user.position_name_already_exist', '职位名称重复', 1, '2022-05-19 17:45:52', NULL);
INSERT INTO `sys_internationalization` VALUES (34, 'scm.user.department_name_already_exist', '部门名称重复', 1, '2022-05-19 17:46:21', NULL);
INSERT INTO `sys_internationalization` VALUES (35, 'scm.user.company_name_already_exist', '公司名称重复', 1, '2022-05-19 17:46:43', NULL);
INSERT INTO `sys_internationalization` VALUES (36, 'scm.user.code_error_or_invalid', '验证码错误或失效', 1, '2022-05-19 17:47:26', NULL);
INSERT INTO `sys_internationalization` VALUES (37, 'scm.user.role_name_or_code_already_exist', '角色名称重复', 1, '2022-05-19 17:47:56', NULL);
INSERT INTO `sys_internationalization` VALUES (38, 'scm.system.ValueAlreadyExist', '值已存在', 1, '2022-05-19 17:54:29', NULL);
INSERT INTO `sys_internationalization` VALUES (39, 'scm.system.verify_code_send_repeat', '验证码发送请求重复', 1, '2022-05-19 17:55:07', NULL);
INSERT INTO `sys_internationalization` VALUES (41, 'scm.system.SysInternationalizationCodeAlreadyExist', '该配置编码已存在', 1, '2022-05-25 16:42:37', '2022-05-25 16:45:51');
INSERT INTO `sys_internationalization` VALUES (42, 'scm.system.title', '供应链协同系统', 1, '2022-10-28 14:28:48', NULL);
INSERT INTO `sys_internationalization` VALUES (43, 'scm.system.little_title', '协同', 1, '2022-10-28 14:29:11', NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `request_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作IP',
  `type` int(0) NULL DEFAULT NULL COMMENT '操作类型 1 操作记录2异常记录',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作人',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作描述',
  `action_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方法',
  `action_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求参数',
  `ua` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '浏览器',
  `class_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类路径',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方法',
  `operate_type` int(0) NULL DEFAULT NULL COMMENT '操作类型',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '开始时间',
  `finish_time` timestamp(0) NULL DEFAULT NULL COMMENT '完成时间',
  `consuming_time` bigint(0) NULL DEFAULT NULL COMMENT '消耗时间',
  `ex_desc` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '异常详情信息',
  `ex_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '异常描述',
  `tenant_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_type`(`type`) USING BTREE COMMENT '日志类型'
) ENGINE = InnoDB AUTO_INCREMENT = 471425 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

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
  `access_token_validity` int(0) NULL DEFAULT NULL,
  `refresh_token_validity` int(0) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自动放行',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('mc', NULL, '123456', 'server', 'password,authorization_code,client_credentials,refresh_token', 'https://www.haylion.com', NULL, 1728000, 1728000, NULL, 'false');

-- ----------------------------
-- Table structure for user_role_t
-- ----------------------------
DROP TABLE IF EXISTS `user_role_t`;
CREATE TABLE `user_role_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联表ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_t
-- ----------------------------
INSERT INTO `user_role_t` VALUES (1, 1, 1);
INSERT INTO `user_role_t` VALUES (2, 2, 1);
INSERT INTO `user_role_t` VALUES (3, 3, 1);
INSERT INTO `user_role_t` VALUES (100, 36, 1);
INSERT INTO `user_role_t` VALUES (101, 37, 3);
INSERT INTO `user_role_t` VALUES (103, 38, 2);

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '员工信息表ID',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `mobile` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `card` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `head_icon_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '二维码',
  `c_id` int(0) NULL DEFAULT NULL COMMENT '公司ID',
  `d_id` int(0) NULL DEFAULT NULL COMMENT '部门ID',
  `p_id` int(0) NULL DEFAULT NULL COMMENT '职位ID',
  `login_permission` int(0) NULL DEFAULT 0 COMMENT 'loginPermission',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `state` int(0) NULL DEFAULT 0 COMMENT '用户帐号状态 0待审核，1正常，2冻结状态',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password_modified` int(0) NULL DEFAULT 0 COMMENT '是否修改密码0：否 1：是',
  `message_state` int(0) NULL DEFAULT 1 COMMENT '是否开启短信提醒(0:否,1:是)',
  `remark` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'for_rail_car',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES (1, '系统管理员', 'liyu', '15626250969', 'qyyy@petalmail.con', '610435199605065678', 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 6, 11, 171, 14, '$2a$10$VEWTaxrvK/TwxTSfK72e9OICkEGNQGbgtkqlJJfrHpjN8M0CSYKk6', 1, '2022-04-11 17:22:56', 'anonymousUser', '2022-09-30 14:18:38', 'a17666111890', 1, 1, NULL, 0);
INSERT INTO `user_t` VALUES (2, 'APP管理员', 'wjm', '18391041261', NULL, NULL, 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 6, 11, 172, 14, '$2a$10$HuLJl9Nn9I2bSiNJCI3WwudHIoKF520yGukVmVPcD9hP0PBUtys5K', 1, '2022-04-14 14:39:14', 'anonymousUser', '2022-09-30 14:17:50', 'a17666111890', 1, 0, NULL, 0);
INSERT INTO `user_t` VALUES (3, '马广良', 'a17666111890', '17666111890', NULL, NULL, 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 6, 11, 171, 14, '$2a$10$QNSlEwxMnISuT/xUVQWYue/CD550uPbudtnVqF/6yUOrjLcueoeGu', 1, '2022-04-29 16:57:10', 'liyu', '2022-09-30 16:00:32', 'a17666111890', 0, 1, NULL, 0);
INSERT INTO `user_t` VALUES (36, '用户1', 'yonghu1', '18888888888', NULL, NULL, 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 6, 11, 171, 14, '$2a$10$fPbevzR3YuOp6Gpa1xXlFuR2FbHKp9FVbVdbBLfWsUu4qFLD7/gUO', 1, '2022-04-29 16:57:10', NULL, '2022-04-29 16:57:10', NULL, 0, 1, NULL, 0);
INSERT INTO `user_t` VALUES (37, '22', 'a18688934465', '18688934465', NULL, NULL, 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 7, 12, 173, 4, '$2a$10$L5I56.mvFG5EnnrT9lxtZ.SGZpiDFPeVqs3cX1NujoDYNruMTijCK', 1, '2022-10-18 15:41:20', 'a17666111890', '2022-10-19 10:09:12', 'a17666111890', 0, 1, NULL, 0);
INSERT INTO `user_t` VALUES (38, 'mgl', 'a18123799560', '18123799560', NULL, NULL, 'http://health-stagecoach-pro.oss-cn-hangzhou.aliyuncs.com/file/2022/07/12/1657615110833-default_icon.png', 6, 11, 172, 14, '$2a$10$K76wlO7giZqN1D7x386G4uVbGHjibLBxzCmT/HFNVTj7rvgCl4iVa', 1, '2022-10-18 18:42:33', 'a17666111890', '2022-10-31 15:54:03', 'a17666111890', 0, 1, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
