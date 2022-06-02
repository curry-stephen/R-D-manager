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

 Date: 06/05/2022 13:05:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drugmatter
-- ----------------------------
DROP TABLE IF EXISTS `drugmatter`;
CREATE TABLE `drugmatter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '图片',
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `matternum` int(11) NULL DEFAULT NULL COMMENT '问题数量',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `ctime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作时间',
  `miaos` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`, `drugname`) USING BTREE,
  INDEX `药品名称`(`drugname`) USING BTREE,
  INDEX `图片`(`img`) USING BTREE,
  CONSTRAINT `图片` FOREIGN KEY (`img`) REFERENCES `drug` (`tupian`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `药品名称` FOREIGN KEY (`drugname`) REFERENCES `drug` (`drugname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of drugmatter
-- ----------------------------
INSERT INTO `drugmatter` VALUES (3, 'http://124.222.131.59:8090/files/六味地黄丸.webp', '六味地黄丸', 10, 23.50, '2022年03月30日 10时34分11秒', '药品过期');
INSERT INTO `drugmatter` VALUES (4, 'http://124.222.131.59:8090/files/布林佐胺滴眼液.webp', '布林佐胺溴莫尼定滴眼液', 5, 66.00, '2022年03月30日 10时45分31秒', '溶液澄清度不达标');
INSERT INTO `drugmatter` VALUES (5, 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp', '格卡瑞韦哌仑他韦片', 4, 430.00, '2022年03月30日 10时50分20秒', '装量差异');
INSERT INTO `drugmatter` VALUES (6, 'http://124.222.131.59:8090/files/注射用卡瑞利珠单抗.jpg', '注射用卡瑞利珠单抗', 6, 2928.00, '2022年03月30日 10时52分08秒', '装量差异');
INSERT INTO `drugmatter` VALUES (7, 'http://124.222.131.59:8090/files/炔雌醇环丙孕酮片.png', '炔雌醇环丙孕酮片', 2, 45.00, '2022年03月30日 10时53分03秒', '装量差异');
INSERT INTO `drugmatter` VALUES (8, 'http://124.222.131.59:8090/files/盐酸莫西沙星氯化钠注射液.webp', '盐酸莫西沙星氯化钠注射液', 9, 316.00, '2022年03月30日 10时55分31秒', '溶液澄清度不达标');
INSERT INTO `drugmatter` VALUES (9, 'http://124.222.131.59:8090/files/盐酸莫西沙星片.webp', '盐酸莫西沙星片', 3, 80.00, '2022年03月30日 10时56分10秒', '装量差异');
INSERT INTO `drugmatter` VALUES (10, 'http://124.222.131.59:8090/files/硝苯地平控释片.webp', '硝苯地平控释片', 5, 35.00, '2022年03月30日 10时58分52秒', '装量差异');
INSERT INTO `drugmatter` VALUES (11, 'http://124.222.131.59:8090/files/维生素AD软胶囊.webp', '维生素AD软胶囊', 11, 93.00, '2022年03月30日 10时59分27秒', '装量差异');
INSERT INTO `drugmatter` VALUES (12, 'http://124.222.131.59:8090/files/肽杞口服液.jpg', '肽杞口服液', 14, 222.00, '2022年03月30日 11时00分46秒', '溶液澄清度不达标');
INSERT INTO `drugmatter` VALUES (13, 'http://124.222.131.59:8090/files/茚达特罗格隆溴铵吸入粉雾剂用胶囊.jpg', '茚达特罗格隆溴铵吸入粉雾剂用胶囊', 7, 238.00, '2022年03月30日 11时01分47秒', '装量差异');
INSERT INTO `drugmatter` VALUES (14, 'http://124.222.131.59:8090/files/蛇脂参黄软膏.webp', '蛇脂参黄软膏', 3, 30.00, '2022年03月30日 11时03分44秒', '装量差异');

SET FOREIGN_KEY_CHECKS = 1;
