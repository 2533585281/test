/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/08/2022 17:19:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cardtype
-- ----------------------------
DROP TABLE IF EXISTS `cardtype`;
CREATE TABLE `cardtype`  (
  `cardTypeId` int NOT NULL COMMENT '卡类型id',
  `cardTypeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡类型名称',
  `cardTypeProperty` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡类型属性',
  `cardTypePId` int NULL DEFAULT NULL COMMENT '卡类型父id',
  PRIMARY KEY (`cardTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cardtype
-- ----------------------------
INSERT INTO `cardtype` VALUES (1, '怪兽卡', '', NULL);
INSERT INTO `cardtype` VALUES (2, '魔法卡', NULL, NULL);
INSERT INTO `cardtype` VALUES (3, '陷阱卡', NULL, NULL);
INSERT INTO `cardtype` VALUES (4, '怪兽卡', '通常', 1);
INSERT INTO `cardtype` VALUES (5, '怪兽卡', '效果', 1);
INSERT INTO `cardtype` VALUES (6, '怪兽卡', '翻转', 1);
INSERT INTO `cardtype` VALUES (7, '魔法卡', '永续', 2);
INSERT INTO `cardtype` VALUES (8, '魔法卡', '通常', 2);
INSERT INTO `cardtype` VALUES (9, '魔法卡', '场地', 2);
INSERT INTO `cardtype` VALUES (10, '魔法卡', '速攻', 2);
INSERT INTO `cardtype` VALUES (11, '陷阱卡', '通常', 3);
INSERT INTO `cardtype` VALUES (12, '陷阱卡', '反击', 3);
INSERT INTO `cardtype` VALUES (13, '陷阱卡', '永续', 3);

-- ----------------------------
-- Table structure for cron
-- ----------------------------
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron`  (
  `cron_id` int NOT NULL,
  `cron` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cron_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cron
-- ----------------------------
INSERT INTO `cron` VALUES (1, '0 0 12 * * ?');

-- ----------------------------
-- Table structure for magiccards
-- ----------------------------
DROP TABLE IF EXISTS `magiccards`;
CREATE TABLE `magiccards`  (
  `McardId` int NOT NULL COMMENT '魔法卡id',
  `McardName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '魔法卡名称',
  `McardDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '魔法卡描述',
  `McardRarity` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '魔法卡稀有度',
  `cardTypeId` int NULL DEFAULT NULL COMMENT '卡片类型id',
  `McardResult` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片效果',
  `McardImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片图片',
  PRIMARY KEY (`McardId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of magiccards
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `text` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径',
  `parentId` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '这里是根节点，最大的父亲', '', '0');
INSERT INTO `menu` VALUES ('2', '权限管理', '根节点的第一个儿子', '', '1');
INSERT INTO `menu` VALUES ('3', '密码修改', '根节点第一个孙子', '', '2');
INSERT INTO `menu` VALUES ('4', '系统监控', '根节点的第二个儿子', '', '1');
INSERT INTO `menu` VALUES ('5', '在线用户', '根节点第二个孙子', '', '4');
INSERT INTO `menu` VALUES ('6', '订阅区', '根节点的第三个儿子', '', '1');
INSERT INTO `menu` VALUES ('7', '未知领域', '根节点的第四个儿子', '', '1');
INSERT INTO `menu` VALUES ('8', '新加用户', '密码修改的儿子', '', '3');
INSERT INTO `menu` VALUES ('9', '修改用户', '新加用户的儿子', '', '8');

-- ----------------------------
-- Table structure for monstercardsshogimon
-- ----------------------------
DROP TABLE IF EXISTS `monstercardsshogimon`;
CREATE TABLE `monstercardsshogimon`  (
  `cardId` int NOT NULL COMMENT '卡片id',
  `cardName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片名',
  `cardRace` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片种族',
  `cardProperty` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片属性',
  `cardATK` int NULL DEFAULT NULL COMMENT '卡片攻击',
  `cardDEF` int NULL DEFAULT NULL COMMENT '卡片防御',
  `cardDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片描述',
  `cardStar` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片星级',
  `cardRarity` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片稀有度',
  `cardTypeId` int NULL DEFAULT NULL COMMENT '卡片类型id',
  `cardResult` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片效果',
  `cardImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片图片',
  PRIMARY KEY (`cardId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monstercardsshogimon
-- ----------------------------

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `pId` int NOT NULL COMMENT '人员ID',
  `pName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '人员名称',
  `pAge` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '人员年龄',
  `pPhone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '人员联系方式',
  PRIMARY KEY (`pId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '王某', '18', '18239413094');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sage` int NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'wang', 20, '男', '182');
INSERT INTO `student` VALUES (2, '大张', 21, '女', '123456');
INSERT INTO `student` VALUES (3, ' 王同学', 22, '男', '12345678910');
INSERT INTO `student` VALUES (4, '彭同学', 21, '男', '45679813155');
INSERT INTO `student` VALUES (5, '秦同学', 22, '男', '32165498745');
INSERT INTO `student` VALUES (7, 'test', 123, '男', '123');
INSERT INTO `student` VALUES (11, 'test8', 20, '男', 'test8');
INSERT INTO `student` VALUES (12, 'test9', 20, '男', 'test9');
INSERT INTO `student` VALUES (13, 'test10', 20, '男', 'test10');
INSERT INTO `student` VALUES (14, 'test11', 20, '男', 'test11');
INSERT INTO `student` VALUES (15, 'test12', 20, '男', 'test12');

-- ----------------------------
-- Table structure for trapcard
-- ----------------------------
DROP TABLE IF EXISTS `trapcard`;
CREATE TABLE `trapcard`  (
  `XcardId` int NOT NULL COMMENT '陷阱卡id',
  `XcardName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '陷阱卡名称',
  `XcardDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '陷阱卡描述',
  `XcardRarity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '陷阱卡稀有度',
  `cardTypeId` int NULL DEFAULT NULL COMMENT '卡片类型id',
  `XcardResult` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片效果',
  `XcardImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卡片图片',
  PRIMARY KEY (`XcardId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trapcard
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
