CREATE TABLE `migrations`
(
    `id`        int unsigned                                                  NOT NULL AUTO_INCREMENT,
    `migration` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `admin_permissions`
(
    `id`         int(10) unsigned                        NOT NULL AUTO_INCREMENT,
    `type`       varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '类型[行为:action,数据:data]',
    `group_name` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '分组',
    `sort`       int(11)                                 NOT NULL COMMENT '升序',
    `name`       varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '权限名',
    `slug`       varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'slug',
    `created_at` timestamp                               NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `admin_role_permission`
(
    `role_id` int(11) unsigned NOT NULL DEFAULT '0',
    `perm_id` int(10) unsigned NOT NULL DEFAULT '0',
    KEY `role_id` (`role_id`),
    KEY `perm_id` (`perm_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `admin_roles`
(
    `id`         int(10) unsigned                        NOT NULL AUTO_INCREMENT,
    `name`       varchar(64) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '角色名',
    `slug`       varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'slug',
    `created_at` timestamp                               NULL     DEFAULT NULL,
    `updated_at` timestamp                               NULL     DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `slug` (`slug`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `admin_user_role`
(
    `admin_id` int(11) unsigned NOT NULL DEFAULT '0',
    `role_id`  int(10) unsigned NOT NULL DEFAULT '0',
    KEY `admin_id` (`admin_id`),
    KEY `role_id` (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `admin_users`
(
    `id`           int(10) unsigned                        NOT NULL AUTO_INCREMENT,
    `name`         varchar(16) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '姓名',
    `email`        varchar(32) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '邮箱',
    `password`     varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `salt`         varchar(10) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT 'Salt',
    `login_ip`     varchar(15) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '登录IP',
    `login_at`     timestamp                               NULL     DEFAULT NULL COMMENT '登录时间',
    `is_ban_login` tinyint(4)                              NOT NULL DEFAULT '0' COMMENT '1禁止登录,0否',
    `login_times`  int(11)                                 NOT NULL DEFAULT '0' COMMENT '登录次数',
    `created_at`   timestamp                               NULL     DEFAULT NULL,
    `updated_at`   timestamp                               NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `administrators_email_unique` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `app_config`
(
    `id`           bigint(20) unsigned                     NOT NULL AUTO_INCREMENT,
    `group_name`   varchar(24) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '分组',
    `name`         varchar(24) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '名称',
    `sort`         int(11)                                 NOT NULL DEFAULT '0' COMMENT '升序',
    `field_type`   varchar(24) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '字段类型',
    `key_name`     varchar(188) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '键',
    `key_value`    longtext COLLATE utf8mb4_unicode_ci COMMENT '值',
    `option_value` text COLLATE utf8mb4_unicode_ci COMMENT '可选值',
    `is_private`   tinyint(4)                              NOT NULL DEFAULT '0' COMMENT '是否私密信息',
    `help`         varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '帮助信息',
    `created_at`   timestamp                               NULL     DEFAULT NULL,
    `is_hidden`    tinyint(4)                              NOT NULL DEFAULT '0' COMMENT '1显示,0否',
    PRIMARY KEY (`id`),
    UNIQUE KEY `app_config_key_unique` (`key_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `course_chapters`
(
    `id`         int(11) unsigned NOT NULL AUTO_INCREMENT,
    `course_id`  int(11)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `name`       varchar(64)      NOT NULL DEFAULT '' COMMENT '章节名',
    `sort`       int(11)          NOT NULL DEFAULT '0' COMMENT '升序',
    `created_at` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp        NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `course_department`
(
    `course_id` int(11) NOT NULL DEFAULT '0',
    `dep_id`    int(11) NOT NULL DEFAULT '0',
    KEY `course_id` (`course_id`),
    KEY `dep_id` (`dep_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `course_hour`
(
    `id`         int(11) unsigned NOT NULL AUTO_INCREMENT,
    `course_id`  int(11)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `chapter_id` int(11)          NOT NULL DEFAULT '0' COMMENT '章节ID',
    `sort`       int(11)          NOT NULL DEFAULT '0' COMMENT '升序',
    `title`      varchar(255)     NOT NULL DEFAULT '' COMMENT '课时名',
    `type`       varchar(20)      NOT NULL DEFAULT '' COMMENT '课时类型',
    `rid`        int(11)          NOT NULL DEFAULT '0' COMMENT '资源id',
    `duration`   int(11)          NOT NULL COMMENT '时长[s]',
    `created_at` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `courses`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
    `title`       varchar(255)     NOT NULL DEFAULT '' COMMENT '课程标题',
    `thumb`       varchar(255)     NOT NULL DEFAULT '' COMMENT '课程封面',
    `charge`      int(11)          NOT NULL DEFAULT '0' COMMENT '课程价格(分)',
    `short_desc`  varchar(255)     NOT NULL DEFAULT '' COMMENT '简介',
    `class_hour`  int(11)          NOT NULL DEFAULT '0' COMMENT '课时数',
    `is_show`     tinyint(4)       NOT NULL DEFAULT '0' COMMENT '显示[1:是,0:否]',
    `is_required` tinyint(4)       NOT NULL DEFAULT '0' COMMENT '1:必修,0:选修',
    `created_at`  timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  timestamp        NULL     DEFAULT NULL,
    `deleted_at`  timestamp        NULL     DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `departments`
(
    `id`           int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name`         varchar(64)      NOT NULL DEFAULT '' COMMENT '部门名',
    `parent_id`    int(11)          NOT NULL COMMENT '父id',
    `parent_chain` varchar(255)     NOT NULL DEFAULT '' COMMENT '父链',
    `sort`         int(11)          NOT NULL DEFAULT '0' COMMENT '升序',
    `created_at`   timestamp        NULL     DEFAULT NULL,
    `updated_at`   timestamp        NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `resource_categories`
(
    `id`           int(11) unsigned NOT NULL AUTO_INCREMENT,
    `parent_id`    int(11)          NOT NULL DEFAULT '0',
    `parent_chain` varchar(2550)    NOT NULL DEFAULT '',
    `name`         varchar(64)      NOT NULL DEFAULT '' COMMENT '分类名',
    `sort`         int(11)          NOT NULL COMMENT '升序',
    `created_at`   timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`   timestamp        NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode

CREATE TABLE `resource_category` (
                                     `cid` int(11) NOT NULL DEFAULT '0',
                                     `rid` int(11) NOT NULL,
                                     KEY `cid` (`cid`),
                                     KEY `rid` (`rid`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `resource_course_category` (
                                            `course_id` int(11) NOT NULL DEFAULT '0',
                                            `category_id` int(11) NOT NULL DEFAULT '0',
                                            KEY `course_id` (`course_id`),
                                            KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `resource_videos` (
                                   `rid` int(11) unsigned NOT NULL,
                                   `poster` varchar(255) NOT NULL DEFAULT '' COMMENT '封面',
                                   `duration` int(10) unsigned NOT NULL COMMENT '视频时长[s]',
                                   `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   UNIQUE KEY `rid` (`rid`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `resources` (
                             `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                             `admin_id` int(11) NOT NULL DEFAULT '0',
                             `type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '类型',
                             `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '资源名',
                             `extension` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文件类型',
                             `size` bigint(20) DEFAULT '0' COMMENT '大小[字节]',
                             `disk` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '存储磁盘',
                             `file_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文件id',
                             `path` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '相对地址',
                             `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'URL地址',
                             `created_at` timestamp NULL DEFAULT NULL,
                             `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属素材',
                             `is_hidden` tinyint(4) NOT NULL DEFAULT '0' COMMENT '隐藏[0:否,1:是]',
                             PRIMARY KEY (`id`),
                             KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_course_hour_records` (
                                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                            `user_id` int(11) NOT NULL DEFAULT '0',
                                            `course_id` int(11) NOT NULL DEFAULT '0',
                                            `hour_id` int(11) NOT NULL DEFAULT '0',
                                            `total_duration` int(11) NOT NULL DEFAULT '0' COMMENT '总时长',
                                            `finished_duration` int(11) NOT NULL DEFAULT '0' COMMENT '已完成时长',
                                            `real_duration` int(11) NOT NULL DEFAULT '0' COMMENT '实际观看时长',
                                            `is_finished` tinyint(4) DEFAULT NULL COMMENT '是否看完[1:是,0:否]',
                                            `finished_at` timestamp NULL DEFAULT NULL COMMENT '看完时间',
                                            `created_at` timestamp NULL DEFAULT NULL,
                                            `updated_at` timestamp NULL DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            KEY `u_h_c_id` (`user_id`,`hour_id`,`course_id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_course_records` (
                                       `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                       `user_id` int(11) NOT NULL DEFAULT '0',
                                       `course_id` int(11) NOT NULL DEFAULT '0',
                                       `hour_count` int(11) NOT NULL DEFAULT '0' COMMENT '课时数量',
                                       `finished_count` int(11) NOT NULL DEFAULT '0' COMMENT '已完成课时数',
                                       `progress` int(11) NOT NULL DEFAULT '0' COMMENT '进度',
                                       `is_finished` tinyint(4) NOT NULL DEFAULT '0' COMMENT '看完[1:是,0:否]',
                                       `finished_at` timestamp NULL DEFAULT NULL COMMENT '看完时间',
                                       `created_at` timestamp NULL DEFAULT NULL,
                                       `updated_at` timestamp NULL DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_department` (
                                   `user_id` int(11) unsigned NOT NULL DEFAULT '0',
                                   `dep_id` int(11) unsigned NOT NULL DEFAULT '0',
                                   KEY `user_id` (`user_id`),
                                   KEY `dep_id` (`dep_id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_learn_duration_records` (
                                               `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                               `user_id` int(11) NOT NULL DEFAULT '0',
                                               `created_date` date NOT NULL,
                                               `duration` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '已学习时长[微秒]',
                                               `start_at` timestamp NULL DEFAULT NULL COMMENT '开始时间',
                                               `end_at` timestamp NULL DEFAULT NULL COMMENT '结束时间',
                                               `course_id` int(11) NOT NULL DEFAULT '0',
                                               `hour_id` int(11) NOT NULL DEFAULT '0',
                                               PRIMARY KEY (`id`),
                                               KEY `u_d` (`user_id`,`created_date`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_learn_duration_stats` (
                                             `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                             `user_id` int(11) NOT NULL DEFAULT '0',
                                             `duration` bigint(20) NOT NULL DEFAULT '0',
                                             `created_date` date NOT NULL,
                                             PRIMARY KEY (`id`),
                                             KEY `u_d` (`user_id`,`created_date`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_login_records` (
                                      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                      `user_id` int(11) NOT NULL,
                                      `jti` varchar(64) NOT NULL DEFAULT '' COMMENT 'JTI',
                                      `ip` varchar(15) NOT NULL DEFAULT '' COMMENT '登录ip',
                                      `ip_area` varchar(64) NOT NULL DEFAULT '' COMMENT 'Ip解析区域',
                                      `browser` varchar(64) NOT NULL DEFAULT '' COMMENT '浏览器',
                                      `browser_version` varchar(64) NOT NULL DEFAULT '' COMMENT '浏览器版本',
                                      `os` varchar(128) NOT NULL DEFAULT '' COMMENT '操作系统',
                                      `expired` bigint(20) NOT NULL DEFAULT '0' COMMENT '过期时间',
                                      `is_logout` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否注销',
                                      `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      PRIMARY KEY (`id`),
                                      UNIQUE KEY `jti` (`jti`),
                                      KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_upload_image_logs` (
                                          `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                          `user_id` int(11) NOT NULL DEFAULT '0',
                                          `typed` varchar(32) NOT NULL DEFAULT '' COMMENT '图片类型',
                                          `scene` varchar(24) NOT NULL DEFAULT '' COMMENT '上传场景',
                                          `driver` varchar(32) NOT NULL DEFAULT '' COMMENT '驱动',
                                          `path` varchar(255) NOT NULL DEFAULT '' COMMENT '相对路径',
                                          `url` varchar(255) NOT NULL DEFAULT '' COMMENT '访问地址',
                                          `size` bigint(20) NOT NULL COMMENT '大小,单位:字节',
                                          `name` varchar(255) NOT NULL DEFAULT '' COMMENT '文件名',
                                          `created_at` timestamp NULL DEFAULT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `users` (
                         `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                         `email` varchar(32) NOT NULL DEFAULT '' COMMENT '邮件',
                         `name` varchar(24) NOT NULL DEFAULT '' COMMENT '真实姓名',
                         `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
                         `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
                         `salt` varchar(12) NOT NULL DEFAULT '' COMMENT 'salt',
                         `id_card` varchar(64) NOT NULL DEFAULT '' COMMENT '身份证号',
                         `credit1` int(11) NOT NULL DEFAULT '0' COMMENT '学分',
                         `create_ip` varchar(15) NOT NULL DEFAULT '' COMMENT '注册Ip',
                         `create_city` varchar(32) NOT NULL DEFAULT '' COMMENT '注册城市',
                         `is_active` tinyint(4) NOT NULL DEFAULT '0' COMMENT '激活[1:是,0:否]',
                         `is_lock` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁定[1:是,0:否]',
                         `is_verify` tinyint(4) NOT NULL DEFAULT '0' COMMENT '实名认证[1:是,0:否]',
                         `verify_at` timestamp NULL DEFAULT NULL COMMENT '实名认证时间',
                         `is_set_password` tinyint(4) NOT NULL DEFAULT '0' COMMENT '设置密码[1:是,0:否]',
                         `login_at` timestamp NULL DEFAULT NULL COMMENT '登录时间',
                         `created_at` timestamp NULL DEFAULT NULL,
                         `updated_at` timestamp NULL DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `admin_logs` (
                                            `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                            `admin_id` int(11) NOT NULL DEFAULT '0' COMMENT '管理员ID',
                                            `admin_name` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员姓名',
                                            `module` varchar(32) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '模块',
                                            `title` varchar(32) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '请求方法标题',
                                            `opt` int(2) NOT NULL DEFAULT '0' COMMENT '操作指令（0其它 1新增 2修改 3删除 4登录 5退出登录）',
                                            `method` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '请求方法',
                                            `request_method` varchar(10) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '请求方式POST,GET,PUT,DELETE',
                                            `url` varchar(266) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '请求URL',
                                            `param` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
                                            `result` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '返回参数',
                                            `ip` varchar(45) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT 'ip',
                                            `ip_area` varchar(32) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '地址',
                                            `error_msg` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '错误消息',
                                            `created_at` timestamp NULL DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            KEY `a_m_o` (`admin_id`,`module`,`opt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `course_attachment` (
                                     `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                     `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程ID',
                                     `sort` int(11) NOT NULL DEFAULT '0' COMMENT '升序',
                                     `title` varchar(255) NOT NULL DEFAULT '' COMMENT '附件名',
                                     `type` varchar(20)  NOT NULL DEFAULT '' COMMENT '附件类型',
                                     `rid` int(11) NOT NULL DEFAULT '0' COMMENT '资源id',
                                     `created_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`id`),
                                     KEY `course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `course_attachment_download_log` (
                                                  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                                  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '学员ID',
                                                  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程ID',
                                                  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '课程标题',
                                                  `courser_attachment_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程附件id',
                                                  `rid` int(11) NOT NULL DEFAULT '0' COMMENT '资源id',
                                                  `ip` varchar(45)  NOT NULL DEFAULT '' COMMENT '下载ip',
                                                  `created_at` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `courses` ADD `published_at` TIMESTAMP NULL DEFAULT NULL COMMENT '上架时间' AFTER `is_required`;

CREATE TABLE `ldap_user` (
                             `id` int unsigned NOT NULL AUTO_INCREMENT,
                             `uuid` varchar(64) NOT NULL DEFAULT '' COMMENT '唯一特征值',
                             `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
                             `cn` varchar(120) NOT NULL DEFAULT '' COMMENT 'cn',
                             `dn` varchar(120) NOT NULL DEFAULT '' COMMENT 'dn',
                             `ou` varchar(255) NOT NULL DEFAULT '' COMMENT 'ou',
                             `uid` varchar(120) NOT NULL DEFAULT '' COMMENT 'uid',
                             `email` varchar(120) NOT NULL DEFAULT '' COMMENT '邮箱',
                             `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `unique_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `courses` ADD `admin_id` int(10) NOT NULL DEFAULT 0 COMMENT '管理员id';

CREATE TABLE `ldap_department` (
                                   `id` int unsigned NOT NULL AUTO_INCREMENT,
                                   `uuid` varchar(64) NOT NULL DEFAULT '' COMMENT '唯一特征值',
                                   `department_id` int(11) NOT NULL DEFAULT 0 COMMENT '部门ID',
                                   `dn` varchar(120) NOT NULL DEFAULT '' COMMENT 'dn',
                                   `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `unique_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
