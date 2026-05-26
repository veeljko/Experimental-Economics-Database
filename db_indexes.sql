USE ekonomija_eksperimenti;

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Nema smisla da bude klasterovan, sluzi za "obrnutu" pretragu
-- 3) Ubrzava prikaz dizajnera za izabrani eksperiment.
CREATE INDEX idx_dizajner_eksperiment_eksperiment_istrazivac
ON Dizajner_Eksperiment(eksperiment_id, istrazivac_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Slicno kao prethodni indeks, vec imamo PK (izvodjenje_id, istrazivac_id), ovaj indeks samo pokriva drugi smer
-- 3) Ubrzava prikaz svih izvodjenja za izabranog istrazivaca.
CREATE INDEX idx_izvodjenje_izvodjac_istrazivac_izvodjenje
ON Izvodjenje_Izvodjac(istrazivac_id, izvodjenje_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Izvodjenje je prirodnije da se identifikuje preko njegovog id-ja, klasterovanje bi pogorsalo druge upite.
-- 3) Ubrzava pronalaženje izvođenja za dati eksperiment.
CREATE INDEX idx_izvodjenje_eksperiment_id
ON Izvodjenje(eksperiment_id, izvodjenje_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Izvodjenje je prirodnije da se identifikuje preko njegovog id-ja, klasterovanje bi pogorsalo druge upite.
-- 3) Koristan je za ispis svih izvodjenja za neku laboratoriju.
CREATE INDEX idx_izvodjenje_lab_id
ON Izvodjenje(lab_id, izvodjenje_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Ime i prezime nisu dovoljni za identifikaciju, pa samim tim, ne bi trebalo da bude klasterovan
-- 3) Brza provera da li postoji istrazivac sa zadatim imenom, ili zadatim imenom i prezimenom
CREATE INDEX idx_istrazivac_ime_prezime
ON Istrazivac(ime, prezime);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Ovaj indeks bi mogao da bude klasterovan, ako cesto listamo sesije po datumu i/ili vremenu,
-- ali zbog spajanja sa drugim tabelama, ipak ga ne bih klasterovao
-- 3) Brza provera za listanje sesija u zadatom datumu, datumu i vremenu pocetka ili datumu i izmedju nekog intervala
CREATE INDEX idx_sesija_datum_vreme
ON Sesija(datum, vreme_pocetka, vreme_zavrsetka);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Koristan za pretragu alata u laboratoriji, ali nije dovoljno univerzalan da odredjuje fizicki redosled tabele
-- 3) Brza provera dostupnih alata u laboratoriji, po tipu alata.
CREATE INDEX idx_alat_lab_tip
ON Alat(lab_id, tip_alata_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Nema smisla klasterovati tabelu po valuti i budzetu.
-- 3) Koristan za izveštaje tipa “eksperimenti u određenoj valuti” ili sortiranje/filtriranje po budžetu.
CREATE INDEX idx_eksperiment_valuta_budzet
ON Eksperiment(valuta_budzeta_id, budzet);

-- 1) Kreiran je uz pomoc BITMAP jer tip_sesije_id ima samo nekoliko vrednosti
-- 2) tip_sesije_id nije dovoljno dobar identifikator da bude klasterovan
-- 3) Ispis sesija po njenom tipu
CREATE INDEX idx_sesija_tip
ON Sesija(tip_sesije_id);

-- 1) Kreiran je uz pomoc BTREE jer kolone, nad kojima se pravi indeks, mogu da imaju puno redova
-- 2) Naziv eksperimenta nije zasigurno najbolji identifikator, pa je bolje da ne bude klasterovan
-- 3) Provera da li postoji eksperiment u bazi, na osnovu njegovog naziva
CREATE INDEX idx_eksperiment_naziv
ON Eksperiment(naziv);

