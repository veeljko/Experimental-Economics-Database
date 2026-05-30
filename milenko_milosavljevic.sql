-- Ovaj upit za svaku ekonomsku teoriju prikazuje: naziv teorije, broj eksperimenata koji koriste tu teoriju,
-- broj izvođenja tih eksperimenata, prosečan budžet eksperimenata, prosečan broj učesnika


USE ekonomija_eksperimenti;

SELECT
    t.teorija_id,
    t.naziv AS teorija,
    COUNT(DISTINCT e.eksperiment_id) AS broj_eksperimenata,
    COUNT(DISTINCT i.izvodjenje_id) AS broj_izvodjenja,
    AVG(e.budzet) AS prosecni_budzet,
    AVG(e.predvidjeni_broj_ucesnika) AS prosecan_broj_ucesnika
FROM Teorija t
         JOIN Eksperiment_Teorija et
              ON t.teorija_id = et.teorija_id
         JOIN Eksperiment e
              ON et.eksperiment_id = e.eksperiment_id
         JOIN Izvodjenje i
              ON e.eksperiment_id = i.eksperiment_id
GROUP BY
    t.teorija_id,
    t.naziv
HAVING COUNT(DISTINCT i.izvodjenje_id) >= 2
ORDER BY prosecni_budzet DESC;