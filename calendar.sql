-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema 26932668_cal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 26932668_cal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `26932668_cal` DEFAULT CHARACTER SET latin2 ;
USE `26932668_cal` ;

-- -----------------------------------------------------
-- Table `26932668_cal`.`Szkolenie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Szkolenie` (
  `idSzkolenie` INT(11) NOT NULL AUTO_INCREMENT,
  `Nazwa` VARCHAR(45) NULL DEFAULT NULL,
  `Liczba_dni` INT(11) NULL DEFAULT NULL,
  `Typ` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idSzkolenie`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Grupa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Grupa` (
  `idGrupa` INT(11) NOT NULL AUTO_INCREMENT,
  `Akronim` VARCHAR(45) NULL DEFAULT NULL,
  `Data_start` DATE NULL DEFAULT NULL,
  `Szkolenie_idSzkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idGrupa`),
  INDEX `fk_Grupa_Szkolenie_idx` (`Szkolenie_idSzkolenie` ASC),
  CONSTRAINT `fk_Grupa_Szkolenie`
    FOREIGN KEY (`Szkolenie_idSzkolenie`)
    REFERENCES `26932668_cal`.`Szkolenie` (`idSzkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Kolejnosc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Kolejnosc` (
  `idKolejnosc` INT(11) NOT NULL AUTO_INCREMENT,
  `Kolejnosc` VARCHAR(255) NULL DEFAULT NULL,
  `Szkolenie_idSzkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idKolejnosc`),
  INDEX `fk_Kolejnosc_Szkolenie1_idx` (`Szkolenie_idSzkolenie` ASC),
  CONSTRAINT `fk_Kolejnosc_Szkolenie1`
    FOREIGN KEY (`Szkolenie_idSzkolenie`)
    REFERENCES `26932668_cal`.`Szkolenie` (`idSzkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin2
COMMENT = '	';


-- -----------------------------------------------------
-- Table `26932668_cal`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Login` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `Trener_idTrener` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6cetnagnihchjb4qvhi3ndvcb` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Tematy_szkolen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Tematy_szkolen` (
  `idTematy_szkolen` INT(11) NOT NULL AUTO_INCREMENT,
  `Temat` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTematy_szkolen`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Trener` (
  `idTrener` INT(11) NOT NULL AUTO_INCREMENT,
  `Imie` VARCHAR(45) NULL DEFAULT NULL,
  `Nazwisko` VARCHAR(45) NULL DEFAULT NULL,
  `Inicjaly` VARCHAR(5) NULL DEFAULT NULL,
  `Mentor` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idTrener`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Plan` (
  `idPlan` INT(11) NOT NULL,
  `idGrupa` INT(11) NULL DEFAULT NULL,
  `dzien_szkol` INT(11) NULL DEFAULT NULL,
  `Tematy_szkolen_idTematy_szkolen` INT(11) NOT NULL,
  `Trener_idTrener` INT(11) NOT NULL,
  `Szkolenie_idSzkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idPlan`),
  INDEX `fk_Plan_Tematy_szkolen1_idx` (`Tematy_szkolen_idTematy_szkolen` ASC),
  INDEX `fk_Plan_Trener1_idx` (`Trener_idTrener` ASC),
  INDEX `fk_Plan_Szkolenie1_idx` (`Szkolenie_idSzkolenie` ASC),
  CONSTRAINT `fk_Plan_Szkolenie1`
    FOREIGN KEY (`Szkolenie_idSzkolenie`)
    REFERENCES `26932668_cal`.`Szkolenie` (`idSzkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plan_Tematy_szkolen1`
    FOREIGN KEY (`Tematy_szkolen_idTematy_szkolen`)
    REFERENCES `26932668_cal`.`Tematy_szkolen` (`idTematy_szkolen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plan_Trener1`
    FOREIGN KEY (`Trener_idTrener`)
    REFERENCES `26932668_cal`.`Trener` (`idTrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Trener_has_Tematy_szkolen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`Trener_has_Tematy_szkolen` (
  `Trener_idTrener` INT(11) NOT NULL,
  `Tematy_szkolen_idKategoria` INT(11) NOT NULL,
  PRIMARY KEY (`Trener_idTrener`, `Tematy_szkolen_idKategoria`),
  INDEX `fk_Trener_has_Tematy_szkolen_Tematy_szkolen1_idx` (`Tematy_szkolen_idKategoria` ASC),
  INDEX `fk_Trener_has_Tematy_szkolen_Trener1_idx` (`Trener_idTrener` ASC),
  CONSTRAINT `fk_Trener_has_Tematy_szkolen_Tematy_szkolen1`
    FOREIGN KEY (`Tematy_szkolen_idKategoria`)
    REFERENCES `26932668_cal`.`Tematy_szkolen` (`idTematy_szkolen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trener_has_Tematy_szkolen_Trener1`
    FOREIGN KEY (`Trener_idTrener`)
    REFERENCES `26932668_cal`.`Trener` (`idTrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`User` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_587tdsv8u5cvheyo9i261xhry` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin2;


-- -----------------------------------------------------
-- Table `26932668_cal`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `Trener_idTrener` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_login_Trener1_idx` (`Trener_idTrener` ASC),
  CONSTRAINT `fk_login_Trener1`
    FOREIGN KEY (`Trener_idTrener`)
    REFERENCES `26932668_cal`.`Trener` (`idTrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin2;

USE `26932668_cal` ;

-- -----------------------------------------------------
-- Placeholder table for view `26932668_cal`.`trenerzy_tematy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`trenerzy_tematy` (`idTrener` INT, `trener` INT, `Temat` INT);

-- -----------------------------------------------------
-- View `26932668_cal`.`trenerzy_tematy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `26932668_cal`.`trenerzy_tematy`;
USE `26932668_cal`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`26932668_cal`@`%` SQL SECURITY DEFINER VIEW `26932668_cal`.`trenerzy_tematy` AS select `t`.`idTrener` AS `idTrener`,concat(`t`.`Imie`,' ',`t`.`Nazwisko`) AS `trener`,`ts`.`Temat` AS `Temat` from ((`26932668_cal`.`Trener` `t` left join `26932668_cal`.`Trener_has_Tematy_szkolen` `thts` on((`t`.`idTrener` = `thts`.`Trener_idTrener`))) left join `26932668_cal`.`Tematy_szkolen` `ts` on((`thts`.`Tematy_szkolen_idKategoria` = `ts`.`idTematy_szkolen`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
