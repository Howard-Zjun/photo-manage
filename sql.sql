-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: photo-manage
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `friend_relationship`
--

DROP TABLE IF EXISTS `friend_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend_relationship` (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `friend_id` int DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`relationship_id`),
  KEY `friend_relationship_foreign_userId_idx` (`user_id`),
  KEY `friend_relationship_foreign_friendId` (`friend_id`),
  CONSTRAINT `friend_relationship_foreign_friendId` FOREIGN KEY (`friend_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `friend_relationship_foreign_userId` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_relationship`
--

LOCK TABLES `friend_relationship` WRITE;
/*!40000 ALTER TABLE `friend_relationship` DISABLE KEYS */;
INSERT INTO `friend_relationship` VALUES (1,1,2,'机器人2'),(2,1,3,'机器人3'),(3,2,1,'机器人1'),(4,3,1,'机器人1');
/*!40000 ALTER TABLE `friend_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `share` (
  `share_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `send_date` datetime DEFAULT NULL,
  `detail` text,
  `tags` varchar(100) DEFAULT NULL,
  `show` tinyint(1) DEFAULT NULL,
  `tag_id_group` int DEFAULT NULL,
  PRIMARY KEY (`share_id`),
  KEY `SHARE_IND_USERID` (`user_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `share_foreigh_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
INSERT INTO `share` VALUES (1,1,'1 测试','2022-01-01 00:00:00','生活就像海洋，只有意志坚强的人，才能到达彼岸','自然',1,1),(2,1,'2 测试','2022-01-01 00:00:00','生活就像海洋，只有意志坚强的人，才能到达彼岸','相机',1,NULL),(3,2,'3 测试','2022-01-01 00:00:00','生活就像海洋，只有意志坚强的人，才能到达彼岸','自然',1,NULL),(4,3,'4 测试','2022-01-01 00:00:00','生活就像海洋，只有意志坚强的人，才能到达彼岸','魔幻',1,3);
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share_interaction`
--

DROP TABLE IF EXISTS `share_interaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `share_interaction` (
  `remark_id` int NOT NULL AUTO_INCREMENT,
  `share_id` int NOT NULL,
  `user_id` int NOT NULL,
  `detail` varchar(100) NOT NULL,
  `send_date` datetime NOT NULL,
  PRIMARY KEY (`remark_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `interaction_shareid` (`share_id`),
  CONSTRAINT `interaction_shareid` FOREIGN KEY (`share_id`) REFERENCES `share` (`share_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `interaction_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share_interaction`
--

LOCK TABLES `share_interaction` WRITE;
/*!40000 ALTER TABLE `share_interaction` DISABLE KEYS */;
INSERT INTO `share_interaction` VALUES (1,1,1,'remark 1','2000-01-01 00:00:00'),(2,1,2,'remark 2','2000-01-01 00:00:00'),(18,1,1,'remark 3','2022-05-13 00:00:00');
/*!40000 ALTER TABLE `share_interaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share_photo_set`
--

DROP TABLE IF EXISTS `share_photo_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `share_photo_set` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `share_id` int NOT NULL,
  `photo_path` varchar(100) NOT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `photo_shareid` (`share_id`),
  CONSTRAINT `photo_shareid` FOREIGN KEY (`share_id`) REFERENCES `share` (`share_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share_photo_set`
--

LOCK TABLES `share_photo_set` WRITE;
/*!40000 ALTER TABLE `share_photo_set` DISABLE KEYS */;
INSERT INTO `share_photo_set` VALUES (1,1,'6211f2f0bcb4366e952a6cba'),(2,2,'6211f2f0bcb4366e952a6cbc'),(3,3,'6211f2f0bcb4366e952a6cbe'),(4,4,'627a7d3217259f1197314ab4');
/*!40000 ALTER TABLE `share_photo_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share_replenish`
--

DROP TABLE IF EXISTS `share_replenish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `share_replenish` (
  `share_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`share_id`,`user_id`),
  KEY `replenish_userid_idx` (`user_id`) /*!80000 INVISIBLE */,
  KEY `replenish_shareid_idx` (`share_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `replenish_shareid` FOREIGN KEY (`share_id`) REFERENCES `share` (`share_id`) ON UPDATE RESTRICT,
  CONSTRAINT `replenish_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share_replenish`
--

LOCK TABLES `share_replenish` WRITE;
/*!40000 ALTER TABLE `share_replenish` DISABLE KEYS */;
INSERT INTO `share_replenish` VALUES (1,1),(1,2),(1,3),(2,1);
/*!40000 ALTER TABLE `share_replenish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `canSee` tinyint(1) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `tag_foreigh_userid_idx` (`user_id`),
  CONSTRAINT `tag_foreigh_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'80后',1,1),(2,'合作搭档',1,2),(3,'游戏伙伴',1,3),(7,'90后',1,1);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_relationship`
--

DROP TABLE IF EXISTS `tag_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_relationship` (
  `tag_relationship_id` int NOT NULL AUTO_INCREMENT,
  `tag_id` int NOT NULL,
  `friend_relationship_id` int NOT NULL,
  PRIMARY KEY (`tag_relationship_id`),
  KEY `tag_relationship_foreign_tagId_idx` (`tag_id`),
  KEY `tag_relationship_foreign_relationshipId_idx` (`friend_relationship_id`),
  CONSTRAINT `tag_relationship_foreign_relationshipId` FOREIGN KEY (`friend_relationship_id`) REFERENCES `friend_relationship` (`relationship_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tag_relationship_foreign_tagId` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_relationship`
--

LOCK TABLES `tag_relationship` WRITE;
/*!40000 ALTER TABLE `tag_relationship` DISABLE KEYS */;
INSERT INTO `tag_relationship` VALUES (1,2,3),(44,1,1),(45,7,2);
/*!40000 ALTER TABLE `tag_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `introduce` varchar(45) DEFAULT NULL,
  `real_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin1','123',1,'深圳','2000-01-01','15917245195','2548795196@qq.com','i am admin','机器人'),(2,'jack','123',1,'广州','2000-01-01','15917245195','3548795196@qq.com','i am jack','机器人2'),(3,'jenny','123',1,'北京','2000-01-01','15917245195','1548795196@qq.com','i am jenny','机器人3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 21:43:31
