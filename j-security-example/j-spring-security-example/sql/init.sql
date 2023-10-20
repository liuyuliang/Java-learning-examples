/*用户角色映射表*/
CREATE TABLE `sys_user_role`  (
                                  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                  `user_id` bigint(200) NOT NULL COMMENT '用户id',
                                  `role_id` bigint(200) NOT NULL DEFAULT 0 COMMENT '角色id',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*用户表*/
CREATE TABLE `sys_user`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '用户名',
                             `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '昵称',
                             `phone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '电话',
                             `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '密码',
                             `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

/*角色菜单映射表*/
CREATE TABLE `sys_role_menu`  (
                                  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                  `role_id` bigint(200) NOT NULL COMMENT '角色ID',
                                  `menu_id` bigint(200) NOT NULL DEFAULT 0 COMMENT '菜单id',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*角色表*/
CREATE TABLE `sys_role`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `role_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

/*菜单表*/
CREATE TABLE `sys_menu`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                             `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
                             `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;
/*新建一条用户数据：账号：test 密码：123456*/
INSERT INTO `springsecurity`.`sys_user`(`user_name`, `nick_name`, `password`, `phone`, `status`) VALUES ('test', '1', '$2a$12$pgFnH5Ot.XIvbaTM7X9nNe8AGwBV.3eggszusKShXXG2HJ1fFdNMO', '13662301000', '0');

