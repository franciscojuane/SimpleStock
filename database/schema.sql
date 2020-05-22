-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Laptops'),(2,'Printers'),(3,'Headphones'),(4,'Cables');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ItemDescription_id` int NOT NULL,
  `Location_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Item_ItemDescription_idx` (`ItemDescription_id`),
  KEY `fk_Item_Location1_idx` (`Location_id`),
  CONSTRAINT `fk_Item_ItemDescription` FOREIGN KEY (`ItemDescription_id`) REFERENCES `itemdescription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,1,1),(2,1,1),(3,1,2),(4,2,2),(5,2,3),(6,2,3),(7,3,3),(8,3,2),(9,3,2),(10,4,1),(11,5,3);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemdescription`
--

DROP TABLE IF EXISTS `itemdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemdescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `Category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ItemDescription_Category1_idx` (`Category_id`),
  CONSTRAINT `fk_ItemDescription_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemdescription`
--

LOCK TABLES `itemdescription` WRITE;
/*!40000 ALTER TABLE `itemdescription` DISABLE KEYS */;
INSERT INTO `itemdescription` VALUES (1,'Epson XP 231','Home use printer.',5,2),(2,'HP Envy 17','Professional Use Laptop',12,1),(3,'Xiaomi Ear Pro HD','Chinese headphones',0.2,3),(4,'UTP 100m','100 meters Unshielded Twisted Pair',10,4),(5,'STP 100m','Shielded Twisted Pair Cable',13,4);
/*!40000 ALTER TABLE `itemdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Deposit A'),(2,'Deposit B'),(3,'Deposit C');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `idlogs` int NOT NULL AUTO_INCREMENT,
  `operation` varchar(10) DEFAULT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idlogs`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (1,'getAll','Category','2020-05-22 12:45:38','francisco'),(2,'create','Category','2020-05-22 12:45:45','francisco'),(3,'read','Category','2020-05-22 12:45:45','francisco'),(4,'read','Category','2020-05-22 12:45:45','francisco'),(5,'getAll','Category','2020-05-22 12:45:49','francisco'),(6,'create','Category','2020-05-22 12:45:57','francisco'),(7,'read','Category','2020-05-22 12:45:57','francisco'),(8,'read','Category','2020-05-22 12:45:57','francisco'),(9,'getAll','Category','2020-05-22 12:45:59','francisco'),(10,'create','Category','2020-05-22 12:48:43','francisco'),(11,'read','Category','2020-05-22 12:48:43','francisco'),(12,'read','Category','2020-05-22 12:48:43','francisco'),(13,'getAll','Category','2020-05-22 12:48:45','francisco'),(14,'create','Category','2020-05-22 12:49:01','francisco'),(15,'read','Category','2020-05-22 12:49:01','francisco'),(16,'read','Category','2020-05-22 12:49:01','francisco'),(17,'getAll','Category','2020-05-22 12:49:03','francisco'),(18,'getAll','Location','2020-05-22 12:49:06','francisco'),(19,'create','Location','2020-05-22 12:49:13','francisco'),(20,'read','Location','2020-05-22 12:49:13','francisco'),(21,'getAll','Location','2020-05-22 12:49:17','francisco'),(22,'create','Location','2020-05-22 12:49:24','francisco'),(23,'read','Location','2020-05-22 12:49:24','francisco'),(24,'getAll','Location','2020-05-22 12:49:27','francisco'),(25,'create','Location','2020-05-22 12:49:33','francisco'),(26,'read','Location','2020-05-22 12:49:33','francisco'),(27,'getAll','ItemDescription','2020-05-22 12:49:37','francisco'),(28,'getAll','Category','2020-05-22 12:49:41','francisco'),(29,'create','ItemDescription','2020-05-22 12:49:58','francisco'),(30,'read','ItemDescription','2020-05-22 12:49:58','francisco'),(31,'read','ItemDescription','2020-05-22 12:49:58','francisco'),(32,'read','Item','2020-05-22 12:49:58','francisco'),(33,'read','Location','2020-05-22 12:49:58','francisco'),(34,'read','ItemDescription','2020-05-22 12:50:27','francisco'),(35,'getAll','ItemDescription','2020-05-22 12:50:27','francisco'),(36,'getAll','Location','2020-05-22 12:50:27','francisco'),(37,'create','Item','2020-05-22 12:50:31','francisco'),(38,'read','Item','2020-05-22 12:50:31','francisco'),(39,'read','Location','2020-05-22 12:50:31','francisco'),(40,'getAll','ItemDescription','2020-05-22 12:50:34','francisco'),(41,'read','ItemDescription','2020-05-22 12:50:36','francisco'),(42,'read','ItemDescription','2020-05-22 12:50:36','francisco'),(43,'read','Item','2020-05-22 12:50:36','francisco'),(44,'read','Location','2020-05-22 12:50:36','francisco'),(45,'read','ItemDescription','2020-05-22 12:50:38','francisco'),(46,'getAll','ItemDescription','2020-05-22 12:50:38','francisco'),(47,'getAll','Location','2020-05-22 12:50:38','francisco'),(48,'create','Item','2020-05-22 12:50:41','francisco'),(49,'read','Item','2020-05-22 12:50:41','francisco'),(50,'read','Location','2020-05-22 12:50:41','francisco'),(51,'getAll','Category','2020-05-22 12:50:47','francisco'),(52,'read','Category','2020-05-22 12:50:50','francisco'),(53,'read','Category','2020-05-22 12:50:50','francisco'),(54,'getAll','ItemDescription','2020-05-22 12:50:57','francisco'),(55,'read','ItemDescription','2020-05-22 12:50:59','francisco'),(56,'read','ItemDescription','2020-05-22 12:50:59','francisco'),(57,'read','Item','2020-05-22 12:50:59','francisco'),(58,'read','Location','2020-05-22 12:50:59','francisco'),(59,'read','ItemDescription','2020-05-22 12:51:05','francisco'),(60,'getAll','ItemDescription','2020-05-22 12:51:05','francisco'),(61,'getAll','Location','2020-05-22 12:51:05','francisco'),(62,'create','Item','2020-05-22 12:51:08','francisco'),(63,'read','Item','2020-05-22 12:51:08','francisco'),(64,'read','Location','2020-05-22 12:51:08','francisco'),(65,'getAll','Category','2020-05-22 12:51:11','francisco'),(66,'read','Category','2020-05-22 12:51:15','francisco'),(67,'read','Category','2020-05-22 12:51:15','francisco'),(68,'getAll','ItemDescription','2020-05-22 12:51:25','francisco'),(69,'getAll','Category','2020-05-22 12:51:27','francisco'),(70,'read','Category','2020-05-22 12:52:00','francisco'),(71,'read','Category','2020-05-22 12:52:00','francisco'),(72,'read','Category','2020-05-22 12:52:03','francisco'),(73,'getAll','Category','2020-05-22 12:52:03','francisco'),(74,'create','ItemDescription','2020-05-22 12:52:21','francisco'),(75,'read','ItemDescription','2020-05-22 12:52:21','francisco'),(76,'read','ItemDescription','2020-05-22 12:52:21','francisco'),(77,'read','Item','2020-05-22 12:52:21','francisco'),(78,'read','Location','2020-05-22 12:52:21','francisco'),(79,'read','ItemDescription','2020-05-22 12:52:23','francisco'),(80,'getAll','ItemDescription','2020-05-22 12:52:23','francisco'),(81,'getAll','Location','2020-05-22 12:52:23','francisco'),(82,'create','Item','2020-05-22 12:52:27','francisco'),(83,'read','Item','2020-05-22 12:52:27','francisco'),(84,'read','Location','2020-05-22 12:52:27','francisco'),(85,'getAll','ItemDescription','2020-05-22 12:52:31','francisco'),(86,'read','ItemDescription','2020-05-22 12:52:33','francisco'),(87,'read','ItemDescription','2020-05-22 12:52:33','francisco'),(88,'read','Item','2020-05-22 12:52:33','francisco'),(89,'read','Location','2020-05-22 12:52:33','francisco'),(90,'read','ItemDescription','2020-05-22 12:52:35','francisco'),(91,'getAll','ItemDescription','2020-05-22 12:52:35','francisco'),(92,'getAll','Location','2020-05-22 12:52:35','francisco'),(93,'create','Item','2020-05-22 12:52:38','francisco'),(94,'read','Item','2020-05-22 12:52:38','francisco'),(95,'read','Location','2020-05-22 12:52:38','francisco'),(96,'getAll','ItemDescription','2020-05-22 12:52:43','francisco'),(97,'read','ItemDescription','2020-05-22 12:52:45','francisco'),(98,'read','ItemDescription','2020-05-22 12:52:45','francisco'),(99,'read','Item','2020-05-22 12:52:45','francisco'),(100,'read','Location','2020-05-22 12:52:45','francisco'),(101,'read','ItemDescription','2020-05-22 12:52:47','francisco'),(102,'getAll','ItemDescription','2020-05-22 12:52:47','francisco'),(103,'getAll','Location','2020-05-22 12:52:47','francisco'),(104,'create','Item','2020-05-22 12:52:51','francisco'),(105,'read','Item','2020-05-22 12:52:51','francisco'),(106,'read','Location','2020-05-22 12:52:51','francisco'),(107,'getAll','Category','2020-05-22 12:52:54','francisco'),(108,'read','Category','2020-05-22 12:53:04','francisco'),(109,'read','Category','2020-05-22 12:53:04','francisco'),(110,'read','Category','2020-05-22 12:53:10','francisco'),(111,'getAll','Category','2020-05-22 12:53:10','francisco'),(112,'create','ItemDescription','2020-05-22 12:53:39','francisco'),(113,'read','ItemDescription','2020-05-22 12:53:39','francisco'),(114,'read','ItemDescription','2020-05-22 12:53:39','francisco'),(115,'read','Item','2020-05-22 12:53:39','francisco'),(116,'read','Location','2020-05-22 12:53:39','francisco'),(117,'read','ItemDescription','2020-05-22 12:53:43','francisco'),(118,'getAll','ItemDescription','2020-05-22 12:53:43','francisco'),(119,'getAll','Location','2020-05-22 12:53:43','francisco'),(120,'create','Item','2020-05-22 12:53:46','francisco'),(121,'read','Item','2020-05-22 12:53:46','francisco'),(122,'read','Location','2020-05-22 12:53:46','francisco'),(123,'getAll','ItemDescription','2020-05-22 12:53:54','francisco'),(124,'read','ItemDescription','2020-05-22 12:53:58','francisco'),(125,'read','ItemDescription','2020-05-22 12:53:58','francisco'),(126,'read','Item','2020-05-22 12:53:58','francisco'),(127,'read','Location','2020-05-22 12:53:58','francisco'),(128,'getAll','ItemDescription','2020-05-22 12:54:00','francisco'),(129,'read','ItemDescription','2020-05-22 12:54:16','francisco'),(130,'getAll','Category','2020-05-22 12:54:16','francisco'),(131,'create','ItemDescription','2020-05-22 12:54:43','francisco'),(132,'read','ItemDescription','2020-05-22 12:54:43','francisco'),(133,'read','ItemDescription','2020-05-22 12:54:43','francisco'),(134,'read','Item','2020-05-22 12:54:43','francisco'),(135,'read','Location','2020-05-22 12:54:43','francisco'),(136,'read','ItemDescription','2020-05-22 12:54:47','francisco'),(137,'getAll','ItemDescription','2020-05-22 12:54:47','francisco'),(138,'getAll','Location','2020-05-22 12:54:47','francisco'),(139,'create','Item','2020-05-22 12:54:50','francisco'),(140,'read','Item','2020-05-22 12:54:50','francisco'),(141,'read','Location','2020-05-22 12:54:50','francisco'),(142,'getAll','ItemDescription','2020-05-22 12:54:54','francisco'),(143,'read','ItemDescription','2020-05-22 12:55:28','francisco'),(144,'read','ItemDescription','2020-05-22 12:55:28','francisco'),(145,'read','Item','2020-05-22 12:55:28','francisco'),(146,'read','Location','2020-05-22 12:55:28','francisco'),(147,'read','ItemDescription','2020-05-22 12:55:31','francisco'),(148,'getAll','ItemDescription','2020-05-22 12:55:31','francisco'),(149,'getAll','Location','2020-05-22 12:55:31','francisco'),(150,'create','Item','2020-05-22 12:55:34','francisco'),(151,'read','Item','2020-05-22 12:55:34','francisco'),(152,'read','Location','2020-05-22 12:55:34','francisco'),(153,'getAll','Category','2020-05-22 12:55:39','francisco'),(154,'read','Category','2020-05-22 12:55:41','francisco'),(155,'read','Category','2020-05-22 12:55:41','francisco'),(156,'read','Category','2020-05-22 12:55:46','francisco'),(157,'getAll','Category','2020-05-22 12:55:46','francisco'),(158,'create','ItemDescription','2020-05-22 12:56:03','francisco'),(159,'read','ItemDescription','2020-05-22 12:56:03','francisco'),(160,'read','ItemDescription','2020-05-22 12:56:03','francisco'),(161,'read','Item','2020-05-22 12:56:03','francisco'),(162,'read','Location','2020-05-22 12:56:03','francisco'),(163,'read','ItemDescription','2020-05-22 12:56:05','francisco'),(164,'getAll','ItemDescription','2020-05-22 12:56:05','francisco'),(165,'getAll','Location','2020-05-22 12:56:05','francisco'),(166,'create','Item','2020-05-22 12:56:07','francisco'),(167,'read','Item','2020-05-22 12:56:07','francisco'),(168,'read','Location','2020-05-22 12:56:07','francisco'),(169,'getAll','ItemDescription','2020-05-22 12:56:10','francisco'),(170,'getAll','Category','2020-05-22 12:56:12','francisco'),(171,'getAll','ItemDescription','2020-05-22 12:56:22','francisco'),(172,'getAll','Category','2020-05-22 12:56:24','francisco'),(173,'create','ItemDescription','2020-05-22 12:56:39','francisco'),(174,'read','ItemDescription','2020-05-22 12:56:39','francisco'),(175,'read','ItemDescription','2020-05-22 12:56:39','francisco'),(176,'read','Item','2020-05-22 12:56:39','francisco'),(177,'read','Location','2020-05-22 12:56:39','francisco'),(178,'getAll','ItemDescription','2020-05-22 12:56:45','francisco'),(179,'getAll','Location','2020-05-22 12:56:52','francisco'),(180,'read','Location','2020-05-22 12:56:54','francisco'),(181,'getAll','Item','2020-05-22 12:57:15','francisco'),(182,'getAll','ItemDescription','2020-05-22 12:58:16','francisco'),(183,'read','ItemDescription','2020-05-22 12:58:19','francisco'),(184,'read','ItemDescription','2020-05-22 12:58:19','francisco'),(185,'read','Item','2020-05-22 12:58:19','francisco'),(186,'read','Location','2020-05-22 12:58:19','francisco'),(187,'read','ItemDescription','2020-05-22 12:58:22','francisco'),(188,'getAll','ItemDescription','2020-05-22 12:58:22','francisco'),(189,'getAll','Location','2020-05-22 12:58:22','francisco'),(190,'create','Item','2020-05-22 12:58:25','francisco'),(191,'read','Item','2020-05-22 12:58:25','francisco'),(192,'read','Location','2020-05-22 12:58:25','francisco'),(193,'getAll','User','2020-05-22 12:58:32','francisco');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'francisco','$2y$12$vhxWPhrhYIs/fSIrLnyMH.S9cxYrRMxLEXxZkt2WgBpu5odm9ELje');
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

-- Dump completed on 2020-05-22 12:59:43
