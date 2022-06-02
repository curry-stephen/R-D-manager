/*
 Navicat Premium Data Transfer

 Source Server         : drugmaper
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 124.222.131.59:3306
 Source Schema         : drugmaper

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 06/05/2022 13:06:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `createtime` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `name`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (7, '北京美康永正医药有限公司', NULL, '2022-03-28');
INSERT INTO `supplier` VALUES (8, '国药控股天津有限公司', NULL, '2022-03-28');
INSERT INTO `supplier` VALUES (9, '嘉事堂药业股份有限公司', NULL, '2022-03-28');
INSERT INTO `supplier` VALUES (10, '上药康德乐（北京）医药有限公司', NULL, '2022-03-28');
INSERT INTO `supplier` VALUES (11, '华润医药商业集团有限公司', NULL, '2022-03-28');
INSERT INTO `supplier` VALUES (12, '青岛丰源堂医药连锁有限公司.', NULL, '2022-03-28');

SET FOREIGN_KEY_CHECKS = 1;
