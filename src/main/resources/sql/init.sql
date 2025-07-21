/*
 Navicat Premium Data Transfer

 Source Server         : 9000x-wsl
 Source Server Type    : MySQL
 Source Server Version : 80042
 Source Host           : 172.23.141.84:3306
 Source Schema         : order_db

 Target Server Type    : MySQL
 Target Server Version : 80042
 File Encoding         : 65001

 Date: 20/07/2025 20:59:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1`  (
  `order_id` bigint NOT NULL COMMENT '订单id',
  `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
  `user_id` bigint NOT NULL COMMENT '下单用户id',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_order_2
-- ----------------------------
DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2`  (
  `order_id` bigint NOT NULL COMMENT '订单id',
  `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
  `user_id` bigint NOT NULL COMMENT '下单用户id',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `student_id` bigint NOT NULL AUTO_INCREMENT,
  `student_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `del_flag` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
