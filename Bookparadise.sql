/*
Navicat MySQL Data Transfer

Source Server         : JasonDB
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : bookparadise

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-06-11 22:29:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinfor
-- ----------------------------
DROP TABLE IF EXISTS `bookinfor`;
CREATE TABLE `bookinfor` (
  `bookid` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `bookname` varchar(100) DEFAULT NULL,
  `personid` smallint(5) unsigned DEFAULT NULL,
  `uploaddate` date DEFAULT NULL,
  `filetype` char(25) DEFAULT NULL,
  `author` char(25) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `personid` (`personid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for downloadbook
-- ----------------------------
DROP TABLE IF EXISTS `downloadbook`;
CREATE TABLE `downloadbook` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `userid` smallint(6) DEFAULT NULL,
  `bookid` smallint(6) DEFAULT NULL,
  `downloadtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `role_name` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfor
-- ----------------------------
DROP TABLE IF EXISTS `userinfor`;
CREATE TABLE `userinfor` (
  `userid` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `hobby` varchar(100) DEFAULT NULL,
  `motto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userlogin
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `userid` smallint(6) DEFAULT NULL,
  `logintime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `username` varchar(100) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
