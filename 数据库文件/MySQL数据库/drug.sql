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

 Date: 06/05/2022 13:05:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名',
  `outin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出入库',
  `nums` int(255) NULL DEFAULT NULL COMMENT '数量',
  `druguser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `ctime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `drugname`(`drugname`) USING BTREE,
  INDEX `tupian`(`tupian`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES (5, 'http://124.222.131.59:8090/files/999感冒灵.webp', '999感冒灵', '入库', 99, '马超', '2022年03月28日 21时56分09秒');
INSERT INTO `drug` VALUES (6, 'http://124.222.131.59:8090/files/六味地黄丸.webp', '六味地黄丸', '入库', 400, '马超', '2022年03月28日 21时56分22秒');
INSERT INTO `drug` VALUES (13, 'http://124.222.131.59:8090/files/创可贴.webp', '创口贴', '入库', 124, '马超', '2022年03月28日 21时58分37秒');
INSERT INTO `drug` VALUES (18, 'http://124.222.131.59:8090/files/盐酸莫西沙星氯化钠注射液.webp', '盐酸莫西沙星氯化钠注射液', '入库', 200, '马超', '2022年03月28日 21时59分10秒');
INSERT INTO `drug` VALUES (19, 'http://124.222.131.59:8090/files/阿卡波糖片.webp', '阿卡波糖片', '入库', 1350, '马超', '2022年03月28日 21时59分32秒');
INSERT INTO `drug` VALUES (20, 'http://124.222.131.59:8090/files/硝苯地平控释片.webp', '硝苯地平控释片', '入库', 324, '马超', '2022年03月28日 21时59分48秒');
INSERT INTO `drug` VALUES (21, 'http://124.222.131.59:8090/files/盐酸莫西沙星片.webp', '盐酸莫西沙星片', '入库', 540, '马超', '2022年03月28日 22时00分01秒');
INSERT INTO `drug` VALUES (22, 'http://124.222.131.59:8090/files/钆喷酸葡胺注射液.webp', '钆喷酸葡胺注射液', '入库', 240, '马超', '2022年03月28日 22时00分12秒');
INSERT INTO `drug` VALUES (23, 'http://124.222.131.59:8090/files/碘普罗胺注射液.webp', '碘普罗胺注射液', '入库', 140, '马超', '2022年03月28日 22时00分29秒');
INSERT INTO `drug` VALUES (24, 'http://124.222.131.59:8090/files/炔雌醇环丙孕酮片.png', '炔雌醇环丙孕酮片', '入库', 100, '马超', '2022年03月28日 22时00分41秒');
INSERT INTO `drug` VALUES (25, 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp', '鼻咽清毒颗粒', '入库', 145, '马超', '2022年03月28日 22时09分12秒');
INSERT INTO `drug` VALUES (26, 'http://124.222.131.59:8090/files/布林佐胺滴眼液.webp', '布林佐胺溴莫尼定滴眼液', '入库', 310, '马超', '2022年03月28日 22时09分23秒');
INSERT INTO `drug` VALUES (27, 'http://124.222.131.59:8090/files/维生素AD软胶囊.webp', '维生素AD软胶囊', '入库', 124, '马超', '2022年03月28日 22时09分47秒');
INSERT INTO `drug` VALUES (28, 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp', '格卡瑞韦哌仑他韦片', '入库', 326, '马超', '2022年03月28日 22时09分56秒');
INSERT INTO `drug` VALUES (29, 'http://124.222.131.59:8090/files/蛇脂参黄软膏.webp', '蛇脂参黄软膏', '入库', 110, '马超', '2022年03月28日 22时10分07秒');
INSERT INTO `drug` VALUES (30, 'http://124.222.131.59:8090/files/注射用卡瑞利珠单抗.jpg', '注射用卡瑞利珠单抗', '入库', 233, '马超', '2022年03月28日 22时10分21秒');
INSERT INTO `drug` VALUES (31, 'http://124.222.131.59:8090/files/达可替尼片.jpg', '达可替尼片', '入库', 273, '马超', '2022年03月28日 22时10分28秒');
INSERT INTO `drug` VALUES (32, 'http://124.222.131.59:8090/files/肽杞口服液.jpg', '肽杞口服液', '入库', 139, '马超', '2022年03月28日 22时10分41秒');
INSERT INTO `drug` VALUES (33, 'http://124.222.131.59:8090/files/茚达特罗格隆溴铵吸入粉雾剂用胶囊.jpg', '茚达特罗格隆溴铵吸入粉雾剂用胶囊', '入库', 328, '马超', '2022年03月28日 22时10分51秒');

SET FOREIGN_KEY_CHECKS = 1;
