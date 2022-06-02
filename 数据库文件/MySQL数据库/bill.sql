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

 Date: 06/05/2022 13:05:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编号',
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `count` int(11) NULL DEFAULT NULL COMMENT '药品数量',
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `createtime` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `drugname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (3, '478kn', '999感冒灵', 50, 'http://124.222.131.59:8090/files/999感冒灵.webp', 24.00, '2022-03-30');
INSERT INTO `bill` VALUES (4, '89fg', '云南白药', 170, 'http://124.222.131.59:8090/files/云南白药.jpeg', 30.00, '2022-03-30');
INSERT INTO `bill` VALUES (5, '29rb', '六味地黄丸', 330, 'http://124.222.131.59:8090/files/六味地黄丸.webp', 30.00, '2022-03-30');
INSERT INTO `bill` VALUES (6, '20on', '创可贴', 50, 'http://124.222.131.59:8090/files/创可贴.webp', 15.00, '2022-03-30');
INSERT INTO `bill` VALUES (7, '35vgv', '布林佐胺溴莫尼定滴眼液', 210, 'http://124.222.131.59:8090/files/布林佐胺滴眼液.webp', 66.00, '2022-03-30');
INSERT INTO `bill` VALUES (8, '43hb', '格卡瑞韦哌仑他韦片', 248, 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp', 430.00, '2022-03-30');
INSERT INTO `bill` VALUES (9, '45h3', '注射用卡瑞利珠单抗', 33, 'http://124.222.131.59:8090/files/注射用卡瑞利珠单抗.jpg', 2928.00, '2022-03-30');
INSERT INTO `bill` VALUES (10, '35hd', '肽杞口服液', 89, 'http://124.222.131.59:8090/files/肽杞口服液.jpg', 222.00, '2022-03-30');
INSERT INTO `bill` VALUES (11, '2gsb', '鼻咽清毒颗粒', 128, 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp', 26.00, '2022-03-30');

SET FOREIGN_KEY_CHECKS = 1;
