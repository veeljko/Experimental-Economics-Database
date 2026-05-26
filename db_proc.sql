USE ekonomija_eksperimenti;

DROP PROCEDURE IF EXISTS zavrsi_sesiju;

DELIMITER $$
--  1. Proveri da li sesija postoji.
--  2. Proveri da li je već završena.
--  3. Ako nije, postavi status_sesije_id = 3.
--  4. Ako su sve sesije tog izvođenja završene, postavi i status_izvodjenja_id = 3.
--  5. Izračuna broj korišćenih resursa i njihovu ukupnu količinu.
--  6. Izračuna broj korišćenih alata.
--  7. Upisuje automatski rezultat u Rezultat_Sesije.
--  8. Potvrđuje izmene transakcijom.
--  Uvodi se kako bi se bezbedno sesija oznacila zavrsenom i upisala u tabelu sa rezultatima.
CREATE PROCEDURE zavrsi_sesiju(
    IN p_sesija_id INT
)
BEGIN
    DECLARE isValid INT DEFAULT 0;
    DECLARE izvodjenjeId INT DEFAULT 0;
    DECLARE cntPreostaloIzvodjenje INT DEFAULT 0;
    DECLARE ukupnoPotrosenihResursa DECIMAL(12,2) DEFAULT 0;
    DECLARE brojPotrosenihResursa INT DEFAULT 0;
    DECLARE brojKoriscenihAlata INT DEFAULT 0;
    DECLARE trenutniStatus INT DEFAULT 0;

START TRANSACTION;

SELECT
    COUNT(*),
    izvodjenje_id,
    status_sesije_id
INTO
    isValid,
    izvodjenjeId,
    trenutniStatus
FROM Sesija
WHERE Sesija.sesija_id = p_sesija_id;

IF isValid = 0 THEN
        ROLLBACK;
SELECT 'Sesija za zadatim ID-jem ne postoji' AS poruka;

ELSEIF trenutniStatus = 3 THEN
        ROLLBACK;
SELECT 'Sesija je vec zavrsena' AS poruka;

ELSE
UPDATE Sesija
SET status_sesije_id = 3
WHERE Sesija.sesija_id = p_sesija_id;

SELECT COUNT(*)
INTO cntPreostaloIzvodjenje
FROM Sesija
WHERE izvodjenje_id = izvodjenjeId
  AND status_sesije_id != 3;

IF cntPreostaloIzvodjenje = 0 THEN
UPDATE Izvodjenje
SET status_izvodjenja_id = 3
WHERE Izvodjenje.izvodjenje_id = izvodjenjeId;
END IF;

SELECT
    COUNT(Sesija_Resurs.resurs_id),
    SUM(Sesija_Resurs.iskoriscena_kolicina)
INTO
    brojPotrosenihResursa,
    ukupnoPotrosenihResursa
FROM Sesija_Resurs
WHERE Sesija_Resurs.sesija_id = p_sesija_id;

SELECT COUNT(Sesija_Alat.alat_id)
INTO brojKoriscenihAlata
FROM Sesija_Alat
WHERE Sesija_Alat.sesija_id = p_sesija_id;

INSERT INTO Rezultat_Sesije(
    sesija_id,
    naziv_metrike,
    vrednost,
    jedinica_mere,
    opis
)
VALUES (
           p_sesija_id,
           'Ukupno iskoriscena kolicina resursa',
           ukupnoPotrosenihResursa,
           'ukupno',
           CONCAT(
                   'Automatski generisan rezultat pri zavrsetku sesije. ',
                   'Broj koriscenih resursa: ', brojPotrosenihResursa,
                   ', broj koriscenih alata: ', brojKoriscenihAlata, '.'
           )
       );

COMMIT;

SELECT 'Sesija je uspesno zavrsena' AS poruka;
END IF;
END $$

DELIMITER ;