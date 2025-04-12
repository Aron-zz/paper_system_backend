CREATE TABLE `user` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,         -- 用户名（登录）
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

CREATE TABLE `contact` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,        -- 联系人 ID
  `user_id` BIGINT NOT NULL,                     -- 用户 ID，关联到 `user` 表
  `name` VARCHAR(100) NOT NULL,                   -- 联系人姓名
  `phone` VARCHAR(20),                           -- 联系电话
  `email` VARCHAR(100),                          -- 联系人邮箱
  `address` VARCHAR(255),                        -- 联系人地址
  `relationship` VARCHAR(50),                    -- 与用户的关系（例如：朋友、同事等）
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP, -- 创建时间
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
  CONSTRAINT fk_contact_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);

INSERT INTO `user_paper` (`user_id`, `paper_id`, `author_order`, `contribution`)
VALUES
(1, 1, 1, '主要作者，负责图像分类部分的研究与实现'),
(1, 2, 2, '合作者，负责部分机器学习理论的阐述'),
(2, 1, 2, '合作者，负责图像处理部分的理论分析'),
(3, 3, 1, '主要作者，负责数据挖掘技术的研究与实现');

INSERT INTO `paper` (`title`, `abstract`, `published_at`, `doi`, `created_at`)
VALUES
('深度学习在图像处理中的应用', '本文探讨了深度学习技术在图像处理中的多个应用，如图像分类、目标检测等。', '2023-06-15', '10.1234/journal.2023.01', NOW()),
('人工智能与机器学习基础', '本文介绍了人工智能与机器学习的基本理论和实践，适合初学者了解。', '2022-11-05', '10.5678/journal.2022.05', NOW()),
('数据挖掘方法与技术', '数据挖掘作为一种重要的技术，已经广泛应用于各行各业。本文介绍了几种常见的数据挖掘算法。', '2021-07-20', '10.9101/journal.2021.10', NOW());

INSERT INTO `user` (`username`, `password`, `email`, `avatar_url`, `contact`, `birthday`, `gender`, `organization`, `created_at`, `updated_at`)
VALUES
('张星岩','123456', 'zhangxingyan@example.com', '/images/avatar1.png', '123456789', '1995-10-15', '男', '计算机科学与技术学院', NOW(), NOW()),
('李晓华', '123456', 'lixiaohua@example.com', '/images/avatar2.png', '987654321', '1992-03-20', '女', '信息技术部', NOW(), NOW()),
('王大明', '123456', 'wangdaming@example.com', '/images/avatar3.png', '555666777', '1988-08-12', '保密', '数据科学研究所', NOW(), NOW());



