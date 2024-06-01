-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: digimon
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `cartas`
--

DROP TABLE IF EXISTS `cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartas` (
  `id` int(10) unsigned NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `nivel` varchar(45) DEFAULT NULL,
  `coste` varchar(45) DEFAULT NULL,
  `costeDeDigi` varchar(45) DEFAULT NULL,
  `poder` varchar(45) DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas`
--

LOCK TABLES `cartas` WRITE;
/*!40000 ALTER TABLE `cartas` DISABLE KEYS */;
INSERT INTO `cartas` VALUES (1,'Yokomon','Rojo','2','0','0','0','BT1-001.jpg'),(2,'Bebydomon','Rojo','2','0','0','0','BT1-002.jpg'),(3,'Upamon','Azul','2','0','0','0','BT1-003.jpg'),(4,'Wanymon','Azul','2','0','0','0','BT1-004.jpg'),(5,'Kyaromon','Amarillo','2','0','0','0','BT1-005.jpg'),(6,'Cupimon','Amarillo','2','0','0','0','BT1-006.jpg'),(7,'Tanemon','Verde','2','0','0','0','BT1-007.jpg'),(8,'Frimon','Verde','2','0','0','0','BT1-008.jpg'),(9,'Monodramon','Rojo','3','2','0','3000','BT1-009.jpg'),(10,'Agumon','Rojo','3','3','0','2000','BT1-010.jpg'),(11,'Agumon Expert','Rojo','3','3','0','1000','BT1-011.jpg'),(12,'Biyomon','Rojo','3','3','0','2000','BT1-012.jpg'),(13,'Muchomon','Rojo','3','3','1','5000','BT1-013.jpg'),(14,'Kokatorimon','Rojo','4','3','2','4000','BT1-014.jpg'),(15,'Greymon','Rojo','4','4','2','4000','BT1-015.jpg'),(16,'Tyranomon','Rojo','4','4','2','4000','BT1-016.jpg'),(17,'Birdramon','Rojo','4','4','2','4000','BT1-017.jpg'),(18,'Flarerizamon','Rojo','4','5','2','4000','BT1-018.jpg'),(19,'DarkTyranomon','Rojo','4','6','1','6000','BT1-019.jpg'),(20,'Groundramon','Rojo','5','5','2','6000','BT1-020.jpg'),(21,'MetalGreymon','Rojo','5','6','3','7000','BT1-021.jpg'),(22,'Garudamon','Rojo','5','7','3','7000','BT1-022.jpg'),(23,'SkullGreymon','Rojo','5','7','3','7000','BT1-023.jpg'),(24,'MatalTyranomon','Rojo','5','7','3','10000','BT1-024.jpg'),(25,'WarGreymon','Rojo','6','12','3','11000','BT1-025.jpg'),(26,'BreakDramon','Rojo','6','12','3','1100','BT1-026.jpg'),(27,'Armadillomon','Azul','3','2','1','4000','BT1-027.jpg'),(28,'Elecmon','Azul','3','2','0','3000','BT1-028.jpg'),(29,'Gabumon','Azul','3','3','0','1000','BT1-029.jpg'),(30,'Gomamon','Azul','3','3','0','3000','BT1-030.jpg'),(31,'Monmon','Azul','3','4','1','1000','BT1-031.jpg'),(32,'Frigimon','Azul','4','4','2','4000','BT1-032.jpg'),(33,'Dolphmon','Azul','4','4','2','4000','BT1-033.jpg'),(34,'Ikkakumon','Azul','4','5','2','5000','BT1-034.jpg'),(35,'Leomon','Azul','4','5','2','5000','BT1-035.jpg'),(36,'Garurumon','Azul','4','6','2','5000','BT1-036.jpg'),(37,'Gorillamon','Azul','4','6','1','6000','BT1-037.jpg'),(38,'Monzaemon','Azul','5','5','2','6000','BT1-038.jpg'),(39,'Cerberusmon','Azul','5','6','3','6000','BT1-039.jpg'),(40,'WereGarurumon','Azul','5','6','3','70000','BT1-040.jpg'),(41,'Zudomon','Azul','5','7','3','6000','BT1-041.jpg'),(42,'LoaderLeomon','Azul','5','7','3','10000','BT1-042.jpg'),(43,'SaberLeomon','Azul','6','11','3','10000','BT1-043.jpg'),(44,'MetalGarurumon','Azul','6','12','3','11000','BT1-044.jpg'),(45,'Tsukaimon','Amarillo','3','2','0','3000','BT1-045.jpg'),(46,'Kudamon','Amarillo','3','3','0','1000','BT1-046.jpg'),(47,'Tinkermon','Amarillo','3','3','0','3000','BT1-047.jpg'),(48,'Patamon','Amarillo','3','3','0','2000','BT1-048.jpg'),(49,'Labramon','Amarillo','3','3','0','1000','BT1-049.jpg'),(50,'Liollmon','Amarillo','3','3','0','4000','BT1-050.jpg'),(51,'Reppamon','Amarillo','4','3','2','4000','BT1-051.jpg'),(52,'Seasarmon','Amarillo','4','4','2','4000','BT1-052.jpg'),(53,'Darcmon','Amarillo','4','4','2','4000','BT1-053.jpg'),(54,'Liamon','Amarillo','4','4','3','4000','BT1-054.jpg'),(55,'Angemon','Amarillo','4','5','2','3000','BT1-055.jpg'),(56,'Petermon','Amarillo','4','5','2','5000','BT1-087.jpg');
/*!40000 ALTER TABLE `cartas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-01 10:56:27
