USE ekonomija_eksperimenti;

-- Ubrzava prikaz dizajnera za izabrani eksperiment.
CREATE INDEX idx_dizajner_eksperiment_eksperiment_istrazivac
ON Dizajner_Eksperiment(eksperiment_id, istrazivac_id);

-- Ubrzava prikaz svih izvodjenja za izabranog istrazivaca.
CREATE INDEX idx_izvodjenje_izvodjac_istrazivac_izvodjenje
ON Izvodjenje_Izvodjac(istrazivac_id, izvodjenje_id);

-- Ubrzava pronalaženje izvođenja za dati eksperiment.
CREATE INDEX idx_izvodjenje_eksperiment_id
ON Izvodjenje(eksperiment_id, izvodjenje_id);

-- Koristan je za ispis svih izvodjenja za neku laboratoriju.
CREATE INDEX idx_izvodjenje_lab_id
ON Izvodjenje(lab_id, izvodjenje_id);

-- Brza provera da li postoji istrazivac sa zadatim imenom, ili zadatim imenom i prezimenom
CREATE INDEX idx_istrazivac_ime_prezime
ON Istrazivac(ime, prezime);

-- Brza provera za listanje sesija u zadatom datumu, datumu i vremenu pocetka ili datumu i izmedju nekog intervala
CREATE INDEX idx_sesija_datum_vreme
ON Sesija(datum, vreme_pocetka, vreme_zavrsetka);

-- Brza provera dostupnih alata u laboratoriji, po tipu alata.
CREATE INDEX idx_alat_lab_tip
ON Alat(lab_id, tip_alata_id);

-- Koristan za izveštaje tipa “eksperimenti u određenoj valuti” ili sortiranje/filtriranje po budžetu.
CREATE INDEX idx_eksperiment_valuta_budzet
ON Eksperiment(valuta_budzeta_id, budzet);

-- Ispis sesija po njenom tipu
CREATE INDEX idx_sesija_tip
ON Sesija(tip_sesije_id);

-- Provera da li postoji eksperiment u bazi, na osnovu njegovog naziva
CREATE INDEX idx_eksperiment_naziv
ON Eksperiment(naziv);

