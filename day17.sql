/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : day17

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 30/07/2019 11:10:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '男', 13, '陕西', '12345', 'zhangsan@itcast.cn', '张三', '123');
INSERT INTO `user` VALUES (2, '李四', '女', 15, '北京', '88888', 'ls@itcast.cn', '李四', '1234');
INSERT INTO `user` VALUES (11, '王五', '女', 15, '陕西', '123456', 'wangwu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (12, '王三', '男', 34, '安徽', '123456', 'wangsan@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (13, '王四', '男', 34, '安徽', '123456', 'wangsi@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (14, '王六', '女', 20, '北京', '123456', 'wangliu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (15, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (16, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (17, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (18, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (19, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (20, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (24, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (25, '王五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (27, '王五', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (28, '赵四', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (29, '朱九', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (30, '刘六', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (31, '李八', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (32, '王五', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (33, '赵四', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (34, '朱九', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (35, '刘六', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (36, '李八', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (37, '王五', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (38, '赵四', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (39, '朱九', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (40, '刘六', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (41, '李八', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (42, '王五', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (43, '赵四', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (44, '朱九', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (45, '刘六', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (46, '李八', '女', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (47, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (48, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (49, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (50, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (51, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (52, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (53, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (54, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (55, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (56, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (57, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (58, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (59, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (60, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (61, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (62, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (63, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (64, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (65, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (66, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (67, '赵五', '男', 34, '北京', '123456', 'zhaowu@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (68, '李五', '女', 34, '北京', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (69, '孙五', '男', 34, '安徽', '123456', '123456@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (70, '吴五', '女', 34, '陕西', '123456', '123456@qq.com', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
