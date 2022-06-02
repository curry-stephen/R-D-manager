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

 Date: 06/05/2022 13:05:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tupian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `drugname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `suppliername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '供应商',
  `producttime` date NULL DEFAULT NULL COMMENT '生产日期',
  `warrenty` int(255) NULL DEFAULT NULL COMMENT '保质期',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` double(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `stock` int(255) NULL DEFAULT NULL COMMENT '库存',
  `guo` tinyint(255) NULL DEFAULT NULL COMMENT '是否过期',
  `guotime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`, `drugname`, `price`, `suppliername`) USING BTREE,
  INDEX `drugname`(`drugname`) USING BTREE,
  INDEX `tupian`(`tupian`) USING BTREE,
  INDEX `suppliername`(`suppliername`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of druginfo
-- ----------------------------
INSERT INTO `druginfo` VALUES (12, 'http://124.222.131.59:8090/files/盐酸莫西沙星氯化钠注射液.webp', '盐酸莫西沙星氯化钠注射液', '北京美康永正医药有限公司', '2021-10-31', 24, '2394v', 316.00, 200, 1, '剩余保质期 19月25日');
INSERT INTO `druginfo` VALUES (13, 'http://124.222.131.59:8090/files/阿卡波糖片.webp', '阿卡波糖片', '北京美康永正医药有限公司', '2021-10-30', 24, '4tbbf', 241.00, 1350, 1, '剩余保质期 19月26日');
INSERT INTO `druginfo` VALUES (14, 'http://124.222.131.59:8090/files/硝苯地平控释片.webp', '硝苯地平控释片', '北京美康永正医药有限公司', '2021-10-31', 24, '4y5hv', 35.00, 324, 1, '剩余保质期 19月25日');
INSERT INTO `druginfo` VALUES (15, 'http://124.222.131.59:8090/files/盐酸莫西沙星片.webp', '盐酸莫西沙星片', '北京美康永正医药有限公司', '2021-11-11', 24, 'ereb', 80.00, 540, 1, '剩余保质期 19月14日');
INSERT INTO `druginfo` VALUES (16, 'http://124.222.131.59:8090/files/钆喷酸葡胺注射液.webp', '钆喷酸葡胺注射液', '北京美康永正医药有限公司', '2021-11-20', 24, 'wwegb', 159.00, 240, 1, '剩余保质期 19月5日');
INSERT INTO `druginfo` VALUES (17, 'http://124.222.131.59:8090/files/炔雌醇环丙孕酮片.png', '炔雌醇环丙孕酮片', '国药控股天津有限公司', '2021-11-15', 24, '352gv', 45.00, 100, 1, '剩余保质期 19月10日');
INSERT INTO `druginfo` VALUES (18, 'http://124.222.131.59:8090/files/鼻咽清毒颗粒.webp', '鼻咽清毒颗粒', '国药控股天津有限公司', '2021-11-03', 24, '2gsb', 26.00, 145, 1, '剩余保质期 19月22日');
INSERT INTO `druginfo` VALUES (19, 'http://124.222.131.59:8090/files/布林佐胺滴眼液.webp', '布林佐胺溴莫尼定滴眼液', '嘉事堂药业股份有限公司', '2021-10-14', 24, '35vgv', 66.00, 310, 1, '剩余保质期 18月11日');
INSERT INTO `druginfo` VALUES (20, 'http://124.222.131.59:8090/files/维生素AD软胶囊.webp', '维生素AD软胶囊', '嘉事堂药业股份有限公司', '2021-09-02', 24, '34gs', 93.00, 124, 1, '剩余保质期 17月22日');
INSERT INTO `druginfo` VALUES (21, 'http://124.222.131.59:8090/files/格卡瑞韦哌仑他韦片.webp', '格卡瑞韦哌仑他韦片', '上药康德乐（北京）医药有限公司', '2021-09-18', 24, '43hb', 430.00, 326, 1, '剩余保质期 17月6日');
INSERT INTO `druginfo` VALUES (22, 'http://124.222.131.59:8090/files/蛇脂参黄软膏.webp', '蛇脂参黄软膏', '上药康德乐（北京）医药有限公司', '2021-11-10', 24, '34sb', 30.00, 110, 1, '剩余保质期 19月15日');
INSERT INTO `druginfo` VALUES (23, 'http://124.222.131.59:8090/files/注射用卡瑞利珠单抗.jpg', '注射用卡瑞利珠单抗', '上药康德乐（北京）医药有限公司', '2021-10-14', 24, '45h3', 2928.00, 233, 1, '剩余保质期 18月11日');
INSERT INTO `druginfo` VALUES (24, 'http://124.222.131.59:8090/files/达可替尼片.jpg', '达可替尼片', '华润医药商业集团有限公司', '2021-10-23', 24, '35hg', 123.00, 273, 1, '剩余保质期 18月2日');
INSERT INTO `druginfo` VALUES (25, 'http://124.222.131.59:8090/files/肽杞口服液.jpg', '肽杞口服液', '华润医药商业集团有限公司', '2021-11-06', 24, '35hd', 222.00, 139, 1, '剩余保质期 19月19日');
INSERT INTO `druginfo` VALUES (26, 'http://124.222.131.59:8090/files/茚达特罗格隆溴铵吸入粉雾剂用胶囊.jpg', '茚达特罗格隆溴铵吸入粉雾剂用胶囊', '青岛丰源堂医药连锁有限公司.', '2021-11-12', 24, '64hn', 238.00, 328, 1, '剩余保质期 19月13日');
INSERT INTO `druginfo` VALUES (27, 'http://124.222.131.59:8090/files/云南白药.jpeg', '云南白药', '青岛丰源堂医药连锁有限公司.', '2021-12-18', 24, '89fg', 30.00, 270, 1, '剩余保质期 20月8日');
INSERT INTO `druginfo` VALUES (29, 'http://124.222.131.59:8090/files/999感冒灵.webp', '999感冒灵', '国药控股天津有限公司', '2022-01-01', 24, '478kn', 24.00, 99, 1, '剩余保质期 21月25日');
INSERT INTO `druginfo` VALUES (30, 'http://124.222.131.59:8090/files/六味地黄丸.webp', '六味地黄丸', '北京美康永正医药有限公司', '2022-01-17', 24, '29rb', 30.00, 400, 1, '剩余保质期 21月9日');
INSERT INTO `druginfo` VALUES (31, 'http://124.222.131.59:8090/files/创可贴.webp', '创可贴', '上药康德乐（北京）医药有限公司', '2021-12-21', 24, '20on', 15.00, 124, 1, '剩余保质期 20月5日');

SET FOREIGN_KEY_CHECKS = 1;
