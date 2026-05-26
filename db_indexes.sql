-- Ubrzava prikaz dizajnera za izabrani eksperiment.
CREATE INDEX idx_dizajner_eksperiment_eksperiment_istrazivac
ON Dizajner_Eksperiment(eksperiment_id, istrazivac_id);

-- Ubrzava prikaz istrazivaca za izabrano izvodjenje.
CREATE INDEX idx_izvodjenje_izvodjac_istrazivac_izvodjenje
ON Izvodjenje_Izvodjac(istrazivac_id, izvodjenje_id);

-- Ubrzava pronalaženje izvođenja za dati eksperiment.
CREATE INDEX idx_izvodjenje_eksperiment_id
ON Izvodjenje(eksperiment_id, izvodjenje_id);

-- Koristan je i za proveru da li laboratorija ima povezana izvođenja pre brisanja.
CREATE INDEX idx_izvodjenje_lab_id
ON Izvodjenje(lab_id, izvodjenje_id);

-- Brza provera da li postoji istrazivac sa zadatim imenom, ili zadatim imenom i prezimenom
CREATE INDEX idx_istrazivac_prezime_ime
ON Istrazivac(ime, prezime);

-- Brza provera za listanje sesija u zadatom datumu, datumu i vremenu pocetka ili datumu i izmedju nekog intervala
CREATE INDEX idx_sesija_datum_vreme
ON Sesija(datum, vreme_pocetka, vreme_zavrsetka);
