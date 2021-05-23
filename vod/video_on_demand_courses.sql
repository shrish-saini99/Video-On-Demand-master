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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `course_name` varchar(45) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `square_photo` varchar(200) DEFAULT NULL,
  `wide_photo` varchar(200) DEFAULT NULL,
  `sample_video` varchar(400) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('Advance Java','Course for developing web applications.','Web Development','src/Pics/1562322334136.png','src/Pics/1562322334139.jpg','src/Videos/1562322334142.mp4',9000),('Android','Used for developing mobile applications.','App Development','src/Pics/1562322557685.png','src/Pics/1562322557688.png','src/Videos/1562322557692.mp4',15000),('ASP.Net','.Net for web development.','Web Development','src/Pics/1562325668242.png','src/Pics/1562325668244.jpg','src/Videos/1562325668245.mp4',15000),('Core Java','Core java is used for developing desktop\napplications.','Desktop App Development','src/Pics/1562322465507.jpg','src/Pics/1562322465511.jpg','src/Videos/1562322465517.mp4',8000),('Python','Latest Technology for developing desktop\napplications.','Desktop App Development','src/Pics/1562324102343.png','src/Pics/1562324102346.png','src/Videos/1562324102348.mp4',12000);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-06 17:24:54
