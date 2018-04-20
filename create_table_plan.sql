use 26932668_cal;
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