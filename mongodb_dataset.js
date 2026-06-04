// ============================================================
// MongoDB seed fajl za detaljne rezultate eksperimenata
// Baza: ekonomija_eksperimenti_mongo
// Kolekcija: eksperiment_detaljni_rezultati
// ============================================================

db = db.getSiblingDB("ekonomija_eksperimenti_mongo");

db.eksperiment_detaljni_rezultati.createIndex(
    { eksperiment_id: 1 },
    { unique: true }
);

// ============================================================
// 1. Detaljni rezultati za test eksperimente 141-150
// ============================================================

db.eksperiment_detaljni_rezultati.bulkWrite([
    {
        updateOne: {
            filter: { eksperiment_id: 141 },
            update: {
                $set: {
                    eksperiment_id: 141,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 1 - aukcija polovnih telefona",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 4,
                        ukupan_broj_ucesnika: 40,
                        broj_rundi: 6,
                        prosecna_transakciona_cena: 428.75,
                        medijalna_transakciona_cena: 415.00,
                        broj_uspesnih_transakcija: 86,
                        stopa_uspesnih_transakcija_procenat: 78.2,
                        prosecni_profit_kupaca: 96.40,
                        prosecni_profit_prodavaca: 88.15,
                        trzisna_efikasnost_procenat: 84.7
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Učesnici su u početnim rundama davali konzervativne ponude, ali su se kroz ponavljanje aukcije postepeno približavali realnijim procenama vrednosti telefona.",
                        dominantne_strategije: [
                            "postepeno povećavanje ponude u kasnijim rundama",
                            "čekanje da drugi učesnici prvi otkriju raspon cena",
                            "izbegavanje previsokih ponuda kada postoji neizvesnost o kvalitetu robe"
                        ],
                        zakljucak: "Rezultati ukazuju da se tržišna efikasnost povećava kroz ponovljene aukcijske runde, jer učesnici uče iz prethodnih ishoda."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Svi učesnici su završili eksperiment, a podaci iz svih rundi su validni."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 142 },
            update: {
                $set: {
                    eksperiment_id: 142,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 2 - igra javnog dobra",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 3,
                        ukupan_broj_ucesnika: 36,
                        broj_rundi: 5,
                        prosecni_doprinos_javnom_dobru: 42.6,
                        medijalni_doprinos: 40.0,
                        ukupan_doprinos: 1533.6,
                        prosecna_individualna_isplata: 74.25,
                        stopa_kooperacije_procenat: 61.8,
                        pad_doprinosa_po_rundama_procenat: 12.4,
                        efikasnost_grupe_procenat: 76.3
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Većina učesnika je u prvim rundama pokazala spremnost na saradnju, ali se kod dela grupa primećuje pad doprinosa nakon što su uočili da drugi učesnici ulažu manje.",
                        dominantne_strategije: [
                            "početno visoko ulaganje radi testiranja ponašanja grupe",
                            "smanjivanje doprinosa nakon niske saradnje drugih članova",
                            "stabilna saradnja u grupama sa visokim početnim doprinosom"
                        ],
                        zakljucak: "Eksperiment potvrđuje prisustvo uslovne kooperacije: učesnici su spremni da sarađuju dok veruju da i drugi članovi grupe doprinose."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Nije bilo prekida tokom sesija; ankete posle igre su kompletirane."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 143 },
            update: {
                $set: {
                    eksperiment_id: 143,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 3 - simulacija potražnje za kafom",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 5,
                        ukupan_broj_ucesnika: 48,
                        broj_rundi: 8,
                        prosecna_cena_pre_soka: 132.40,
                        prosecna_cena_posle_soka: 158.90,
                        rast_cene_procenat: 20.02,
                        prosecni_profit_prodavaca: 312.75,
                        prosecni_visak_kupaca: 184.30,
                        broj_neuspesnih_kupovina: 37,
                        trzisna_efikasnost_procenat: 81.5
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Prodavci su brzo reagovali na rast potražnje povećanjem cena, ali su kasnije korigovali cene kada su primetili smanjenje broja kupovina.",
                        dominantne_strategije: [
                            "povećanje cena odmah nakon šoka potražnje",
                            "testiranje maksimalne spremnosti kupaca da plate",
                            "postepena korekcija cena kada se smanji broj transakcija"
                        ],
                        zakljucak: "Učesnici u ulozi prodavaca pokazuju sposobnost adaptacije na promene potražnje, ali u početku često precenjuju tržišnu moć."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "srednje visok",
                        tehnicki_problemi: false,
                        napomena: "Kod manjeg broja učesnika primećeno je kašnjenje u donošenju odluka, ali bez uticaja na validnost rezultata."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 144 },
            update: {
                $set: {
                    eksperiment_id: 144,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 4 - pregovaranje o budžetu",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 2,
                        ukupan_broj_ucesnika: 32,
                        broj_parova: 16,
                        broj_uspesnih_dogovora: 13,
                        procenat_uspesnih_dogovora: 81.25,
                        prosecno_vreme_do_dogovora_sekundi: 174,
                        prosecna_ponuda_predlagaca: 54.8,
                        prosecna_prihvacena_ponuda: 51.2,
                        broj_neuspesnih_pregovora: 3,
                        indeks_pravicnosti: 0.86
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Učesnici su uglavnom težili ravnomernoj raspodeli budžeta, naročito kada je vreme pregovora bilo duže. Pod vremenskim pritiskom ponude su bile manje stabilne.",
                        dominantne_strategije: [
                            "brzo predlaganje približno jednake podele",
                            "odlaganje konačne ponude do kraja vremena",
                            "korišćenje pretnje odbijanjem radi dobijanja boljeg udela"
                        ],
                        zakljucak: "Vremenski pritisak povećava verovatnoću neuspešnog dogovora, ali ne eliminiše normu pravične raspodele."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Svi parovi su imali jednake uslove i isti vremenski limit."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 145 },
            update: {
                $set: {
                    eksperiment_id: 145,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 5 - tržište sa kuponima",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 4,
                        ukupan_broj_ucesnika: 50,
                        broj_rundi: 6,
                        broj_podeljenih_kupona: 180,
                        broj_iskoriscenih_kupona: 126,
                        stopa_koriscenja_kupona_procenat: 70.0,
                        prosecna_potrosnja_bez_kupona: 214.50,
                        prosecna_potrosnja_sa_kuponom: 278.30,
                        rast_potrosnje_procenat: 29.74,
                        prosecna_cena_posle_popusta: 91.20
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Kuponi su povećali verovatnoću kupovine, posebno kod učesnika koji su u kontrolnim rundama pokazivali nižu spremnost na potrošnju.",
                        dominantne_strategije: [
                            "čuvanje kupona za skuplje proizvode",
                            "kupovina ranije nego što je prvobitno planirano",
                            "kombinovanje kupona sa izborom jeftinijih proizvoda"
                        ],
                        zakljucak: "Kuponi ne utiču samo na ukupnu potrošnju, već značajno menjaju vreme kupovine i percepciju vrednosti proizvoda."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Učesnici su jasno razlikovali kupovine sa kuponom i bez kupona."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 146 },
            update: {
                $set: {
                    eksperiment_id: 146,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 6 - igra poverenja",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 3,
                        ukupan_broj_ucesnika: 44,
                        broj_parova: 22,
                        prosecno_poslato_sredstava: 46.7,
                        prosecno_vraceno_sredstava: 31.4,
                        stopa_reciprociteta_procenat: 67.2,
                        prosecni_profit_posiljalaca: 88.6,
                        prosecni_profit_primalaca: 104.3,
                        broj_potpuno_nekooperativnih_odluka: 5,
                        indeks_poverenja: 0.62
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Pošiljaoci su najčešće slali srednji iznos, dok su primaoci vraćali deo sredstava kada je poslati iznos bio veći od očekivanog.",
                        dominantne_strategije: [
                            "slanje umerenog iznosa radi smanjenja rizika",
                            "vraćanje dela sredstava radi održavanja reputacije",
                            "maksimizacija sopstvenog profita kod manjeg broja primalaca"
                        ],
                        zakljucak: "Rezultati pokazuju da poverenje postoji i u anonimnim uslovima, ali je ograničeno očekivanjem reciprociteta."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Eksperiment je sproveden bez komunikacije između parova."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 147 },
            update: {
                $set: {
                    eksperiment_id: 147,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 7 - Bertrandova konkurencija",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 3,
                        ukupan_broj_ucesnika: 30,
                        broj_rundi: 7,
                        prosecna_cena_prva_runda: 146.30,
                        prosecna_cena_poslednja_runda: 109.80,
                        pad_cene_procenat: 24.95,
                        prosecni_profit_firme: 72.4,
                        minimalna_posmatrana_cena: 98.0,
                        maksimalna_posmatrana_cena: 165.0,
                        indeks_konkurentskog_pritiska: 0.79
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Učesnici su brzo uočili da niža cena povećava tržišni udeo, pa su se cene kroz runde približavale konkurentskom nivou.",
                        dominantne_strategije: [
                            "postepeno snižavanje cena",
                            "kratkoročno testiranje viših cena",
                            "praćenje prethodnih odluka konkurenata"
                        ],
                        zakljucak: "Eksperiment potvrđuje osnovnu intuiciju Bertrandove konkurencije: ponovljeno cenovno takmičenje smanjuje marže."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "srednje visok",
                        tehnicki_problemi: false,
                        napomena: "U jednoj rundi zabeleženo je kašnjenje odluke, ali runda nije isključena iz analize."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 148 },
            update: {
                $set: {
                    eksperiment_id: 148,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 8 - odlučivanje pod rizikom",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 5,
                        ukupan_broj_ucesnika: 60,
                        broj_rundi: 6,
                        procenat_rizicnih_izbora: 38.5,
                        procenat_sigurnih_izbora: 61.5,
                        prosecni_prinos_rizicne_opcije: 142.8,
                        prosecni_prinos_sigurne_opcije: 96.0,
                        prosecni_ostvareni_prinos: 113.7,
                        indeks_averzije_prema_riziku: 0.68,
                        razlika_izbora_po_kapitalu_procenat: 17.3
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Učesnici sa većim početnim kapitalom češće su birali rizične opcije, dok su učesnici sa manjim kapitalom pokazivali veću sklonost sigurnom prinosu.",
                        dominantne_strategije: [
                            "izbor sigurne opcije nakon prethodnog gubitka",
                            "preuzimanje većeg rizika nakon dobitne runde",
                            "kombinovanje sigurnih i rizičnih odluka radi stabilizacije rezultata"
                        ],
                        zakljucak: "Početni kapital utiče na spremnost za preuzimanje rizika, što ukazuje na vezu između osećaja sigurnosti i investicionog ponašanja."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Svi učesnici su prošli probnu rundu pre glavnog dela eksperimenta."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 149 },
            update: {
                $set: {
                    eksperiment_id: 149,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 9 - asimetrija informacija o kvalitetu robe",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 4,
                        ukupan_broj_ucesnika: 42,
                        broj_rundi: 5,
                        prosecna_cena_visokog_kvaliteta: 172.5,
                        prosecna_cena_niskog_kvaliteta: 119.8,
                        udeo_prodate_robe_visokog_kvaliteta_procenat: 43.6,
                        udeo_prodate_robe_niskog_kvaliteta_procenat: 56.4,
                        broj_neuspesnih_transakcija: 28,
                        prosecna_procena_kupaca: 138.2,
                        indeks_asimetrije_informacija: 0.74
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Kupci su bili oprezni kada nisu imali jasan signal kvaliteta, što je dovelo do pada spremnosti da plate višu cenu za potencijalno kvalitetniju robu.",
                        dominantne_strategije: [
                            "snižavanje ponuda zbog neizvesnosti",
                            "prodaja robe nižeg kvaliteta po ceni bliskoj proseku",
                            "oslanjanje na reputacione signale kada su dostupni"
                        ],
                        zakljucak: "Asimetrija informacija smanjuje poverenje kupaca i može dovesti do istiskivanja kvalitetnije robe sa tržišta."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Tretmani sa signalom kvaliteta i bez signala jasno su odvojeni u analizi."
                    }
                }
            },
            upsert: true
        }
    },
    {
        updateOne: {
            filter: { eksperiment_id: 150 },
            update: {
                $set: {
                    eksperiment_id: 150,
                    naziv_eksperimenta: "Test uspešno završeni eksperiment 10 - aukcija reklamnog prostora",
                    tip_rezultata: "detaljni_rezultati_eksperimenta",
                    status_izvodjenja: "završeno uspešno",
                    kvantitativni_rezultati: {
                        broj_sesija: 3,
                        ukupan_broj_ucesnika: 38,
                        broj_rundi: 6,
                        prosecna_zavrsna_cena: 284.6,
                        najvisa_zavrsna_cena: 390.0,
                        najniza_zavrsna_cena: 175.0,
                        prosecni_broj_aktivnih_ponudjaca: 6.3,
                        broj_dodeljenih_slotova: 18,
                        prosecni_profit_pobednika: 126.4,
                        efikasnost_alokacije_procenat: 88.9
                    },
                    kvalitativni_rezultati: {
                        ponasanje_ucesnika: "Veći broj ponuđača doveo je do agresivnijeg licitiranja i viših završnih cena, posebno u rundama sa manjim brojem dostupnih reklamnih slotova.",
                        dominantne_strategije: [
                            "rano podizanje ponude radi odvraćanja konkurenata",
                            "čekanje završne faze runde pre davanja konačne ponude",
                            "fokusiranje na slotove sa većom očekivanom vrednošću"
                        ],
                        zakljucak: "Konkurencija značajno povećava završnu cenu aukcije, ali istovremeno poboljšava efikasnost alokacije reklamnog prostora."
                    },
                    metodoloske_napomene: {
                        kvalitet_podataka: "visok",
                        tehnicki_problemi: false,
                        napomena: "Svi aukcijski logovi su uspešno sačuvani i povezani sa rundama."
                    }
                }
            },
            upsert: true
        }
    }
]);

// ============================================================
// 2. Detaljni rezultati za postojeće uspešno završene eksperimente
// ID-jevi: 99, 93, 87, 81, 75, 69, 63, 57, 51, 45, 39, 33, 27, 21, 15, 9, 3
// ============================================================

const dodatniEksperimenti = [
    { eksperiment_id: 99, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora uz ograničen broj rundi", oblast: "teorija aukcija", ukupan_broj_ucesnika: 32, broj_rundi: 4 },
    { eksperiment_id: 93, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora u okruženju sa jakom konkurencijom", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 40, broj_rundi: 7 },
    { eksperiment_id: 87, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora uz mogućnost anonimne komunikacije", oblast: "teorija aukcija", ukupan_broj_ucesnika: 48, broj_rundi: 10 },
    { eksperiment_id: 81, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora u uslovima visokih transakcionih troškova", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 56, broj_rundi: 4 },
    { eksperiment_id: 75, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora kod ograničenog pristupa informacijama", oblast: "teorija aukcija", ukupan_broj_ucesnika: 64, broj_rundi: 7 },
    { eksperiment_id: 69, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora uz ograničen broj rundi", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 72, broj_rundi: 10 },
    { eksperiment_id: 63, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora u okruženju sa jakom konkurencijom", oblast: "teorija aukcija", ukupan_broj_ucesnika: 24, broj_rundi: 4 },
    { eksperiment_id: 57, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora uz mogućnost anonimne komunikacije", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 32, broj_rundi: 7 },
    { eksperiment_id: 51, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora u uslovima visokih transakcionih troškova", oblast: "teorija aukcija", ukupan_broj_ucesnika: 40, broj_rundi: 10 },
    { eksperiment_id: 45, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora kod ograničenog pristupa informacijama", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 48, broj_rundi: 4 },
    { eksperiment_id: 39, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora uz ograničen broj rundi", oblast: "teorija aukcija", ukupan_broj_ucesnika: 56, broj_rundi: 7 },
    { eksperiment_id: 33, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora u okruženju sa jakom konkurencijom", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 64, broj_rundi: 10 },
    { eksperiment_id: 27, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora uz mogućnost anonimne komunikacije", oblast: "teorija aukcija", ukupan_broj_ucesnika: 72, broj_rundi: 4 },
    { eksperiment_id: 21, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora u uslovima visokih transakcionih troškova", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 24, broj_rundi: 7 },
    { eksperiment_id: 15, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora kod ograničenog pristupa informacijama", oblast: "teorija aukcija", ukupan_broj_ucesnika: 32, broj_rundi: 10 },
    { eksperiment_id: 9, naziv_eksperimenta: "Tržište polovnih dobara na tržištu reklamnog prostora uz ograničen broj rundi", oblast: "informaciona ekonomija", ukupan_broj_ucesnika: 40, broj_rundi: 4 },
    { eksperiment_id: 3, naziv_eksperimenta: "Holandska aukcija na tržištu reklamnog prostora u okruženju sa jakom konkurencijom", oblast: "teorija aukcija", ukupan_broj_ucesnika: 48, broj_rundi: 7 }
];

function napraviDokument(e) {
    const auction = e.naziv_eksperimenta.includes("Holandska aukcija");

    return {
        eksperiment_id: e.eksperiment_id,
        naziv_eksperimenta: e.naziv_eksperimenta,
        tip_rezultata: "detaljni_rezultati_eksperimenta",
        status_izvodjenja: "završeno uspešno",
        oblast: e.oblast,

        kvantitativni_rezultati: auction
            ? {
                broj_sesija: 2 + (e.eksperiment_id % 5),
                ukupan_broj_ucesnika: e.ukupan_broj_ucesnika,
                broj_rundi: e.broj_rundi,
                pocetna_cena: 500 + (e.eksperiment_id % 9) * 25,
                prosecna_prihvacena_cena: 260 + (e.eksperiment_id % 11) * 18,
                najniza_prihvacena_cena: 190 + (e.eksperiment_id % 7) * 12,
                broj_uspesnih_aukcija: 18 + (e.eksperiment_id % 10) * 3,
                prosecno_vreme_do_prihvatanja_sekundi: 42 + (e.eksperiment_id % 8) * 9,
                efikasnost_alokacije_procenat: 76 + (e.eksperiment_id % 18),
                prosecni_profit_pobednika: 85 + (e.eksperiment_id % 13) * 7
            }
            : {
                broj_sesija: 2 + (e.eksperiment_id % 5),
                ukupan_broj_ucesnika: e.ukupan_broj_ucesnika,
                broj_rundi: e.broj_rundi,
                prosecna_cena_visokog_kvaliteta: 170 + (e.eksperiment_id % 10) * 8,
                prosecna_cena_niskog_kvaliteta: 95 + (e.eksperiment_id % 9) * 7,
                udeo_prodate_robe_visokog_kvaliteta_procenat: 35 + (e.eksperiment_id % 20),
                udeo_prodate_robe_niskog_kvaliteta_procenat: 65 - (e.eksperiment_id % 20),
                broj_neuspesnih_transakcija: 10 + (e.eksperiment_id % 12),
                indeks_asimetrije_informacija: Number((0.55 + (e.eksperiment_id % 20) / 100).toFixed(2)),
                prosecna_procena_kupaca: 120 + (e.eksperiment_id % 15) * 6
            },

        kvalitativni_rezultati: auction
            ? {
                ponasanje_ucesnika: "Učesnici su u početnim rundama čekali duže pre prihvatanja cene, dok su se u kasnijim rundama odluke donosile brže zbog boljeg razumevanja dinamike holandske aukcije.",
                dominantne_strategije: [
                    "čekanje niže cene uz rizik da drugi učesnik prvi prihvati ponudu",
                    "brže prihvatanje kada je reklamni prostor procenjen kao vredniji",
                    "prilagođavanje odluke na osnovu ishoda prethodnih rundi"
                ],
                zakljucak: "Rezultati ukazuju da ograničen broj rundi i konkurencija povećavaju pritisak na učesnike da ranije prihvate cenu."
            }
            : {
                ponasanje_ucesnika: "Kupci su pokazali oprez pri kupovini robe čiji kvalitet nije bio potpuno poznat, dok su prodavci često koristili cenu kao signal kvaliteta.",
                dominantne_strategije: [
                    "snižavanje ponuda zbog neizvesnosti o kvalitetu",
                    "oslanjanje na reputacione signale kada postoje",
                    "prodaja robe nižeg kvaliteta po ceni bliskoj prosečnoj tržišnoj ceni"
                ],
                zakljucak: "Eksperiment pokazuje da asimetrija informacija smanjuje poverenje kupaca i može dovesti do manjeg broja transakcija."
            },

        metodoloske_napomene: {
            kvalitet_podataka: e.eksperiment_id % 4 === 0 ? "srednje visok" : "visok",
            tehnicki_problemi: false,
            napomena: "Dokument je povezan sa relacijskom bazom preko polja eksperiment_id. Vrednosti su strukturirane kao kombinacija kvantitativnih metrika i kvalitativnog opisa ponašanja učesnika."
        }
    };
}

db.eksperiment_detaljni_rezultati.bulkWrite(
    dodatniEksperimenti.map(e => ({
        updateOne: {
            filter: { eksperiment_id: e.eksperiment_id },
            update: { $set: napraviDokument(e) },
            upsert: true
        }
    }))
);

// ============================================================
// Provere
// ============================================================

const sviIdjevi = [
    141, 142, 143, 144, 145, 146, 147, 148, 149, 150,
    99, 93, 87, 81, 75, 69, 63, 57, 51, 45, 39, 33, 27, 21, 15, 9, 3
];

print("Ukupan broj dokumenata za tražene eksperimente:");
print(db.eksperiment_detaljni_rezultati.countDocuments({
    eksperiment_id: { $in: sviIdjevi }
}));

print("Pregled ubačenih/ažuriranih dokumenata:");
db.eksperiment_detaljni_rezultati.find(
    { eksperiment_id: { $in: sviIdjevi } },
    { eksperiment_id: 1, naziv_eksperimenta: 1, status_izvodjenja: 1 }
).sort({ eksperiment_id: 1 }).forEach(printjson);