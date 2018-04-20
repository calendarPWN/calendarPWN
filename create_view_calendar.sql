CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `26932668_cal`@`%` 
    SQL SECURITY DEFINER
VIEW `view_calendar` AS
    SELECT 
        g.akronim AS grupa,
        p.dzien_szkol AS dzien_szkolenia,
        td.db_date AS termin,
        CONCAT(t.Imie, ' ', t.Nazwisko) AS trener,
        ts.temat AS tematyka
    FROM
        grupa AS g
            LEFT JOIN
        plan AS p ON g.idGrupa = p.idGrupa
            LEFT JOIN
        time_dimension AS td ON td.day = (p.dzien_szkol + (SELECT 
                td.day
            FROM
                time_dimension AS td
                    LEFT JOIN
                grupa AS g ON td.db_date = g.data_start
            LIMIT 1))
            LEFT JOIN
        trener AS t ON p.trener_idtrener = idtrener
            LEFT JOIN
        tematy_szkolen AS ts ON ts.idtematy_szkolen = p.tematy_szkolen_idtematy_szkolen;
