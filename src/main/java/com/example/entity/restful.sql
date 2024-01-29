-- MySQL Script generated by MySQL Workbench
-- Mon Jan 29 13:50:40 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema inflean_restful
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inflean_restful
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inflean_restful` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `inflean_restful` ;

-- -----------------------------------------------------
-- Table `inflean_restful`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inflean_restful`.`customer` (
  `customer_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `customer_name` VARCHAR(100) NOT NULL,
  `age` INT NULL DEFAULT NULL,
  `rating` VARCHAR(20) NOT NULL,
  `occupation` VARCHAR(20) NULL DEFAULT NULL,
  `reserves` INT NULL DEFAULT '0',
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `inflean_restful`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inflean_restful`.`product` (
  `product_number` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NULL DEFAULT NULL,
  `inventory` INT NULL DEFAULT NULL,
  `price` INT NULL DEFAULT NULL,
  `manufacturer` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`product_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `inflean_restful`.`customer_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inflean_restful`.`customer_product` (
  `order_number` INT NOT NULL AUTO_INCREMENT,
  `customer_id` VARCHAR(50) NULL DEFAULT NULL,
  `product_number` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `order_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_number`),
  INDEX `customer_id` (`customer_id` ASC) VISIBLE,
  INDEX `product_number` (`product_number` ASC) VISIBLE,
  CONSTRAINT `customer_product_ibfk_1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `inflean_restful`.`customer` (`customer_id`),
  CONSTRAINT `customer_product_ibfk_2`
    FOREIGN KEY (`product_number`)
    REFERENCES `inflean_restful`.`product` (`product_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;