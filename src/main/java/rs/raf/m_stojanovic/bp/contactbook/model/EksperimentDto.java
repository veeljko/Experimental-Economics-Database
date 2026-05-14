package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EksperimentDto {

    public static List<EksperimentDto> loadEksperiment(Connection connection, int izvodjenjeId) {
        String query =
                "SELECT *" +
                        "FROM Eksperiment e " +
                        "JOIN Izvodjenje i ON i.eksperiment_id = e.eksperiment_id " +
                        "WHERE i.izvodjenje_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, izvodjenjeId);

            ResultSet rs = statement.executeQuery();

            List<EksperimentDto> eksperimentDtos = new ArrayList<>();

            while (rs.next()) {
                EksperimentDto eksperimentDto = createFromResultSet(rs);
                eksperimentDtos.add(eksperimentDto);
            }

            return eksperimentDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<EksperimentDto> loadAll(Connection connection) {
        String query =
                "SELECT * FROM Eksperiment";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<EksperimentDto> eksperimentDtos = new ArrayList<>();

            while (rs.next()) {
                EksperimentDto eksperimentDto = createFromResultSet(rs);
                eksperimentDtos.add(eksperimentDto);
            }

            return eksperimentDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static EksperimentDto createFromResultSet(ResultSet rs) throws SQLException {
        int eksperimentId = rs.getInt("eksperiment_id");
        String naziv = rs.getString("naziv");
        String opis = rs.getString("opis");
        String ciljIstrazivanja = rs.getString("cilj_istrazivanja");
        int predvidjeniBrojUcesnika = rs.getInt("predvidjeni_broj_ucesnika");
        BigDecimal budzet = rs.getBigDecimal("budzet");
        int valutaBudzetaId = rs.getInt("valuta_budzeta_id");
        String pravila = rs.getString("pravila");
        String trzisniUslovi = rs.getString("trzisni_uslovi");
        String nacinMerenjaRezultata = rs.getString("nacin_merenja_rezultata");

        return new EksperimentDto(
                eksperimentId,
                naziv,
                opis,
                ciljIstrazivanja,
                predvidjeniBrojUcesnika,
                budzet,
                valutaBudzetaId,
                pravila,
                trzisniUslovi,
                nacinMerenjaRezultata
        );
    }

    public static List<EksperimentDto> loadBySesijaId(Connection connection, int sesijaId) {
        String query =
                "SELECT *" +
                        "FROM Sesija s " +
                        "JOIN Izvodjenje i ON s.izvodjenje_id = i.izvodjenje_id " +
                        "JOIN Eksperiment e ON i.eksperiment_id = e.eksperiment_id " +
                        "WHERE s.sesija_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sesijaId);

            ResultSet rs = statement.executeQuery();

            List<EksperimentDto> eksperimentDtos = new ArrayList<>();

            while (rs.next()) {
                EksperimentDto eksperimentDto = createFromResultSet(rs);
                eksperimentDtos.add(eksperimentDto);
            }

            return eksperimentDtos;
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

    public EksperimentDto(
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