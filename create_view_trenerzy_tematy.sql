CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `26932668_cal`@`%` 
    SQL SECURITY DEFINER
VIEW `trenerzy_tematy` AS
    SELECT 
        `t`.`idTrener` AS `idTrener`,
        CONCAT(`t`.`Imie`, ' ', `t`.`Nazwisko`) AS `trener`,
        `ts`.`Temat` AS `Temat`
    FROM
        ((`Trener` `t`
        LEFT JOIN `Trener_has_Tematy_szkolen` `thts` ON ((`t`.`idTrener` = `thts`.`Trener_idTrener`)))
        LEFT JOIN `Tematy_szkolen` `ts` ON ((`thts`.`Tematy_szkolen_idKategoria` = `ts`.`idTematy_szkolen`)));
SELECT * FROM 26932668_cal.trenerzy_tematy;