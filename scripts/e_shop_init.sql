DROP DATABASE IF EXISTS `e_shop`;
CREATE DATABASE `e_shop`;

USE `e_shop`;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
    `id` INT(16) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(32) NOT NULL ,
    `commodity_id` INT(32) NOT NULL ,
    `order_t` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
    `id` INT(32) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
    `id` INT(32) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL ,
    PRIMARY KEY (`id`)
);

INSERT INTO `customer`(`name`)
VALUES ('Bob'), ('Lily'), ('Amy'), ('Balabala');

INSERT INTO `commodity`(`name`)
VALUES ('大葱'), ('大蒜'), ('猪头肉'),('猪肘子'),('猪蹄'),('猪耳朵'),('猪脑花');

INSERT INTO `order`(`customer_id`, `commodity_id`,`order_t`)
VALUES (3,2,now()), (3,3,now()), (1,2,now()),(2,4,now()),(1,1,now());