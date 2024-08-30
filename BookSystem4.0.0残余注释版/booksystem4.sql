-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: booksystem2
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_admini`
--

DROP TABLE IF EXISTS `t_admini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admini` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admini` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `admpass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admini`
--

LOCK TABLES `t_admini` WRITE;
/*!40000 ALTER TABLE `t_admini` DISABLE KEYS */;
INSERT INTO `t_admini` VALUES (1,'nan','123');
/*!40000 ALTER TABLE `t_admini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookauthor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookprice` decimal(10,2) NOT NULL,
  `bookamount` int NOT NULL,
  `booktype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (2,'C++ Primer plus','史蒂芬·普拉达',98.00,9,'计算机类'),(3,'线性代数','张雪',73.00,24,'基础学科类'),(4,'大学英语一','张九',50.00,7,'基础学科'),(6,'概率论与图论','张雪',100.00,32,'基础学科类'),(7,'新华字典','张雪泽',20.00,17,'基础学科类'),(11,'图书6','作者6',55.00,80,'基础学科类'),(12,'图书7','作者6',88.00,20,'基础学科类'),(13,'图书8','作者6',66.00,13,'基础学科类'),(14,'图书9','作者7',13.00,2,'基础学科类'),(16,'图书11','作者9',108.00,4,'基础学科类'),(17,'图书12','作者10',200.00,70,'基础学科类'),(18,'图书13','作者11',107.00,99,'基础学科类'),(23,'图书14','作者11',20.00,30,'必修科目'),(24,'图书14','作者11',20.00,30,'必修科目'),(25,'图书14','作者11',20.00,30,'必修科目'),(26,'图书14','作者11',20.00,30,'必修科目'),(27,'图书14','作者11',20.00,30,'必修科目'),(28,'图书14','作者11',20.00,30,'必修科目'),(29,'图书14','作者11',20.00,30,'必修科目'),(31,'百从','如花',30.00,2,'小说'),(32,'图书14','作者11',20.00,30,'必修科目'),(33,'图书14','作者11',20.00,30,'必修科目'),(34,'百从','如花',30.00,1,'小说'),(36,'百从','如花',30.00,1,'小说'),(44,'设计','张三',20.00,1,''),(45,'设计','张三',20.00,30,'必修一'),(46,'设计','张三',20.00,30,'必修一'),(47,'设计','张三',20.00,30,'必修一'),(48,'设计','张三',20.00,30,'必修一'),(49,'设计','张三',20.00,30,'必修一'),(63,'测试图书价格','测试图书价格',3.00,2,'测试图书价格'),(64,'测试二','张三',5.00,2,'测试'),(65,'最新测试','张四',40.00,50,'一'),(67,'狼道','匿名',30.00,18,'杂志'),(74,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类'),(75,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类'),(76,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类'),(77,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类'),(78,'新华字典','张雪泽',20.00,1,'基础学科类'),(79,'我的自主权','张三',38.00,2,'小说'),(80,'java从入门到精通','明日科技',59.00,27,'学习类'),(85,'百从','如花',30.00,1,'小说'),(90,'三年级语文','张武断',30.00,1,'小学科目'),(91,'土林','图灵',100.00,5222,'计算机类');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_lender`
--

DROP TABLE IF EXISTS `t_lender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_lender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookauthor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookprice` decimal(10,2) NOT NULL,
  `bookamount` int NOT NULL,
  `booktype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `lender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `money` decimal(10,0) NOT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lender`
--

LOCK TABLES `t_lender` WRITE;
/*!40000 ALTER TABLE `t_lender` DISABLE KEYS */;
INSERT INTO `t_lender` VALUES (7,'鲁滨逊漂流记','张三丰',88.00,4,'基础学科类','张作霖','19665775421',100,'2024-7-7',8),(8,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类','张少华','18778775469',100,'2024-7-1',8),(9,'鲁滨逊漂流记','张三丰',88.00,0,'基础学科类','马奇奇','16898774512',200,'2024-7-1',8),(10,'鲁滨逊漂流记','张三丰',88.00,4,'基础学科类','张子帆','16887454754',100,'2024-7-1',8),(11,'鲁滨逊漂流记','张三丰',88.00,3,'基础学科类','张秋霖','16887454754',100,'2024-7-1',8),(12,'鲁滨逊漂流记','张三丰',88.00,2,'基础学科类','掌门人','13547894515',230,'2024-7-1',8),(13,'鲁滨逊漂流记','张三丰',88.00,6,'基础学科类','赵子龙','16445887542',200,'2024-7-1',8),(14,'鲁滨逊漂流记','张三丰',88.00,5,'基础学科类','张少哲','14578774654',88,'2024-7-1',8),(15,'鲁滨逊漂流记','张三丰',88.00,4,'基础学科类','张少哲','14578774654',89,'2024-7-1',8),(16,'鲁滨逊漂流记','张三丰',88.00,4,'基础学科类','张少哲','14578774654',89,'2024-7-1',8),(17,'鲁滨逊漂流记','张三丰',88.00,4,'基础学科类','张少哲','14578774654',89,'2024-7-1',8),(18,'鲁滨逊漂流记','张三丰',88.00,3,'基础学科类','赵子龙','18365447845',100,'20240701',8),(19,'鲁滨逊漂流记','张三丰',88.00,2,'基础学科类','赵子龙','18365447845',100,'20240701',8),(20,'鲁滨逊漂流记','张三丰',88.00,1,'基础学科类','赵子龙','18365447895',100,'20240701',8),(21,'鲁滨逊漂流记','张三丰',88.00,9,'基础学科类','张子凡','18354779845',100,'20240701',8),(22,'鲁滨逊漂流记','张三丰',88.00,8,'基础学科类','张虎飞','18475889547',100,'20240701',8),(24,'鲁滨逊漂流记','张三丰',88.00,0,'基础学科类','张虎飞','18475889547',100,'20240701',8),(25,'鲁滨逊漂流记','张三丰',88.00,9,'基础学科类','张虎飞','18475889547',100,'20240701',8),(26,'鲁滨逊漂流记','张三丰',88.00,8,'基础学科类','张少龙','14798556574',98,'20240701',8),(27,'张某人的自传','张霖',88.00,3,'小说','张自成','15487556987',100,'20240701',66),(28,'张某人的自传','张霖',88.00,2,'小说','张自成','15487556987',100,'20240701',66),(48,'狼道','匿名',30.00,19,'杂志','张霖宇','14789887542',30,'20240828',67),(49,'狼道','匿名',30.00,18,'杂志','泽宗','14789887542',30,'20240828',67),(78,'C++ Primer plus','史蒂芬·普拉达',98.00,9,'计算机类','tye','456789',456789,'2024.05.25',2),(79,'新华字典','张雪泽',20.00,17,'基础学科类','f','456478',30,'121455',7);
/*!40000 ALTER TABLE `t_lender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reader`
--

DROP TABLE IF EXISTS `t_reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_reader` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reader` varchar(255) NOT NULL,
  `reader_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reader`
--

LOCK TABLES `t_reader` WRITE;
/*!40000 ALTER TABLE `t_reader` DISABLE KEYS */;
INSERT INTO `t_reader` VALUES (131,'7898','12'),(132,'tom','456');
/*!40000 ALTER TABLE `t_reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'zhangsan','123'),(8,'zhanglinyu','123'),(9,'liuyupeng','123'),(10,'liuyupeng2','123'),(11,'zhanglinyu2','123'),(12,'qian','123'),(13,'jc','123'),(14,'yu','123'),(15,'ceshi','123');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-30 13:38:14
