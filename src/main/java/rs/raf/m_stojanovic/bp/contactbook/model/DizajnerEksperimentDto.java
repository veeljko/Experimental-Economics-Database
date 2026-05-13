package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DizajnerEksperimentDto {

    public static List<DizajnerEksperimentDto> loadByEksperimentId(Connection connection, int eksperimentId) {
        String query =
                "SELECT " +
                        "i.istrazivac_id, " +
                        "i.ime, " +
                        "i.prezime, " +
                        "i.email, " +
                        "i.institucija, " +
                        "i.kvalifikacije, " +
                        "i.sposobnosti, " +
                        "d.oblast_dizajna, " +
                        "d.napomena AS napomena_dizajnera, " +
                        "de.opis_zaduzenja " +
                        "FROM Dizajner_Eksperiment de " +
                        "JOIN Dizajner d ON de.istrazivac_id = d.istrazivac_id " +
                        "JOIN Istrazivac i ON d.istrazivac_id = i.istrazivac_id " +
                        "WHERE de.eksperiment_id = ? " +
                        "ORDER BY i.prezime, i.ime";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, eksperimentId);

            ResultSet rs = statement.executeQuery();
            List<DizajnerEksperimentDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new DizajnerEksperimentDto(
                        rs.getInt("istrazivac_id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("institucija"),
                        rs.getString("kvalifikacije"),
                        rs.getString("sposobnosti"),
                        rs.getString("oblast_dizajna"),
                        rs.getString("napomena_dizajnera"),
                        rs.getString("opis_zaduzenja")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int istrazivacId;
    private final String ime;
    private final String prezime;
    private final String email;
    private final String institucija;
    private final String kvalifikacije;
    private final String sposobnosti;
    private final String oblastDizajna;
    private final String napomenaDizajnera;
    private final String opisZaduzenja;

    public DizajnerEksperimentDto(
            int istrazivacId,
            String ime,
            String prezime,
            String email,
            String institucija,
            String kvalifikacije,
            String sposobnosti,
            String oblastDizajna,
            String napomenaDizajnera,
            String opisZaduzenja
    ) {
        this.istrazivacId = istrazivacId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.institucija = institucija;
        this.kvalifikacije = kvalifikacije;
        this.sposobnosti = sposobnosti;
        this.oblastDizajna = oblastDizajna;
        this.napomenaDizajnera = napomenaDizajnera;
        this.opisZaduzenja = opisZaduzenja;
    }

    public int getIstrazivacId() {
        return istrazivacId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getInstitucija() {
        return institucija;
    }

    public String getKvalifikacije() {
        return kvalifikacije;
    }

    public String getSposobnosti() {
        return sposobnosti;
    }

    public String getOblastDizajna() {
        return oblastDizajna;
    }

    public String getNapomenaDizajnera() {
        return napomenaDizajnera;
    }

    public String getOpisZaduzenja() {
        return opisZaduzenja;
    }
}