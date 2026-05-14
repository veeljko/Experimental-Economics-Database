
DROP DATABASE IF EXISTS ekonomija_eksperimenti;
CREATE DATABASE ekonomija_eksperimenti;

USE ekonomija_eksperimenti;

-- ============================================================
-- Laboratorije
-- ============================================================

CREATE TABLE Tip_Laboratorije (
                                  tip_lab_id INT AUTO_INCREMENT PRIMARY KEY,
                                  naziv VARCHAR(100) NOT NULL UNIQUE,
                                  opis TEXT
);

CREATE TABLE Laboratorija (
                              lab_id INT AUTO_INCREMENT PRIMARY KEY,
                              tip_lab_id INT NOT NULL,
                              naziv VARCHAR(150) NOT NULL,
                              opis_lokacije TEXT,
                              kapacitet INT NOT NULL,
                              tehnicki_uslovi TEXT,
                              CHECK (kapacitet > 0),
                              FOREIGN KEY (tip_lab_id)
                                  REFERENCES Tip_Laboratorije(tip_lab_id)
                                  ON UPDATE CASCADE
                                  ON DELETE RESTRICT
);

-- ============================================================
-- Resursi
-- ============================================================

CREATE TABLE Vrsta_Resursa (
                               vrsta_resursa_id INT AUTO_INCREMENT PRIMARY KEY,
                               naziv VARCHAR(100) NOT NULL UNIQUE,
                               opis TEXT
);

