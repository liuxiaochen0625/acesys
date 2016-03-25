-- MySQL dump 10.11
--
-- Host: localhost    Database: acesys
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mailtb`
--

DROP DATABASE IF EXISTS acesys;
CREATE DATABASE acesys DEFAULT CHARSET=gbk;

use acesys;


DROP TABLE IF EXISTS `mailtb`;
CREATE TABLE `mailtb` (
  `id` int(11) NOT NULL auto_increment COMMENT '电子邮件表ID',
  `fromaddress` varchar(50) default NULL COMMENT '发送者邮件地址',
  `frompassword` varchar(30) default NULL COMMENT '发送者邮件密码',
  `toaddress` varchar(50) default NULL COMMENT '接收者邮件地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='电子邮件表';

--
-- Dumping data for table `mailtb`
--

LOCK TABLES `mailtb` WRITE;
/*!40000 ALTER TABLE `mailtb` DISABLE KEYS */;
INSERT INTO `mailtb` VALUES (1,'admin@163.com','suntengfei','admin@163.com');
/*!40000 ALTER TABLE `mailtb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键编号',
  `ordersid` int(11) default NULL COMMENT '外键引用订单ID',
  `productid` int(11) default NULL COMMENT '外键引用商品ID',
  `quantity` varchar(50) default NULL COMMENT '每个商品所购买数量',
  PRIMARY KEY  (`id`),
  KEY `FK_orderitem` (`ordersid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`ordersid`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='订单与商品中间表';

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (5,3,1,'50g'),(6,3,4,'50g'),(7,3,2,'20g'),(8,4,8,'5'),(9,4,5,'5'),(10,4,2,'5'),(11,5,3,'5g'),(12,6,1,'5g'),(13,6,2,'50g');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment COMMENT '订单ID',
  `ordernumber` varchar(50) default NULL COMMENT '订单编号',
  `usrid` int(11) default NULL COMMENT '用户ID',
  `createtime` datetime default NULL COMMENT '订单创建时间',
  `delsoft` varchar(2) default NULL COMMENT '软删除标志',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='订单表';

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'20110928044056',5,'2011-09-28 16:40:56','0'),(4,'20110928044826',5,'2011-09-28 16:48:26','0'),(5,'20110928053859',5,'2011-09-28 17:38:59','0'),(6,'20111008030244',3,'2011-10-08 15:02:44','0');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment COMMENT '商品ID',
  `productnumber` varchar(50) default NULL COMMENT '商品编号',
  `productname` varchar(32) default NULL COMMENT '商品名称',
  `categoryno` varchar(50) default NULL COMMENT '商品分类编号',
  `category` varchar(32) default NULL COMMENT '商品分类名称',
  `imagepath` varchar(100) default NULL COMMENT '商品图片名称',
  `isnewproduct` varchar(2) default NULL COMMENT '是否新商品1-true,0-false',
  `price1` float default NULL COMMENT '价格',
  `price2` float default NULL COMMENT '会员价格',
  `realstock` varchar(50) default NULL COMMENT '库存量',
  `stock` varchar(50) default NULL COMMENT '剩余量',
  `cas` varchar(32) default NULL COMMENT '药品摘要',
  `mdlint` varchar(50) default NULL COMMENT 'mdl编号',
  `formula` varchar(255) default NULL COMMENT '化学方程式',
  `weight` varchar(50) default NULL COMMENT '重量',
  `delsoft` varchar(2) default NULL COMMENT '软删除标志',
  `note` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='商品表';

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'101','白加黑','10','感冒药','ss.jpg','1',12.5,10.5,'123','100','177900-48-1','C12H22N2O1','C2H5OH','30g','0','good'),(2,'102','速效感冒胶囊','10','感冒药','ss.jpg','1',12.5,10.5,'123','100','177900-48-2','C12H22N2O2','NaOH Ca(OH)2 Ba(OH)2 ','30g','0','good'),(3,'111','二甲双胍片','11','西药','ss.jpg','1',12.5,10.5,'123','100','177900-48-3','C12H22N2O3','CH4 C2H2 CH3OH C2H5OH CH3COOH ','30g','0','good'),(4,'112','达美康','11','西药','ss.jpg','1',12.5,10.5,'123','100','177900-48-4','C12H22N2O4','CH4','30g','0','good'),(5,'113','迪沙片','1133','西药','ss.jpg','1',12.5,10.5,'123','140','177900-48-5','C12H22N2O5','CH3OH','30g','0','good'),(6,'114','美吡哒','11','西药','ss.jpg','1',12.5,10.5,'423','300','177900-48-6','C12H22N2O6','CH3OH','30g','1','good'),(7,'121','白芍','14','中药','ss.jpg','1',12.5,10.5,'123','100','177900-48-7','C12H22N2O7','CH3OH','30g','0','good'),(8,'122','何首乌','14','中药','ss.jpg','1',12.5,10.5,'123','100','177900-48-8','C12H22N2O8','CH3OH','30g','0','good'),(9,'123','枸杞','1422','中药','ss.jpg','1',12.5,10.5,'123','100','177900-48-9','C12H22N2O9','CH3OH','30g','1','good'),(10,'114','111','111','西药',NULL,'1',111,11,'11','11','111','111','111','111','0',NULL),(11,'1234','测试药品','1234','西药','download.do.gif','1',1234,1234,'1234','1234','1234','1234','1234','1234','0',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_product`
--

DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键编号',
  `usrid` int(11) default NULL COMMENT '外键,引用用户id',
  `productid` int(11) default NULL COMMENT '外键,引用商品id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='用户与商品中间表';

--
-- Dumping data for table `user_product`
--

LOCK TABLES `user_product` WRITE;
/*!40000 ALTER TABLE `user_product` DISABLE KEYS */;
INSERT INTO `user_product` VALUES (1,5,1),(2,5,2),(3,5,3);
/*!40000 ALTER TABLE `user_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr` (
  `id` int(11) NOT NULL auto_increment COMMENT '用户ID',
  `username` varchar(32) default NULL COMMENT '用户名',
  `password` varchar(32) default NULL COMMENT '密码',
  `fullname` varchar(64) default NULL COMMENT '用户全称',
  `title` varchar(32) default NULL COMMENT '职称级别',
  `companyname` varchar(32) default NULL COMMENT '公司名称',
  `companyaddress` varchar(100) default NULL COMMENT '公司地址',
  `city` varchar(32) default NULL COMMENT '城市',
  `job` varchar(32) default NULL COMMENT '工作职位',
  `tel` varchar(32) default NULL COMMENT '联系电话',
  `email` varchar(64) default NULL COMMENT '电子邮件',
  `country` varchar(32) default NULL COMMENT '国家',
  `zip` varchar(6) default NULL COMMENT '邮政编号',
  `superuser` varchar(2) default NULL COMMENT '用户角色权限3超级用户,2管理员,1普通用户',
  `delsoft` varchar(2) default NULL COMMENT '软删除标志1软删除,0正常',
  `note` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='用户表';

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES (1,'admin','123456','administrator','manager','ascent','501B','beijing','admin','13315266854','admin@163.com','china','100085','3','0','good'),(2,'lixin','lixin','lianglixin','leader','ascent','501B','beijing','manager','13315266853','lixin@163.com','china','100085','2','0','good'),(3,'ascent','ascent','test','test','ascent','501B','beijing','test','13315266852','ascent@163.com','china','100085','1','0','good'),(4,'shang','shang','shangshang','test','ascent','501B','beijing','test','13315266851','test@163.com','china','100085','1','0','good'),(5,'test','test','111','111','111','111','111','111','111','test@163.com','111','111','2','1','111');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-11-03  7:52:32
