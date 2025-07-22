/*
 Navicat Premium Data Transfer

 Source Server         : master
 Source Server Type    : MySQL
 Source Server Version : 80042
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 80042
 File Encoding         : 65001

 Date: 22/07/2025 19:34:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order1
-- ----------------------------
DROP TABLE IF EXISTS `t_order1`;
CREATE TABLE `t_order1`  (
                             `order_id` bigint NOT NULL COMMENT '订单id',
                             `price` decimal(10, 2) NOT NULL COMMENT '订单价格',
                             `user_id` bigint NOT NULL COMMENT '下单用户id',
                             `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单状态',
                             PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_order2
-- ----------------------------
DROP TABLE IF EXISTS `t_order2`;
CREATE TABLE `t_order2`  (
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
                              `student_id` bigint NOT NULL,
                              `student_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `del_flag` tinyint NOT NULL DEFAULT 0,
                              PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user_like
-- ----------------------------
DROP TABLE IF EXISTS `t_user_like`;
CREATE TABLE `t_user_like`  (
                                `user_like_id` bigint NOT NULL,
                                `user_id` bigint NULL DEFAULT NULL,
                                `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`user_like_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
