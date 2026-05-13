package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IzvodjenjeDto {

    public static List<IzvodjenjeDto> loadById(Connection connection, int izvodjenjeId) {
        String query =
                "SELECT " +
                        "izvodjenje_id, " +
                        "eksperiment_id, " +
                        "lab_id, " +
                        "datum, " +
                        "status_izvodjenja_id, " +
                        "broj_rundi, " +
                        "pocetni_kapital_ucesnika, " +
                        "valuta_id " +
                        "FROM Izvodjenje " +
                        "WHERE izvodjenje_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, izvodjenjeId);

            ResultSet rs = statement.executeQuery();

            List<IzvodjenjeDto> izvodjenjeDtos = new ArrayList<>();

            while (rs.next()) {
                izvodjenjeDtos.add(new IzvodjenjeDto(
                        rs.getInt("izvodjenje_id"),
                        rs.getInt("eksperiment_id"),
                        rs.getInt("lab_id"),
                        rs.getDate("datum"),
                        rs.getInt("status_izvodjenja_id"),
                        rs.getInt("broj_rundi"),
                        rs.getBigDecimal("pocetni_kapital_ucesnika"),
                        rs.getInt("valuta_id")
                ));
            }

            return izvodjenjeDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int izvodjenjeId;
    private final int eksperimentId;
    private final int labId;
    private final Date datum;
    private final int statusIzvodjenjaId;
    private final int brojRundi;
    private final BigDecimal pocetniKapitalUcesnika;
    private final int valutaId;

    public IzvodjenjeDto(
            int izvodjenjeId,
            int eksperimentId,
            int labId,
            Date datum,
            int statusIzvodjenjaId,
            int brojRundi,
            BigDecimal pocetniKapitalUcesnika,
            int valutaId
    ) {
        this.izvodjenjeId = izvodjenjeId;
        this.eksperimentId = eksperimentId;
        this.labId = labId;
        this.datum = datum;
        this.statusIzvodjenjaId = statusIzvodjenjaId;
        this.brojRundi = brojRundi;
        this.pocetniKapitalUcesnika = pocetniKapitalUcesnika;
        this.valutaId = valutaId;
    }

    public int getIzvodjenjeId() {
        return izvodjenjeId;
    }

    public int getEksperimentId() {
        return eksperimentId;
    }

    public int getLabId() {
        return labId;
    }

    public Date getDatum() {
        return datum;
    }

    public int getStatusIzvodjenjaId() {
        return statusIzvodjenjaId;
    }

    public int getBrojRundi() {
        return brojRundi;
    }

    public BigDecimal getPocetniKapitalUcesnika() {
        return pocetniKapitalUcesnika;
    }

    public int getValutaId() {
        return valutaId;
    }
}