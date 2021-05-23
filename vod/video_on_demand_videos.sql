CREATE DATABASE  IF NOT EXISTS `video_on_demand` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `video_on_demand`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: video_on_demand
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videos` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `lecture_no` int(11) DEFAULT NULL,
  `video` varchar(200) DEFAULT NULL,
  `video_thumbnail` varchar(200) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `course_name` (`course_name`),
  CONSTRAINT `course_name` FOREIGN KEY (`course_name`) REFERENCES `courses` (`course_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (18,1,'src/Videos/1562322747843.mp4','src/Pics/1562322747841.png',10,'Array Adapter','Android'),(19,1,'src/Videos/1562322862171.mp4','src/Pics/1562322862111.png',12,'Installing GUI Builder','Advance Java'),(20,1,'src/Videos/1562322913519.mp4','src/Pics/1562322913517.jpg',12,'ATP','Core Java'),(21,1,'src/Videos/1562324193092.mp4','src/Pics/1562324193089.png',10,'Basics','Python'),(22,1,'src/Videos/1562325752413.mp4','src/Pics/1562325752412.png',10,'Response redirect','ASP.Net');
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-06 17:24:55
