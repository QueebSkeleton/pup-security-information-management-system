-- MySQL Script generated by MySQL Workbench
-- Mon Feb  1 17:34:33 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pupsims_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pupsims_db` ;

-- -----------------------------------------------------
-- Schema pupsims_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pupsims_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pupsims_db` ;

-- -----------------------------------------------------
-- Table `pupsims_db`.`attendance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pupsims_db`.`attendance` ;

CREATE TABLE IF NOT EXISTS `pupsims_db`.`attendance` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `security_guard_id` BIGINT NOT NULL,
  `log_date` DATE NOT NULL,
  `work_in` DATETIME NOT NULL,
  `work_out` DATETIME NOT NULL,
  `remarks` VARCHAR(300) NULL,
  `log_status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `pupsims_db`.`violation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pupsims_db`.`violation`;

CREATE TABLE `pupsims_db`.`violation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `violator_name` varchar(100) NOT NULL,
  `violator_address` varchar(200) DEFAULT NULL,
  `violator_contact_number` varchar(30) NOT NULL,
  `violator_company` varchar(100) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  `committed_on` datetime NOT NULL,
  `status` char(10) NOT NULL,
  `violated_law` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `violator_statement` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `pupsims_db`.`inspection`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pupsims_db`.`inspection`;

CREATE TABLE `pupsims_db`.`inspection` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `building_name` varchar(45) NOT NULL,
  `floor_number` int NOT NULL,
  `room_numbers` varchar(90) NOT NULL,
  `general_condition` char(10) NOT NULL,
  `security_guard_id` bigint DEFAULT NULL,
  `date` date NOT NULL,
  `time_started` time NOT NULL,
  `time_finished` time NOT NULL,
  `description` varchar(300) NOT NULL,
  `other_notes` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `pupsims_db`.`inspection`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pupsims_db`.`inspection_issue`;

CREATE TABLE `pupsims_db`.`inspection_issue` (
  `inspection_id` bigint NOT NULL,
  `description` varchar(100) NOT NULL,
  KEY `FK_ISSUE_INSPECTION_idx` (`inspection_id`),
  CONSTRAINT `FK_ISSUE_INSPECTION` FOREIGN KEY (`inspection_id`) REFERENCES `inspection` (`id`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `pupsims_db`.`inventory_of_supplies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pupsims_db`.`inventory_of_supplies`;

CREATE TABLE `pupsims_db`.`inventory_of_supplies` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`product_code` BIGINT NOt NULL,
	`�tem_name` CHARVAR(50) NOT NULL,
	`item_type` CHAR(20),
	`quantity` INT,
	`item_condition` CHAR(15),
	`price` INT,
	PRIMARY KEY (`id`))
-- -----------------------------------------------------
-- Main application user
-- -----------------------------------------------------
DROP USER 'pupsims'@'localhost';
CREATE USER 'pupsims'@'localhost' IDENTIFIED BY 'pupsimspass_123';
GRANT ALL PRIVILEGES ON `pupsims_db`.* TO 'pupsims'@'localhost';