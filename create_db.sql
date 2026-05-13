DROP DATABASE IF EXISTS ekonomija_eksperimenti;
CREATE DATABASE ekonomija_eksperimenti;
USE ekonomija_eksperimenti;

CREATE TABLE Valuta (
    valuta_id INT AUTO_INCREMENT PRIMARY KEY,
    oznaka VARCHAR(10) NOT NULL UNIQUE,
    naziv VARCHAR(100) NOT NULL
);

CREATE TABLE Eksperiment (
    eksperiment_id INT AUTO_INCREMENT PRIMARY KEY,
    valuta_id INT NOT NULL,
    naziv VARCHAR(150) NOT NULL,
    tip_eksperimenta VARCHAR(100),
    opis TEXT,
    broj_ucesnika INT,
    cilj TEXT,
    budzet DECIMAL(12, 2),
    pravila_igre TEXT,

    FOREIGN KEY (valuta_id)
        REFERENCES Valuta(valuta_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Oblast_Teorije (
    oblast_teorije_id INT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(150) NOT NULL,
    opis VARCHAR(200) DEFAULT ''
);

CREATE TABLE Teorija (
    teorija_id INT AUTO_INCREMENT PRIMARY KEY,
    oblast_teorije_id INT NOT NULL,
    naziv VARCHAR(150) NOT NULL,
    identifikacioni_podaci VARCHAR(150),
    opis VARCHAR(200) DEFAULT '',

    FOREIGN KEY (oblast_teorije_id)
        REFERENCES Oblast_Teorije(oblast_teorije_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Istrazivac (
    istrazivac_id INT AUTO_INCREMENT PRIMARY KEY,
    ime VARCHAR(100) NOT NULL,
    prezime VARCHAR(100) NOT NULL,
    kvalifikacije VARCHAR(200) DEFAULT '',
    sposobnosti VARCHAR(200) DEFAULT ''
);

CREATE TABLE Strucna_Oblast (
    strucna_oblast_id INT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(150) NOT NULL,
    opis VARCHAR(200) DEFAULT ''
);

CREATE TABLE Dizajner (
    istrazivac_id INT PRIMARY KEY,
    strucna_oblast_id INT NOT NULL,

    FOREIGN KEY (istrazivac_id)
        REFERENCES Istrazivac(istrazivac_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (strucna_oblast_id)
        REFERENCES Strucna_Oblast(strucna_oblast_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Izvodjac (
    istrazivac_id INT PRIMARY KEY,
    strucna_oblast_id INT NOT NULL,

    FOREIGN KEY (istrazivac_id)
        REFERENCES Istrazivac(istrazivac_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (strucna_oblast_id)
        REFERENCES Strucna_Oblast(strucna_oblast_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Dizajner_Eksperiment (
    istrazivac_id INT NOT NULL,
    eksperiment_id INT NOT NULL,
    teorija_id INT NOT NULL,
    opis_doprinosa VARCHAR(200) DEFAULT '',

    PRIMARY KEY (istrazivac_id, eksperiment_id, teorija_id),

    FOREIGN KEY (istrazivac_id)
        REFERENCES Dizajner(istrazivac_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (eksperiment_id)
        REFERENCES Eksperiment(eksperiment_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (teorija_id)
        REFERENCES Teorija(teorija_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Laboratorija (
    lab_id INT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(150) NOT NULL,
    opis_lokacije VARCHAR(200) DEFAULT '',
    tip_laboratorije VARCHAR(100),
    kapacitet INT,
    tehnicki_uslovi VARCHAR(200) DEFAULT ''
);

CREATE TABLE Istrazivac_Laboratorija (
    istrazivac_id INT NOT NULL,
    lab_id INT NOT NULL,
    datum_od DATE NOT NULL,
    datum_do DATE,
    uloga VARCHAR(100) DEFAULT '',

    PRIMARY KEY (istrazivac_id, lab_id, datum_od),

    FOREIGN KEY (istrazivac_id)
        REFERENCES Istrazivac(istrazivac_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (lab_id)
        REFERENCES Laboratorija(lab_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Jedinica_Mere (
    jedinica_mere_id INT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(100) NOT NULL,
    oznaka VARCHAR(20),
    opis VARCHAR(200) DEFAULT ''
);

CREATE TABLE Resurs (
    resurs_id INT AUTO_INCREMENT PRIMARY KEY,
    jedinica_mere_id INT NOT NULL,
    naziv VARCHAR(150) NOT NULL,
    vrsta_resursa VARCHAR(100),
    svojstva VARCHAR(200) DEFAULT '/',
    kolicina DECIMAL(12, 2),

    FOREIGN KEY (jedinica_mere_id)
        REFERENCES Jedinica_Mere(jedinica_mere_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Resurs_Laboratorija (
    resurs_id INT NOT NULL,
    lab_id INT NOT NULL,
    dostupna_kolicina DECIMAL(12, 2) NOT NULL DEFAULT 0,
    status VARCHAR(100),

    PRIMARY KEY (resurs_id, lab_id),

    FOREIGN KEY (resurs_id)
        REFERENCES Resurs(resurs_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (lab_id)
        REFERENCES Laboratorija(lab_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Resurs_Eksperiment (
    eksperiment_id INT NOT NULL,
    resurs_id INT NOT NULL,
    potrebna_kolicina DECIMAL(12, 2) NOT NULL,
    namena_resursa VARCHAR(150),

    PRIMARY KEY (eksperiment_id, resurs_id),

    FOREIGN KEY (eksperiment_id)
        REFERENCES Eksperiment(eksperiment_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (resurs_id)
        REFERENCES Resurs(resurs_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Tip_Alata (
    tip_id INT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(150) NOT NULL,
    opis VARCHAR(100) DEFAULT '',
    kategorija VARCHAR(100)
);

CREATE TABLE Alat (
    alat_id INT AUTO_INCREMENT PRIMARY KEY,
    tip_id INT NOT NULL,
    lab_id INT NOT NULL,
    naziv_instance VARCHAR(150),
    verzija VARCHAR(50),
    datum_nabavke DATE,
    datum_proizvodnje DATE,
    licenca VARCHAR(100),

    FOREIGN KEY (tip_id)
        REFERENCES Tip_Alata(tip_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    FOREIGN KEY (lab_id)
        REFERENCES Laboratorija(lab_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Eksperiment_Alat (
    eksperiment_id INT NOT NULL,
    alat_id INT NOT NULL,
    namena_alata VARCHAR(150),

    PRIMARY KEY (eksperiment_id, alat_id),

    FOREIGN KEY (eksperiment_id)
        REFERENCES Eksperiment(eksperiment_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (alat_id)
        REFERENCES Alat(alat_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Izvodjenje (
    izvodjenje_id INT AUTO_INCREMENT PRIMARY KEY,
    eksperiment_id INT NOT NULL,
    lab_id INT NOT NULL,
    datum DATE NOT NULL,
    status VARCHAR(100),
    model_trzista VARCHAR(100),
    broj_rundi INT,
    pocetni_kapital DECIMAL(12, 2),
    valuta_simulacije_id INT,

    FOREIGN KEY (eksperiment_id)
        REFERENCES Eksperiment(eksperiment_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (lab_id)
        REFERENCES Laboratorija(lab_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    FOREIGN KEY (valuta_simulacije_id)
        REFERENCES Valuta(valuta_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Izvodjenje_Izvodjac (
    izvodjenje_id INT NOT NULL,
    istrazivac_id INT NOT NULL,
    opis_uloge VARCHAR(200) DEFAULT '',
    putanja_do_beleski VARCHAR(255),

    PRIMARY KEY (izvodjenje_id, istrazivac_id),

    FOREIGN KEY (izvodjenje_id)
        REFERENCES Izvodjenje(izvodjenje_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (istrazivac_id)
        REFERENCES Izvodjac(istrazivac_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Sesija (
    sesija_id INT AUTO_INCREMENT PRIMARY KEY,
    izvodjenje_id INT NOT NULL,
    datum DATE NOT NULL,
    vreme_pocetka TIME NOT NULL,
    vreme_zavrsetka TIME NOT NULL,
    broj_prisutnih_ucesnika INT,
    runda_od INT,
    runda_do INT,

    FOREIGN KEY (izvodjenje_id)
        REFERENCES Izvodjenje(izvodjenje_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CHECK (vreme_zavrsetka > vreme_pocetka)
);

CREATE TABLE Sesija_Resurs (
    sesija_id INT NOT NULL,
    resurs_id INT NOT NULL,
    iskoriscena_kolicina DECIMAL(12, 2) NOT NULL,
    opis_upotrebe VARCHAR(200) DEFAULT '',

    PRIMARY KEY (sesija_id, resurs_id),

    FOREIGN KEY (sesija_id)
        REFERENCES Sesija(sesija_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (resurs_id)
        REFERENCES Resurs(resurs_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Sesija_Alat (
    sesija_id INT NOT NULL,
    alat_id INT NOT NULL,
    status_posle_upotrebe VARCHAR(100),
    napomena VARCHAR(200) DEFAULT '/',

    PRIMARY KEY (sesija_id, alat_id),

    FOREIGN KEY (sesija_id)
        REFERENCES Sesija(sesija_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (alat_id)
        REFERENCES Alat(alat_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);