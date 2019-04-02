/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : simpleblog

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-04-02 22:35:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `content` text,
  `date` varchar(64) DEFAULT NULL,
  `summary` text,
  `title` varchar(255) DEFAULT NULL,
  `category_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  CONSTRAINT `FKy5kkohbk00g0w88fi05k2hcw` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '测试', '你好', '测试', '测试', '1');
INSERT INTO `article` VALUES ('2', '胡萝卜', null, '胡萝卜', '胡萝卜', '2');
INSERT INTO `article` VALUES ('3', '你好\r\n想你有两种方式\r\n眼内\r\n心底\r\n见你有两种方式\r\n看你\r\n抱你\r\n一场大雨这城市就陌生了\r\n一见到你我就又是全新的了\r\n我把下雨和见你叫做洗礼\r\n世界上美好的东西不太多\r\n立秋傍晚从河对岸吹来的风\r\n二十来岁笑起来要人命的你', '2019-03-17 23:20', '你好\r\n想你有两种方式\r\n眼内\r\n心底\r\n见你有两种方式\r\n看你\r\n抱你\r\n一场', '滴滴滴', '1');
INSERT INTO `article` VALUES ('5', 'Spring Web MVC 框架提供”模型-视图-控制器”( Model-View-Controller )架构和随时可用的组件，用于开发灵活且松散耦合的 Web 应用程序。\r\n\r\nMVC 模式有助于分离应用程序的不同方面，如输入逻辑，业务逻辑和 UI 逻辑，同时在所有这些元素之间提供松散耦合。\r\n', '2019-03-17 23:30', 'Spring Web MVC 框架提供”模型-视图-控制器”( Model-Vi', 'HTC', null);
INSERT INTO `article` VALUES ('6', '隐约雷鸣 阴霾天空 但愿风雨来 能留你在此', '2019-03-17 23:22', '隐约雷鸣 阴霾天空 但愿风雨来 能留你在此', '需要进行修改', '4');
INSERT INTO `article` VALUES ('8', '将对象放入到集合中时，首先判断要放入对象的 hashCode 值与集合中的任意一个元素的 hashCode 值是否相等，如果不相等直接将该对象放入集合中。\r\n\r\n如果 hashCode 值相等，然后再通过 equals 方法判断要放入对象与集合中的任意一个对象是否相等，如果 equals 判断不相等，直接将该元素放入到集合中，否则不放入。\r\n', '2019-03-17 23:31', '将对象放入到集合中时，首先判断要放入对象的 hashCode 值与集合中的任意一', '要成功了', '6');
INSERT INTO `article` VALUES ('10', '一棵树的冬天和春天\r\n一只蝉在夏夜失眠\r\n一行诗被月光隐去字眼\r\n一个你时隐时现', '2019-03-17 23:28', '一棵树的冬天和春天\r\n一只蝉在夏夜失眠\r\n一行诗被月光隐去字眼\r\n一个你时隐时现', '阿里嘎多', null);
INSERT INTO `article` VALUES ('11', 'Java 反射机制主要提供了以下功能：\r\n\r\n- 在运行时构造一个类的对象。\r\n- 判断一个类所具有的成员变量和方法。\r\n- 调用一个对象的方法。\r\n- 生成动态代理。\r\n', '2019-03-17 23:32', 'Java 反射机制主要提供了以下功能：\r\n\r\n- 在运行时构造一个类的对象。\r\n', '你感觉如何', null);
INSERT INTO `article` VALUES ('12', '一个函数里run了三四个协程 那三四个协程所运行的函数里有run了其他不同的协程 有后台任务的，有根据是否有数据触发的', '2019-03-16 23:13', '一个函数里run了三四个协程 那三四个协程所运行的函数里有run了其他不同的协程', '我想我是一首歌', '4');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '测试', '测试');
INSERT INTO `category` VALUES ('2', '分类', '分类');
INSERT INTO `category` VALUES ('3', '爱情', '爱情');
INSERT INTO `category` VALUES ('4', 'Java专栏', 'javaPage');
INSERT INTO `category` VALUES ('5', 'Spring专栏', 'springPage');
INSERT INTO `category` VALUES ('6', 'Js专栏', 'jsPage');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `article_id` int(11) DEFAULT NULL,
  `comm_ip` varchar(255) DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', 'user');
SET FOREIGN_KEY_CHECKS=1;
