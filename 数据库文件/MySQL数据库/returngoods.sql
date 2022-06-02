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

 Date: 06/05/2022 13:05:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for returngoods
-- ----------------------------
DROP TABLE IF EXISTS `returngoods`;
CREATE TABLE `returngoods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `count` int(11) NULL DEFAULT NULL COMMENT '退货数量',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `money` double NULL DEFAULT NULL COMMENT '总金额',
  `operatetime` date NULL DEFAULT NULL COMMENT '操作时间',
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`, `drugname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of returngoods
-- ----------------------------
INSERT INTO `returngoods` VALUES (3, '999感冒灵', 20, '购买错误', 480, '2022-03-30', 'http://124.222.131.59:8090/files/999感冒灵.webp');
INSERT INTO `returngoods` VALUES (4, '创可贴', 10, '暂时不需要', 150, '2022-03-30', 'http://124.222.131.59:8090/files/创可贴.webp');
INSERT INTO `returngoods` VALUES (5, '格卡瑞韦哌仑他韦片', 8, '发错货品', 3440, '2022-03-30', 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp');
INSERT INTO `returngoods` VALUES (6, '炔雌醇环丙孕酮片', 7, '商品破损问题', 315, '2022-03-30', 'http://124.222.131.59:8090/files/炔雌醇环丙孕酮片.png');
INSERT INTO `returngoods` VALUES (7, '盐酸莫西沙星片', 13, '图片，产地不符', 1040, '2022-03-30', 'http://124.222.131.59:8090/files/盐酸莫西沙星片.webp');
INSERT INTO `returngoods` VALUES (8, '维生素AD软胶囊', 4, '退运费', 372, '2022-03-30', 'http://124.222.131.59:8090/files/维生素AD软胶囊.webp');
INSERT INTO `returngoods` VALUES (9, '鼻咽清毒颗粒', 5, '未按约定时间发货', 130, '2022-03-30', 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp');
INSERT INTO `returngoods` VALUES (10, '蛇脂参黄软膏', 5, '商品漏发', 130, '2022-03-30', 'http://124.222.131.59:8090/files/蛇脂参黄软膏.webp');

SET FOREIGN_KEY_CHECKS = 1;
