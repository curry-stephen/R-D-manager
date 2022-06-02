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

 Date: 06/05/2022 13:06:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for returnsupplier
-- ----------------------------
DROP TABLE IF EXISTS `returnsupplier`;
CREATE TABLE `returnsupplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `createtime` date NULL DEFAULT NULL COMMENT '退货时间',
  `pay` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `drugname`(`drugname`) USING BTREE,
  INDEX `tupian`(`tupian`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of returnsupplier
-- ----------------------------
INSERT INTO `returnsupplier` VALUES (5, 1, 'http://124.222.131.59:8090/files/999感冒灵.webp', '999感冒灵', '购买错误', '2022-03-30', '货到付款');
INSERT INTO `returnsupplier` VALUES (6, 39, 'http://124.222.131.59:8090/files/创可贴.webp', '创可贴', '购买数量多了', '2022-03-30', '微信支付');
INSERT INTO `returnsupplier` VALUES (7, 50, 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp', '鼻咽清毒颗粒', '暂时不需要', '2022-03-30', '微信支付');
INSERT INTO `returnsupplier` VALUES (8, 9, 'http://124.222.131.59:8090/files/茚达特罗格隆溴铵吸入粉雾剂用胶囊.jpg', '茚达特罗格隆溴铵吸入粉雾剂用胶囊', '库存超额', '2022-03-30', '支付宝支付');
INSERT INTO `returnsupplier` VALUES (9, 80, 'http://124.222.131.59:8090/files/炔雌醇环丙孕酮片.png', '炔雌醇环丙孕酮片', '购买数量过多', '2022-03-30', '微信支付');
INSERT INTO `returnsupplier` VALUES (10, 45, 'http://124.222.131.59:8090/files/肽杞口服液.jpg', '肽杞口服液', '购买数量过多', '2022-03-30', '支付宝支付');

SET FOREIGN_KEY_CHECKS = 1;