CREATE TABLE Jedinica_Mere (
                               jedinica_mere_id INT AUTO_INCREMENT PRIMARY KEY,
                               naziv VARCHAR(100) NOT NULL UNIQUE,
                               oznaka VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE Resurs (
                        resurs_id INT AUTO_INCREMENT PRIMARY KEY,
                        vrsta_resursa_id INT NOT NULL,
                        jedinica_mere_id INT NOT NULL,
                        naziv VARCHAR(150) NOT NULL,
                        svojstva TEXT,
                        kolicina DECIMAL(12, 2) NOT NULL DEFAULT 0,
                        CHECK (kolicina >= 0),
                        FOREIGN KEY (vrsta_resursa_id)
                            REFERENCES Vrsta_Resursa(vrsta_resursa_id)
                            ON UPDATE CASCADE
                            ON DELETE RESTRICT,
                        FOREIGN KEY (jedinica_mere_id)
                            REFERENCES Jedinica_Mere(jedinica_mere_id)
                            ON UPDATE CASCADE
                            ON DELETE RESTRICT
);

CREATE TABLE Status_Resursa_Laboratorije (
                                             status_resursa_id INT AUTO_INCREMENT PRIMARY KEY,
                                             naziv VARCHAR(100) NOT NULL UNIQUE,
                                             opis TEXT
);

CREATE TABLE Resurs_Laboratorija (
                                     resurs_id INT NOT NULL,
                                     lab_id INT NOT NULL,
                                     dostupna_kolicina DECIMAL(12, 2) NOT NULL DEFAULT 0,
                                     status_resursa_id INT NOT NULL,

                                     PRIMARY KEY (resurs_id, lab_id),
                                     CHECK (dostupna_kolicina >= 0),
                                     FOREIGN KEY (resurs_id)
                                         REFERENCES Resurs(resurs_id)
                                         ON UPDATE CASCADE
                                         ON DELETE CASCADE,
                                     FOREIGN KEY (lab_id)
                                         REFERENCES Laboratorija(lab_id)
                                         ON UPDATE CASCADE
                                         ON DELETE CASCADE,
                                     FOREIGN KEY (status_resursa_id)
                                         REFERENCES Status_Resursa_Laboratorije(status_resursa_id)
                                         ON UPDATE CASCADE
                                         ON DELETE RESTRICT
);

-- ============================================================
-- Alati
-- ============================================================

CREATE TABLE Tip_Alata (
                           tip_alata_id INT AUTO_INCREMENT PRIMARY KEY,
                           naziv VARCHAR(120) NOT NULL UNIQUE,
                           opis TEXT
);

CREATE TABLE Alat (
                      alat_id INT AUTO_INCREMENT PRIMARY KEY,
                      tip_alata_id INT NOT NULL,
                      lab_id INT NOT NULL,
                      identifikacioni_broj VARCHAR(100) NOT NULL,
                      verzija VARCHAR(50),
                      datum_nabavke DATE NOT NULL,
                      datum_proizvodnje DATE,

                      UNIQUE (identifikacioni_broj),
                      CHECK (datum_proizvodnje IS NULL OR datum_proizvodnje <= datum_nabavke),
                      FOREIGN KEY (tip_alata_id)
                          REFERENCES Tip_Alata(tip_alata_id)
                          ON UPDATE CASCADE
                          ON DELETE RESTRICT,
                      FOREIGN KEY (lab_id)
                          REFERENCES Laboratorija(lab_id)
                          ON UPDATE CASCADE
                          ON DELETE RESTRICT
);

-- ============================================================
-- Istrazivaci i nasledjivanje
-- ============================================================

CREATE TABLE Istrazivac (
                            istrazivac_id INT AUTO_INCREMENT PRIMARY KEY,
                            ime VARCHAR(80) NOT NULL,
                            prezime VARCHAR(80) NOT NULL,
                            email VARCHAR(150) NOT NULL,
                            institucija VARCHAR(150),
                            kvalifikacije TEXT,
                            sposobnosti TEXT,

                            UNIQUE (email)
);

CREATE TABLE Dizajner (
                          istrazivac_id INT PRIMARY KEY,
                          oblast_dizajna VARCHAR(150),
                          napomena TEXT,
                          FOREIGN KEY (istrazivac_id)
                              REFERENCES Istrazivac(istrazivac_id)
                              ON UPDATE CASCADE
                              ON DELETE CASCADE
);

CREATE TABLE Izvodjac (
                          istrazivac_id INT PRIMARY KEY,
                          iskustvo TEXT,
                          napomena TEXT,
                          FOREIGN KEY (istrazivac_id)
                              REFERENCES Istrazivac(istrazivac_id)
                              ON UPDATE CASCADE
                              ON DELETE CASCADE
);

-- ============================================================
-- Teorije, valute i eksperimenti
-- ============================================================

CREATE TABLE Teorija (
                         teorija_id INT AUTO_INCREMENT PRIMARY KEY,
                         naziv VARCHAR(150) NOT NULL,
                         identifikacioni_podaci VARCHAR(200),
                         oblast VARCHAR(150) NOT NULL,
                         opis TEXT
);

CREATE TABLE Valuta (
                        valuta_id INT AUTO_INCREMENT PRIMARY KEY,
                        sifra VARCHAR(10) NOT NULL,
                        naziv VARCHAR(100) NOT NULL,
                        simbol VARCHAR(10),

                        UNIQUE (sifra)
);

CREATE TABLE Eksperiment (
                             eksperiment_id INT AUTO_INCREMENT PRIMARY KEY,
                             naziv VARCHAR(200) NOT NULL,
                             opis TEXT,
                             cilj_istrazivanja TEXT NOT NULL,
                             predvidjeni_broj_ucesnika INT NOT NULL,
                             budzet DECIMAL(14, 2) NOT NULL DEFAULT 0,
                             valuta_budzeta_id INT NOT NULL,
                             pravila TEXT NOT NULL,
                             trzisni_uslovi TEXT,
                             nacin_merenja_rezultata TEXT,
                             CHECK (predvidjeni_broj_ucesnika > 0),
                             CHECK (budzet >= 0),
                             FOREIGN KEY (valuta_budzeta_id)
                                 REFERENCES Valuta(valuta_id)
                                 ON UPDATE CASCADE
                                 ON DELETE RESTRICT
);

CREATE TABLE Eksperiment_Teorija (
                                     eksperiment_id INT NOT NULL,
                                     teorija_id INT NOT NULL,
                                     uloga_teorije TEXT,

                                     PRIMARY KEY (eksperiment_id, teorija_id),
                                     FOREIGN KEY (eksperiment_id)
                                         REFERENCES Eksperiment(eksperiment_id)
                                         ON UPDATE CASCADE
                                         ON DELETE CASCADE,
                                     FOREIGN KEY (teorija_id)
                                         REFERENCES Teorija(teorija_id)
                                         ON UPDATE CASCADE
                                         ON DELETE RESTRICT
);

CREATE TABLE Dizajner_Eksperiment (
                                      istrazivac_id INT NOT NULL,
                                      eksperiment_id INT NOT NULL,
                                      opis_zaduzenja TEXT,

                                      PRIMARY KEY (istrazivac_id, eksperiment_id),
                                      FOREIGN KEY (istrazivac_id)
                                          REFERENCES Dizajner(istrazivac_id)
                                          ON UPDATE CASCADE
                                          ON DELETE RESTRICT,
                                      FOREIGN KEY (eksperiment_id)
                                          REFERENCES Eksperiment(eksperiment_id)
                                          ON UPDATE CASCADE
                                          ON DELETE CASCADE
);

CREATE TABLE Eksperiment_Resurs (
                                    eksperiment_id INT NOT NULL,
                                    resurs_id INT NOT NULL,
                                    potrebna_kolicina DECIMAL(12, 2) NOT NULL,
                                    napomena TEXT,

                                    PRIMARY KEY (eksperiment_id, resurs_id),
                                    CHECK (potrebna_kolicina > 0),
                                    FOREIGN KEY (eksperiment_id)
                                        REFERENCES Eksperiment(eksperiment_id)
                                        ON UPDATE CASCADE
                                        ON DELETE CASCADE,
                                    FOREIGN KEY (resurs_id)
                                        REFERENCES Resurs(resurs_id)
                                        ON UPDATE CASCADE
                                        ON DELETE RESTRICT
);

CREATE TABLE Eksperiment_Tip_Alata (
                                       eksperiment_id INT NOT NULL,
                                       tip_alata_id INT NOT NULL,
                                       broj_potrebnih_alata INT NOT NULL DEFAULT 1,
                                       minimalna_verzija VARCHAR(50),
                                       napomena TEXT,

                                       PRIMARY KEY (eksperiment_id, tip_alata_id),
                                       CHECK (broj_potrebnih_alata > 0),
                                       FOREIGN KEY (eksperiment_id)
                                           REFERENCES Eksperiment(eksperiment_id)
                                           ON UPDATE CASCADE
                                           ON DELETE CASCADE,
                                       FOREIGN KEY (tip_alata_id)
                                           REFERENCES Tip_Alata(tip_alata_id)
                                           ON UPDATE CASCADE
                                           ON DELETE RESTRICT
);

-- ============================================================
-- Izvodjenja
-- ============================================================

CREATE TABLE Status_Izvodjenja (
                                   status_izvodjenja_id INT AUTO_INCREMENT PRIMARY KEY,
                                   naziv VARCHAR(100) NOT NULL UNIQUE,
                                   opis TEXT
);

CREATE TABLE Izvodjenje (
                            izvodjenje_id INT AUTO_INCREMENT PRIMARY KEY,
                            eksperiment_id INT NOT NULL,
                            lab_id INT NOT NULL,
                            datum DATE NOT NULL,
                            status_izvodjenja_id INT NOT NULL,
                            broj_rundi INT NOT NULL,
                            pocetni_kapital_ucesnika DECIMAL(14, 2) NOT NULL DEFAULT 0,
                            valuta_id INT NOT NULL,
                            CHECK (broj_rundi > 0),
                            CHECK (pocetni_kapital_ucesnika >= 0),
                            FOREIGN KEY (eksperiment_id)
                                REFERENCES Eksperiment(eksperiment_id)
                                ON UPDATE CASCADE
                                ON DELETE RESTRICT,
                            FOREIGN KEY (lab_id)
                                REFERENCES Laboratorija(lab_id)
                                ON UPDATE CASCADE
                                ON DELETE RESTRICT,
                            FOREIGN KEY (status_izvodjenja_id)
                                REFERENCES Status_Izvodjenja(status_izvodjenja_id)
                                ON UPDATE CASCADE
                                ON DELETE RESTRICT,
                            FOREIGN KEY (valuta_id)
                                REFERENCES Valuta(valuta_id)
                                ON UPDATE CASCADE
                                ON DELETE RESTRICT
);

CREATE TABLE Izvodjenje_Izvodjac (
                                     izvodjenje_id INT NOT NULL,
                                     istrazivac_id INT NOT NULL,
                                     opis_uloge TEXT,

                                     PRIMARY KEY (izvodjenje_id, istrazivac_id),
                                     FOREIGN KEY (izvodjenje_id)
                                         REFERENCES Izvodjenje(izvodjenje_id)
                                         ON UPDATE CASCADE
                                         ON DELETE CASCADE,
                                     FOREIGN KEY (istrazivac_id)
                                         REFERENCES Izvodjac(istrazivac_id)
                                         ON UPDATE CASCADE
                                         ON DELETE RESTRICT
);

-- ============================================================
-- Sesije
-- ============================================================

CREATE TABLE Tip_Sesije (
                            tip_sesije_id INT AUTO_INCREMENT PRIMARY KEY,
                            naziv VARCHAR(100) NOT NULL UNIQUE,
                            opis TEXT
);

CREATE TABLE Status_Sesije (
                               status_sesije_id INT AUTO_INCREMENT PRIMARY KEY,
                               naziv VARCHAR(100) NOT NULL UNIQUE,
                               opis TEXT
);

CREATE TABLE Sesija (
                        sesija_id INT AUTO_INCREMENT PRIMARY KEY,
                        izvodjenje_id INT NOT NULL,
                        tip_sesije_id INT NOT NULL,
                        status_sesije_id INT NOT NULL,
                        redni_broj INT NOT NULL,
                        datum DATE NOT NULL,
                        vreme_pocetka TIME NOT NULL,
                        vreme_zavrsetka TIME NOT NULL,
                        opis TEXT,

                        UNIQUE (izvodjenje_id, redni_broj),
                        CHECK (redni_broj > 0),
                        CHECK (vreme_pocetka < vreme_zavrsetka),
                        FOREIGN KEY (izvodjenje_id)
                            REFERENCES Izvodjenje(izvodjenje_id)
                            ON UPDATE CASCADE
                            ON DELETE CASCADE,
                        FOREIGN KEY (tip_sesije_id)
                            REFERENCES Tip_Sesije(tip_sesije_id)
                            ON UPDATE CASCADE
                            ON DELETE RESTRICT,
                        FOREIGN KEY (status_sesije_id)
                            REFERENCES Status_Sesije(status_sesije_id)
                            ON UPDATE CASCADE
                            ON DELETE RESTRICT
);

CREATE TABLE Sesija_Resurs (
                               sesija_id INT NOT NULL,
                               resurs_id INT NOT NULL,
                               iskoriscena_kolicina DECIMAL(12, 2) NOT NULL,
                               napomena TEXT,

                               PRIMARY KEY (sesija_id, resurs_id),
                               CHECK (iskoriscena_kolicina >= 0),
                               FOREIGN KEY (sesija_id)
                                   REFERENCES Sesija(sesija_id)
                                   ON UPDATE CASCADE
                                   ON DELETE CASCADE,
                               FOREIGN KEY (resurs_id)
                                   REFERENCES Resurs(resurs_id)
                                   ON UPDATE CASCADE
                                   ON DELETE RESTRICT
);

CREATE TABLE Sesija_Alat (
                             sesija_id INT NOT NULL,
                             alat_id INT NOT NULL,
                             opis_upotrebe TEXT,

                             PRIMARY KEY (sesija_id, alat_id),
                             FOREIGN KEY (sesija_id)
                                 REFERENCES Sesija(sesija_id)
                                 ON UPDATE CASCADE
                                 ON DELETE CASCADE,
                             FOREIGN KEY (alat_id)
                                 REFERENCES Alat(alat_id)
                                 ON UPDATE CASCADE
                                 ON DELETE RESTRICT
);

CREATE TABLE Rezultat_Sesije (
                                 rezultat_id INT AUTO_INCREMENT PRIMARY KEY,
                                 sesija_id INT NOT NULL,
                                 naziv_metrike VARCHAR(150) NOT NULL,
                                 vrednost DECIMAL(14, 4) NOT NULL,
                                 jedinica_mere VARCHAR(50),
                                 opis TEXT,
                                 FOREIGN KEY (sesija_id)
                                     REFERENCES Sesija(sesija_id)
                                     ON UPDATE CASCADE
                                     ON DELETE CASCADE
);

-- ============================================================
-- Indeksi za cesce pretrage
-- ============================================================

-- CREATE INDEX idx_laboratorija_tip
--     ON Laboratorija(tip_lab_id);
--
-- CREATE INDEX idx_resurs_vrsta
--     ON Resurs(vrsta_resursa_id);
--
-- CREATE INDEX idx_alat_lab
--     ON Alat(lab_id);
--
-- CREATE INDEX idx_alat_tip
--     ON Alat(tip_alata_id);
--
-- CREATE INDEX idx_eksperiment_valuta_budzeta
--     ON Eksperiment(valuta_budzeta_id);
--
-- CREATE INDEX idx_izvodjenje_eksperiment
--     ON Izvodjenje(eksperiment_id);
--
-- CREATE INDEX idx_izvodjenje_lab
--     ON Izvodjenje(lab_id);
--
-- CREATE INDEX idx_sesija_izvodjenje
--     ON Sesija(izvodjenje_id);
--
-- CREATE INDEX idx_sesija_datum_vreme
--     ON Sesija(datum, vreme_pocetka, vreme_zavrsetka);
