USE ekonomija_eksperimenti;

-- Ovaj view lab_br_resurs_i_alat pravi pregled laboratorija
-- koje imaju bar jedan alat i bar jedan resurs, i za svaku
-- takvu laboratoriju prikazuje koliko ima alata i resursa.
-- Uvodi se za pregled laboratorija koje su stvarno operativne, tj. imaju i alate i resurse.
CREATE VIEW lab_br_resurs_i_alat AS
SELECT
    l.lab_id,
    l.naziv AS laboratorija,
    COUNT(DISTINCT a.alat_id) AS broj_alata,
    COUNT(DISTINCT rl.resurs_id) AS broj_resursa
FROM Laboratorija l
         LEFT JOIN Alat a
                   ON a.lab_id = l.lab_id
         LEFT JOIN Resurs_Laboratorija rl
                   ON rl.lab_id = l.lab_id
GROUP BY
    l.lab_id,
    l.naziv
HAVING
    COUNT(DISTINCT a.alat_id) > 0
   AND COUNT(DISTINCT rl.resurs_id) > 0;