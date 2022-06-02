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

 Date: 06/05/2022 13:06:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `money` double NULL DEFAULT NULL COMMENT '金额',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operatetime` date NULL DEFAULT NULL COMMENT '操作时间',
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`, `drugname`) USING BTREE,
  INDEX `drugname`(`drugname`) USING BTREE,
  INDEX `tupian`(`tupian`) USING BTREE,
  CONSTRAINT `saleinfo_ibfk_1` FOREIGN KEY (`drugname`) REFERENCES `druginfo` (`drugname`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `saleinfo_ibfk_2` FOREIGN KEY (`tupian`) REFERENCES `druginfo` (`tupian`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES (4, '999感冒灵', '478kn', 50, 1200, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/999感冒灵.webp');
INSERT INTO `saleinfo` VALUES (5, '云南白药', '89fg', 170, 5100, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/云南白药.jpeg');
INSERT INTO `saleinfo` VALUES (6, '六味地黄丸', '29rb', 330, 9900, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/六味地黄丸.webp');
INSERT INTO `saleinfo` VALUES (7, '创可贴', '20on', 50, 750, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/创可贴.webp');
INSERT INTO `saleinfo` VALUES (8, '布林佐胺溴莫尼定滴眼液', '35vgv', 210, 13860, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/布林佐胺滴眼液.webp');
INSERT INTO `saleinfo` VALUES (9, '格卡瑞韦哌仑他韦片', '43hb', 248, 106640, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp');
INSERT INTO `saleinfo` VALUES (10, '注射用卡瑞利珠单抗', '45h3', 33, 96624, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/注射用卡瑞利珠单抗.jpg');
INSERT INTO `saleinfo` VALUES (11, '肽杞口服液', '35hd', 89, 19758, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/肽杞口服液.jpg');
INSERT INTO `saleinfo` VALUES (12, '鼻咽清毒颗粒', '2gsb', 128, 3328, '马超', '2022-03-30', 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp');

SET FOREIGN_KEY_CHECKS = 1;
