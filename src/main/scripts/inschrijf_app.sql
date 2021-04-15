-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6226
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for inschrijf_app
CREATE DATABASE IF NOT EXISTS `inschrijf_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `inschrijf_app`;

-- Dumping structure for table inschrijf_app.district
CREATE TABLE IF NOT EXISTS `district` (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(50) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table inschrijf_app.inschrijving
CREATE TABLE IF NOT EXISTS `inschrijving` (
  `inschrijving_id` int(11) NOT NULL AUTO_INCREMENT,
  `gegevens_id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`inschrijving_id`),
  KEY `gegevens_id` (`gegevens_id`,`school_id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `inschrijving_ibfk_1` FOREIGN KEY (`gegevens_id`) REFERENCES `naw_gegevens` (`gegevens_id`),
  CONSTRAINT `inschrijving_ibfk_2` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table inschrijf_app.naw_gegevens
CREATE TABLE IF NOT EXISTS `naw_gegevens` (
  `gegevens_id` int(11) NOT NULL AUTO_INCREMENT,
  `familienaam` varchar(50) NOT NULL,
  `naam` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `id_nummer` varchar(50) NOT NULL,
  `geslacht` varchar(50) NOT NULL,
  `telefoon_nr` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`gegevens_id`),
  UNIQUE KEY `id_nummer` (`id_nummer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table inschrijf_app.school
CREATE TABLE IF NOT EXISTS `school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `niveau_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `naam` varchar(50) NOT NULL,
  `adres` varchar(50) NOT NULL,
  `omschrijving` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`school_id`),
  KEY `niveau_id` (`niveau_id`,`district_id`),
  KEY `district_id` (`district_id`),
  CONSTRAINT `school_ibfk_1` FOREIGN KEY (`niveau_id`) REFERENCES `school_niveau` (`niveau_id`),
  CONSTRAINT `school_ibfk_2` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table inschrijf_app.school_niveau
CREATE TABLE IF NOT EXISTS `school_niveau` (
  `niveau_id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(50) NOT NULL,
  `prijs` decimal(18,2) NOT NULL,
  PRIMARY KEY (`niveau_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
