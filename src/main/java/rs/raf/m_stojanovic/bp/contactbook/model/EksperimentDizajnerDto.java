package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EksperimentDizajnerDto {

    public static List<EksperimentDizajnerDto> loadByIstrazivacId(Connection connection, int istrazivacId) {
        String query =
                "SELECT " +
                        "e.eksperiment_id, " +
                        "e.naziv, " +
                        "e.opis, " +
                        "e.cilj_istrazivanja, " +
                        "e.predvidjeni_broj_ucesnika, " +
                        "e.budzet, " +
                        "e.valuta_budzeta_id, " +
                        "e.pravila, " +
                        "e.trzisni_uslovi, " +
                        "e.nacin_merenja_rezultata, " +
                        "de.opis_zaduzenja " +
                        "FROM Dizajner_Eksperiment de " +
                        "JOIN Eksperiment e ON de.eksperiment_id = e.eksperiment_id " +
                        "WHERE de.istrazivac_id = ? " +
                        "ORDER BY e.eksperiment_id";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, istrazivacId);

            ResultSet rs = statement.executeQuery();
            List<EksperimentDizajnerDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new EksperimentDizajnerDto(
                        rs.getInt("eksperiment_id"),
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getString("cilj_istrazivanja"),
                        rs.getInt("predvidjeni_broj_ucesnika"),
                        rs.getBigDecimal("budzet"),
                        rs.getInt("valuta_budzeta_id"),
                        rs.getString("pravila"),
                        rs.getString("trzisni_uslovi"),
                        rs.getString("nacin_merenja_rezultata"),
                        rs.getString("opis_zaduzenja")
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
    private final String opisZaduzenja;

    public EksperimentDizajnerDto(
            int eksperimentId,
            String naziv,
            String opis,
            String ciljIstrazivanja,
            int predvidjeniBrojUcesnika,
            BigDecimal budzet,
            int valutaBudzetaId,
            String pravila,
            String trzisniUslovi,
            String nacinMerenjaRezultata,
            String opisZaduzenja
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
        this.opisZaduzenja = opisZaduzenja;
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

    public String getOpisZaduzenja() {
        return opisZaduzenja;
    }
}