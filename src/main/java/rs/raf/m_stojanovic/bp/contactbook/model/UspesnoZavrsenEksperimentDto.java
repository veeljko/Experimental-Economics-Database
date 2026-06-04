package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UspesnoZavrsenEksperimentDto {

    public static List<UspesnoZavrsenEksperimentDto> loadAll(Connection connection) {
        String query =
                "SELECT DISTINCT " +
                        "e.eksperiment_id, " +
                        "e.naziv, " +
                        "e.opis, " +
                        "e.cilj_istrazivanja, " +
                        "e.predvidjeni_broj_ucesnika, " +
                        "e.budzet, " +
                        "e.valuta_budzeta_id, " +
                        "e.pravila, " +
                        "e.trzisni_uslovi, " +
                        "e.nacin_merenja_rezultata " +
                        "FROM Eksperiment e " +
                        "JOIN Izvodjenje i ON i.eksperiment_id = e.eksperiment_id " +
                        "JOIN Status_Izvodjenja si ON si.status_izvodjenja_id = i.status_izvodjenja_id " +
                        "WHERE si.naziv = 'završeno uspešno' " +
                        "ORDER BY e.eksperiment_id";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<UspesnoZavrsenEksperimentDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new UspesnoZavrsenEksperimentDto(
                        rs.getInt("eksperiment_id"),
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getString("cilj_istrazivanja"),
                        rs.getInt("predvidjeni_broj_ucesnika"),
                        rs.getBigDecimal("budzet"),
                        rs.getInt("valuta_budzeta_id"),
                        rs.getString("pravila"),
                        rs.getString("trzisni_uslovi"),
                        rs.getString("nacin_merenja_rezultata")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int eksperimentId;
    private final String naziv;
    private final String opis;
    private final String ciljIstrazivanja;
    private final int predvidjeniBrojUcesnika;
    private final BigDecimal budzet;
    private final int valutaBudzetaId;
    private final String pravila;
    private final String trzisniUslovi;
    private final String nacinMerenjaRezultata;

    public UspesnoZavrsenEksperimentDto(
            int eksperimentId,
            String naziv,
            String opis,
            String ciljIstrazivanja,
            int predvidjeniBrojUcesnika,
            BigDecimal budzet,
            int valutaBudzetaId,
            String pravila,
            String trzisniUslovi,
            String nacinMerenjaRezultata
    ) {
        this.eksperimentId = eksperimentId;
        this.naziv = naziv;
        this.opis = opis;
        this.ciljIstrazivanja = ciljIstrazivanja;
        this.predvidjeniBrojUcesnika = predvidjeniBrojUcesnika;
        this.budzet = budzet;
        this.valutaBudzetaId = valutaBudzetaId;
        this.pravila = pravila;
        this.trzisniUslovi = trzisniUslovi;
        this.nacinMerenjaRezultata = nacinMerenjaRezultata;
    }

    public int getEksperimentId() {
        return eksperimentId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getCiljIstrazivanja() {
        return ciljIstrazivanja;
    }

    public int getPredvidjeniBrojUcesnika() {
        return predvidjeniBrojUcesnika;
    }

    public BigDecimal getBudzet() {
        return budzet;
    }

    public int getValutaBudzetaId() {
        return valutaBudzetaId;
    }

    public String getPravila() {
        return pravila;
    }

    public String getTrzisniUslovi() {
        return trzisniUslovi;
    }

    public String getNacinMerenjaRezultata() {
        return nacinMerenjaRezultata;
    }
}