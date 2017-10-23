-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `logfile`
--

DROP TABLE IF EXISTS `logfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logfile` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date_Time` varchar(450) DEFAULT NULL,
  `ChangedBy` varchar(45) DEFAULT NULL,
  `Action` varchar(45) DEFAULT NULL,
  `Value` varchar(45) DEFAULT NULL,
  `InWhat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logfile`
--

LOCK TABLES `logfile` WRITE;
/*!40000 ALTER TABLE `logfile` DISABLE KEYS */;
INSERT INTO `logfile` VALUES (1,'2017-05-21T00:29:46.146','Admin','Logged Out ',' ',' '),(77,'2017-05-21T00:29:46.146','Vanta','Logged In ',' ',' '),(78,'2017-05-21T00:30:01.550','Vanta','Inserted a new product in ','3','Products'),(79,'2017-05-21T00:30:04.912','Vanta','Deleted a product  in ','','Products'),(80,'2017-05-21T00:30:17.154','Vanta','Inserted a new value in ','2','Orders'),(81,'2017-05-21T00:30:38.688','Vanta','Deleted a product  in ','','Products'),(82,'2017-05-21T00:30:40.322','Vanta','Deleted a product  in ','','Products'),(83,'2017-05-21T00:31:02.356','','Deleted a product  in ','3','Products'),(84,'2017-05-21T00:31:17.508','Vanta','Logged In ',' ',' '),(85,'2017-05-21T00:31:46.865','Vanta','Inserted a new product in ','4','Products'),(86,'2017-05-21T00:31:52.767','Vanta','Deleted a product  in ','4','Products'),(87,'2017-05-21T00:31:55.784','Vanta','Logged Out ',' ',' '),(88,'2017-05-21T00:57:35.940','Admin','Logged In ',' ',' '),(89,'2017-05-21T00:57:38.609','Admin','Logged Out ',' ',' '),(90,'2017-05-21T19:17:21.051','MikeM','Logged In ',' ',' '),(91,'2017-05-21T19:18:02.649','MikeM','Inserted a new value in ','Tsixles','Orders'),(92,'2017-05-21T19:18:08.128','MikeM','Logged Out ',' ',' '),(93,'2017-05-21T19:49:33.183','','Updated a user in ','Vantas','Users'),(94,'2017-05-21T19:49:41.570','','Updated a user in ','Vanta','Users'),(95,'2017-05-21T22:09:27.099','','Updated a user in ','MikeMσ','Users'),(96,'2017-05-21T22:09:56.451','','Updated a user in ','MikeM','Users'),(97,'2017-05-21T22:10:02.792','jLabel5','Logged Out ',' ',' '),(98,'2017-05-21T22:10:15.377','Vanta','Logged In ',' ',' '),(99,'2017-05-21T22:10:19.802','Vanta','Logged Out ',' ',' '),(100,'2017-05-21T22:10:26.445','Admin','Logged In ',' ',' '),(101,'2017-05-21T22:10:52.577','Admin','Logged Out ',' ',' '),(102,'2017-05-21T22:15:07.518','Admin','Logged In ',' ',' '),(103,'2017-05-21T22:15:13.235','Admin','Updated a user in ','Vanta','Users'),(104,'2017-05-21T22:15:30.750','Admin','Updated a user in ','Vanta','Users'),(105,'2017-05-21T22:15:42.842','Admin','Logged Out ',' ',' '),(106,'2017-05-22T18:51:33.771','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(107,'2017-05-22T18:52:01.479','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(108,'2017-05-22T18:55:22.036','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(109,'2017-05-22T18:59:42.182','','Updated a  product in ','GeForce GTX 1080','Products'),(110,'2017-05-22T19:03:30.986','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(111,'2017-05-22T19:05:24.799','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(112,'2017-05-22 19:05:50','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(113,'22/05/2017 19:07:22','','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(114,'22/05/2017 19:16:07','Admin','Logged In ',' ',' '),(115,'22/05/2017 19:16:10','Admin','Logged Out ',' ',' '),(116,'22/05/2017 19:16:18','Vanta','Logged In ',' ',' '),(117,'22/05/2017 19:16:35','Vanta','Updated a  product in ','Trust Optical Wire Basic Mouse','Products'),(118,'22/05/2017 19:16:43','Vanta','Inserted a new product in ','2','Products'),(119,'22/05/2017 19:16:48','Vanta','Deleted a product  in ','Trust Optical Wire Basic Mouse','Products'),(120,'22/05/2017 19:17:15','Vanta','Inserted a new order in ','tades','Orders'),(121,'22/05/2017 19:17:23','Vanta','Confirmed a new order in ','tades','Orders'),(122,'22/05/2017 19:17:32','Vanta','Inserted A supplier in ',' ','Suppliers List'),(123,'22/05/2017 19:17:39','Vanta','Deleted A supplier in ',' ','Suppliers List'),(124,'22/05/2017 19:17:47','Vanta','Logged Out ',' ',' '),(125,'22/05/2017 19:17:51','Admin','Logged In ',' ',' '),(126,'22/05/2017 19:37:58','','Updated a  product in ','','Products'),(127,'22/05/2017 19:38:03','','Updated a  product in ','GeForce GTX 1080','Products'),(128,'22/05/2017 19:46:18','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(129,'22/05/2017 19:47:36','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(130,'22/05/2017 19:49:33','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(131,'22/05/2017 19:49:44','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(132,'22/05/2017 19:50:47','Name','Inserted a new order in ','astas','Orders'),(133,'22/05/2017 19:51:10','','Confirmed a new order in ','astas','Orders'),(134,'22/05/2017 19:51:58','Name','Inserted a new order in ','GeForce GTX 1080','Orders'),(135,'22/05/2017 19:52:14','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(136,'22/05/2017 19:52:23','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(137,'22/05/2017 19:52:32','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(138,'22/05/2017 19:52:53','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(139,'22/05/2017 19:53:02','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(140,'22/05/2017 19:53:10','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(141,'22/05/2017 20:32:36','','Confirmed a new order in ','astas','Orders'),(142,'22/05/2017 20:35:12','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(143,'22/05/2017 20:36:25','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(144,'22/05/2017 20:36:35','','Confirmed a new order in ','astas','Orders'),(145,'22/05/2017 20:36:47','','Confirmed a new order in ','astas','Orders'),(146,'22/05/2017 20:37:12','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(147,'22/05/2017 20:38:03','','Confirmed a new order in ','astas','Orders'),(148,'22/05/2017 20:39:01','','Confirmed a new order in ','astas','Orders'),(149,'22/05/2017 20:39:34','','Confirmed a new order in ','GeForce GTX 1080','Orders'),(150,'23/05/2017 19:33:17','Vanta','Logged In ',' ',' '),(151,'23/05/2017 19:34:33','Vanta','Logged Out ',' ',' '),(152,'23/05/2017 19:34:39','Admin','Logged In ',' ',' '),(153,'29/05/2017 12:24:26','','Inserted a new product in ','2','Products'),(154,'29/05/2017 12:24:36','','Deleted a product  in ','','Products'),(155,'29/05/2017 12:25:06','','Deleted a product  in ','2','Products'),(156,'29/05/2017 12:25:20','','Inserted a new product in ','3','Products'),(157,'29/05/2017 12:25:24','','Deleted a product  in ','','Products'),(158,'29/05/2017 12:26:17','','Deleted a product  in ','3','Products'),(159,'29/05/2017 12:26:34','','Inserted a new product in ','2','Products'),(160,'29/05/2017 12:26:40','','Deleted a product  in ','2','Products'),(161,'29/05/2017 12:26:46','','Inserted a new product in ','1','Products'),(162,'29/05/2017 12:26:57','','Deleted a product  in ','2','Products'),(163,'29/05/2017 18:16:45','Vanta','Logged In ',' ',' '),(164,'29/05/2017 18:17:06','Vanta','Inserted a new product in ','3','Products'),(165,'29/05/2017 18:17:11','Vanta','Deleted a product  in ','3','Products'),(166,'29/05/2017 18:17:13','Vanta','Logged Out ',' ',' '),(167,'29/05/2017 18:17:18','Admin','Logged In ',' ',' '),(168,'29/05/2017 18:17:40','Admin','Logged Out ',' ',' '),(169,'29/05/2017 18:23:54','','Made a report in','','Products'),(170,'29/05/2017 18:25:08','','Made a report in',' ','Products'),(171,'29/05/2017 18:25:55','','Made a report ','  ','Products'),(172,'29/05/2017 18:26:56','','Made a report ','','Products'),(173,'29/05/2017 18:27:23','','Made a report ',' ','Products'),(174,'29/05/2017 18:28:02','MikeM','Logged In ',' ',' '),(175,'29/05/2017 18:28:05','MikeM','Made a report ',' ','Products'),(176,'29/05/2017 18:28:11','MikeM','Logged Out ',' ',' '),(177,'29/05/2017 18:28:16','Admin','Logged In ',' ',' '),(178,'29/05/2017 20:21:49','','Inserted a new product in ','3','Products'),(179,'29/05/2017 20:21:58','','Inserted a new product in ','35','Products'),(180,'29/05/2017 20:33:12','','Made a report ',' ','Products'),(181,'29/05/2017 20:33:52','','Made a report ',' ','Products');
/*!40000 ALTER TABLE `logfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(405) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Supplier` varchar(450) NOT NULL,
  `Employee` varchar(405) NOT NULL,
  `OrderDate` varchar(405) NOT NULL DEFAULT 'Pote egine i paraggelia',
  `DateShipping` varchar(405) NOT NULL DEFAULT 'Pote efige',
  `DatePromised` varchar(405) NOT NULL DEFAULT 'Pote endexetai na erthei',
  `ShippingMethod` varchar(405) NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'GeForce GTX 1080',2,'Nvidia','Admin','1/3/2015 13:22:06','1/3/2015','5/3/2015','Geniki Taxidromiki','Confirmed');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Barcode` varchar(45) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Weight` varchar(45) NOT NULL,
  `Dimentions` varchar(45) NOT NULL,
  `Employee` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Barcode_UNIQUE` (`Barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'1773052','GeForce GTX 1080',36,'1,2 Kg','0.22x0.11 cm','Admin','B2'),(3,'1773194','Omega Centauri Greek - Ενσύρματο Πληκτρολόγιο - Μαύρο',5,'2,3 Kg','43.5x14.5x2.5 cm','Vanta','D4'),(24,'1773198','Omega Centauri Greek - Ενσύρματο Πληκτρολόγιο - Άσπρο',13,'2,3 Kg','43.5x14.5x2.5 cm','Vanta','D4');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SupplierName` varchar(450) NOT NULL,
  `Address` varchar(450) NOT NULL,
  `City` varchar(405) NOT NULL,
  `PostalCode` varchar(405) NOT NULL,
  `Country` varchar(405) NOT NULL,
  `Phone` varchar(405) NOT NULL,
  `Email` varchar(405) NOT NULL,
  `Employee` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Samsung','Leoforos Khfisias 24A','Athens','15125','Greece','80111-7267864','samsungr@market.gr','Admin'),(2,'Plaision','Leoforos Dhmokratias33','Heraklion','71306','Greece','2810-301300','plaisio@newsletter.plaisio.gr','jLabel9');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `First_Last_Name` varchar(45) NOT NULL,
  `ContactPhone` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','add','Admin','Kostas Psixaris','6986541236','kospsix@edu.teicrete.gr'),(2,'MikeM','123456','User','Mixalis Mixalios','6987456321','mikemix@hotmail.com'),(3,'Vanta','199456789','User','Vaggelis Tzavlakis','6980628386','vantas15@hotmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-29 20:38:24
