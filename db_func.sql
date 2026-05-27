USE ekonomija_eksperimenti;

DROP FUNCTION IF EXISTS fn_kategorija_trajanja_sesije;
DROP FUNCTION IF EXISTS test_fn_kategorija_trajanja_sesije;

DELIMITER $$
-- Funkcija na osnovu pocetka i kraja neke sesije, odredjuje njen tip.
-- Kratka, ako traje krace od 60min.
-- Standardna, ako traje od 60min do 180min.
-- Duga, ako traje vise od 180min.
-- Moguce je da funkcija vrati "NEVALIDNO", ako input parametri nisu ispravni.
-- Uvodi se radi lakseg grupisanja po trajanju, bez cestog ponavljanja koda.
CREATE FUNCTION fn_kategorija_trajanja_sesije(
    p_vreme_pocetka TIME
    p_vreme_kraja TIME
)
    RETURNS VARCHAR(20)
    DETERMINISTIC
BEGIN
    DECLARE v_trajanje_minuta INT;

    IF p_vreme_pocetka IS NULL OR p_vreme_kraja IS NULL THEN
        RETURN 'NEVALIDNO';
    END IF;

    IF p_vreme_kraja < p_vreme_pocetka THEN
        RETURN 'NEVALIDNO';
    END IF;

    SET v_trajanje_minuta = TIME_TO_SEC(TIMEDIFF(p_vreme_kraja, p_vreme_pocetka)) / 60;

    IF v_trajanje_minuta < 60 THEN
        RETURN 'KRATKA';
    ELSEIF v_trajanje_minuta <= 180 THEN
        RETURN 'STANDARDNA';
    ELSE
        RETURN 'DUGA';
    END IF;
END $$

CREATE FUNCTION test_fn_kategorija_trajanja_sesije()
    RETURNS BOOLEAN
    DETERMINISTIC
BEGIN
    IF fn_kategorija_trajanja_sesije('10:00:00', '10:30:00') <> 'KRATKA' THEN
        RETURN FALSE;
    END IF;

    IF fn_kategorija_trajanja_sesije('10:00:00', '11:00:00') <> 'STANDARDNA' THEN
        RETURN FALSE;
    END IF;

    IF fn_kategorija_trajanja_sesije('10:00:00', '13:00:00') <> 'STANDARDNA' THEN
        RETURN FALSE;
    END IF;

    IF fn_kategorija_trajanja_sesije('10:00:00', '14:30:00') <> 'DUGA' THEN
        RETURN FALSE;
    END IF;

    IF fn_kategorija_trajanja_sesije('12:00:00', '11:00:00') <> 'NEVALIDNO' THEN
        RETURN FALSE;
    END IF;

    RETURN TRUE;
END $$

DELIMITER ;