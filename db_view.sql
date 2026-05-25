USE ekonomija_eksperimenti;

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