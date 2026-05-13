package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IzvodjenjeIzvodjacDto {

    public static List<IzvodjenjeIzvodjacDto> loadByIstrazivacId(Connection connection, int istrazivacId) {
        String query =
                "SELECT " +
                        "i.izvodjenje_id, " +
                        "i.eksperiment_id, " +
                        "e.naziv AS naziv_eksperimenta, " +
                        "i.lab_id, " +
                        "l.naziv AS naziv_laboratorije, " +
                        "i.datum, " +
                        "i.status_izvodjenja_id, " +
                        "si.naziv AS status_izvodjenja, " +
                        "i.broj_rundi, " +
                        "i.pocetni_kapital_ucesnika, " +
                        "i.valuta_id, " +
                        "v.sifra AS valuta_sifra, " +
                        "ii.opis_uloge " +
                        "FROM Izvodjenje_Izvodjac ii " +
                        "JOIN Izvodjenje i ON ii.izvodjenje_id = i.izvodjenje_id " +
                        "JOIN Eksperiment e ON i.eksperiment_id = e.eksperiment_id " +
                        "JOIN Laboratorija l ON i.lab_id = l.lab_id " +
                        "JOIN Status_Izvodjenja si ON i.status_izvodjenja_id = si.status_izvodjenja_id " +
                        "JOIN Valuta v ON i.valuta_id = v.valuta_id " +
                        "WHERE ii.istrazivac_id = ? " +
                        "ORDER BY i.datum DESC, i.izvodjenje_id";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, istrazivacId);

            ResultSet rs = statement.executeQuery();
            List<IzvodjenjeIzvodjacDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new IzvodjenjeIzvodjacDto(
                        rs.getInt("izvodjenje_id"),
                        rs.getInt("eksperiment_id"),
                        rs.getString("naziv_eksperimenta"),
                        rs.getInt("lab_id"),
                        rs.getString("naziv_laboratorije"),
                        rs.getDate("datum"),
                        rs.getInt("status_izvodjenja_id"),
                        rs.getString("status_izvodjenja"),
                        rs.getInt("broj_rundi"),
                        rs.getBigDecimal("pocetni_kapital_ucesnika"),
                        rs.getInt("valuta_id"),
                        rs.getString("valuta_sifra"),
                        rs.getString("opis_uloge")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int izvodjenjeId;
    private final int eksperimentId;
    private final String nazivEksperimenta;
    private final int labId;
    private final String nazivLaboratorije;
    private final Date datum;
    private final int statusIzvodjenjaId;
    private final String statusIzvodjenja;
    private final int brojRundi;
    private final BigDecimal pocetniKapitalUcesnika;
    private final int valutaId;
    private final String valutaSifra;
    private final String opisUloge;

    public IzvodjenjeIzvodjacDto(
            int izvodjenjeId,
            int eksperimentId,
            String nazivEksperimenta,
            int labId,
            String nazivLaboratorije,
            Date datum,
            int statusIzvodjenjaId,
            String statusIzvodjenja,
            int brojRundi,
            BigDecimal pocetniKapitalUcesnika,
            int valutaId,
            String valutaSifra,
            String opisUloge
    ) {
        this.izvodjenjeId = izvodjenjeId;
        this.eksperimentId = eksperimentId;
        this.nazivEksperimenta = nazivEksperimenta;
        this.labId = labId;
        this.nazivLaboratorije = nazivLaboratorije;
        this.datum = datum;
        this.statusIzvodjenjaId = statusIzvodjenjaId;
        this.statusIzvodjenja = statusIzvodjenja;
        this.brojRundi = brojRundi;
        this.pocetniKapitalUcesnika = pocetniKapitalUcesnika;
        this.valutaId = valutaId;
        this.valutaSifra = valutaSifra;
        this.opisUloge = opisUloge;
    }

    public int getIzvodjenjeId() {
        return izvodjenjeId;
    }

    public int getEksperimentId() {
        return eksperimentId;
    }

    public String getNazivEksperimenta() {
        return nazivEksperimenta;
    }

    public int getLabId() {
        return labId;
    }

    public String getNazivLaboratorije() {
        return nazivLaboratorije;
    }

    public Date getDatum() {
        return datum;
    }

    public int getStatusIzvodjenjaId() {
        return statusIzvodjenjaId;
    }

    public String getStatusIzvodjenja() {
        return statusIzvodjenja;
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

    public String getValutaSifra() {
        return valutaSifra;
    }

    public String getOpisUloge() {
        return opisUloge;
    }
}