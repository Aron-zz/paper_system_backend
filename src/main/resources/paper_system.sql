CREATE TABLE `user` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(50) ,         -- 用户名（登录）
  `password` VARCHAR(255) NOT NULL,               -- 密码（加密存储）
  `email` VARCHAR(100) NOT NULL UNIQUE,           -- 邮箱
  `avatar_url` VARCHAR(255) DEFAULT '/images/default-avatar.png', -- 头像
  `contact` VARCHAR(50) DEFAULT '',               -- 联系方式（选填）
  `birthday` DATE DEFAULT '2000-01-01',           -- 生日（选填）
  `gender` ENUM('男', '女', '保密') DEFAULT '保密', -- 性别（选填）
  `organization` VARCHAR(100) DEFAULT '未知单位',  -- 所属单位（选填）
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP, -- 注册时间
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 最后更新时间
);

CREATE TABLE `paper` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `abstract` TEXT,
  `published_at` DATE,
  `doi` VARCHAR(100) UNIQUE,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `user_paper` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `paper_id` BIGINT NOT NULL,
  `author_order` INT DEFAULT 1, -- 表示作者顺序
  `contribution` VARCHAR(255) DEFAULT '',
  CONSTRAINT fk_user_paper_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE,
  CONSTRAINT fk_user_paper_paper FOREIGN KEY (`paper_id`) REFERENCES `paper`(`id`) ON DELETE CASCADE
);
