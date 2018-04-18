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
CREATE SCHEMA IF NOT EXISTS `26932668_cal` DEFAULT CHARACTER SET utf8 ;
USE `26932668_cal` ;

-- -----------------------------------------------------
-- Table `26932668_cal`.`Szkolenie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`szkolenie` (
  `idszkolenie` INT(11) NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(45) NULL DEFAULT NULL,
  `liczba_dni` INT(11) NULL DEFAULT NULL,
  `typ` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idszkolenie`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Grupa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`grupa` (
  `idgrupa` INT(11) NOT NULL AUTO_INCREMENT,
  `akronim` VARCHAR(45) NULL DEFAULT NULL,
  `data_start` DATE NULL DEFAULT NULL,
  `szkolenie_idszkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idgrupa`),
  INDEX `fk_grupa_szkolenie_idx` (`szkolenie_idszkolenie` ASC),
  CONSTRAINT `fk_grupa_szkolenie`
    FOREIGN KEY (`szkolenie_idszkolenie`)
    REFERENCES `26932668_cal`.`szkolenie` (`idszkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Kolejnosc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`kolejnosc` (
  `idkolejnosc` INT(11) NOT NULL AUTO_INCREMENT,
  `kolejnosc` VARCHAR(255) NULL DEFAULT NULL,
  `szkolenie_idszkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idkolejnosc`),
  INDEX `fk_kolejnosc_szkolenie1_idx` (`szkolenie_idszkolenie` ASC),
  CONSTRAINT `fk_kolejnosc_szkolenie1`
    FOREIGN KEY (`szkolenie_idszkolenie`)
    REFERENCES `26932668_cal`.`szkolenie` (`idszkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COMMENT = '	';


-- -----------------------------------------------------
-- Table `26932668_cal`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`login` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `trener_idtrener` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6cetnagnihchjb4qvhi3ndvcb` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Tematy_szkolen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`tematy_szkolen` (
  `idtematy_szkolen` INT(11) NOT NULL AUTO_INCREMENT,
  `temat` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtematy_szkolen`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`trener` (
  `idtrener` INT(11) NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(45) NULL DEFAULT NULL,
  `nazwisko` VARCHAR(45) NULL DEFAULT NULL,
  `inicjaly` VARCHAR(5) NULL DEFAULT NULL,
  `mentor` BOOLEAN NULL DEFAULT NULL,
  PRIMARY KEY (`idtrener`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`plan` (
  `idplan` INT(11) NOT NULL,
  `idgrupa` INT(11) NULL DEFAULT NULL,
  `dzien_szkol` INT(11) NULL DEFAULT NULL,
  `tematy_szkolen_idtematy_szkolen` INT(11) NOT NULL,
  `trener_idtrener` INT(11) NOT NULL,
  `szkolenie_idszkolenie` INT(11) NOT NULL,
  PRIMARY KEY (`idplan`),
  INDEX `fk_plan_tematy_szkolen1_idx` (`tematy_szkolen_idtematy_szkolen` ASC),
  INDEX `fk_plan_trener1_idx` (`trener_idtrener` ASC),
  INDEX `fk_plan_szkolenie1_idx` (`szkolenie_idszkolenie` ASC),
  CONSTRAINT `fk_plan_szkolenie1`
    FOREIGN KEY (`szkolenie_idszkolenie`)
    REFERENCES `26932668_cal`.`szkolenie` (`idszkolenie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_tematy_szkolen1`
    FOREIGN KEY (`tematy_szkolen_idtematy_szkolen`)
    REFERENCES `26932668_cal`.`tematy_szkolen` (`idtematy_szkolen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_trener1`
    FOREIGN KEY (`trener_idtrener`)
    REFERENCES `26932668_cal`.`trener` (`idtrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`Trener_has_Tematy_szkolen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`trener_has_tematy_szkolen` (
  `trener_idtrener` INT(11) NOT NULL,
  `tematy_szkolen_idkategoria` INT(11) NOT NULL,
  PRIMARY KEY (`trener_idtrener`, `tematy_szkolen_idkategoria`),
  INDEX `fk_trener_has_tematy_szkolen_tematy_szkolen1_idx` (`tematy_szkolen_idkategoria` ASC),
  INDEX `fk_trener_has_tematy_szkolen_trener1_idx` (`trener_idtrener` ASC),
  CONSTRAINT `fk_trener_has_tematy_szkolen_tematy_szkolen1`
    FOREIGN KEY (`tematy_szkolen_idkategoria`)
    REFERENCES `26932668_cal`.`tematy_szkolen` (`idtematy_szkolen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener_has_tematy_szkolen_trener1`
    FOREIGN KEY (`trener_idtrener`)
    REFERENCES `26932668_cal`.`trener` (`idtrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `26932668_cal`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `trener_idtrener` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_login_trener1_idx` (`trener_idtrener` ASC),
  CONSTRAINT `fk_login_trener1`
    FOREIGN KEY (`trener_idtrener`)
    REFERENCES `26932668_cal`.`trener` (`idtrener`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

USE `26932668_cal` ;

-- -----------------------------------------------------
-- Placeholder table for view `26932668_cal`.`trenerzy_tematy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `26932668_cal`.`trenerzy_tematy` (`idTrener` INT, `trener` INT, `temat` INT);

-- -----------------------------------------------------
-- View `26932668_cal`.`trenerzy_tematy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `26932668_cal`.`trenerzy_tematy`;
USE `26932668_cal`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`26932668_cal`@`%` SQL SECURITY DEFINER VIEW `26932668_cal`.`trenerzy_tematy` AS select `t`.`idtrener` AS `idtrener`,concat(`t`.`imie`,' ',`t`.`nazwisko`) AS `trener`,`ts`.`temat` AS `temat` from ((`26932668_cal`.`trener` `t` left join `26932668_cal`.`trener_has_tematy_szkolen` `thts` on((`t`.`idtrener` = `thts`.`trener_idtrener`))) left join `26932668_cal`.`tematy_szkolen` `ts` on((`thts`.`tematy_szkolen_idkategoria` = `ts`.`idtematy_szkolen`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
