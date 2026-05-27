USE ekonomija_eksperimenti;

SELECT
    lab.lab_id,
    lab.naziv,
    lab.kapacitet,
    COUNT(DISTINCT i.izvodjenje_id) AS broj_izvodjenja,
    COUNT(DISTINCT s.sesija_id) AS broj_sesija,
    (COUNT(DISTINCT ii.istrazivac_id) + COUNT(DISTINCT di.istrazivac_id)) AS broj_angazovanih_istrazivaca,
    AVG(e.predvidjeni_broj_ucesnika) AS prosecan_broj_ucesnika
FROM Laboratorija lab
 JOIN Izvodjenje i
      ON lab.lab_id = i.lab_id
 JOIN Sesija s
      ON s.izvodjenje_id = i.izvodjenje_id
 JOIN Izvodjenje_Izvodjac ii
      ON ii.izvodjenje_id = i.izvodjenje_id
 JOIN Dizajner_Eksperiment di
      ON di.eksperiment_id = i.eksperiment_id
 JOIN Eksperiment e
      ON e.eksperiment_id = i.eksperiment_id
WHERE lab.kapacitet > 20
GROUP BY
    lab.lab_id
HAVING COUNT(DISTINCT s.sesija_id) > 0
ORDER BY lab.kapacitet DESC;