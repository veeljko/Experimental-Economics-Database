package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RezultatSesijeDto {

    public static List<RezultatSesijeDto> loadBySesijaId(Connection connection, int sesijaId) {
        String query =
                "SELECT * FROM Rezultat_Sesije WHERE sesija_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sesijaId);

            ResultSet rs = statement.executeQuery();

            List<RezultatSesijeDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new RezultatSesijeDto(
                        rs.getInt("rezultat_id"),
                        rs.getInt("sesija_id"),
                        rs.getString("naziv_metrike"),
                        rs.getBigDecimal("vrednost"),
                        rs.getString("jedinica_mere"),
                        rs.getString("opis")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int rezultatId;
    private final int sesijaId;
    private final String nazivMetrike;
    private final BigDecimal vrednost;
    private final String jedinicaMere;
    private final String opis;

    public RezultatSesijeDto(
            int rezultatId,
            int sesijaId,
            String nazivMetrike,
            BigDecimal vrednost,
            String jedinicaMere,
            String opis
    ) {
        this.rezultatId = rezultatId;
        this.sesijaId = sesijaId;
        this.nazivMetrike = nazivMetrike;
        this.vrednost = vrednost;
        this.jedinicaMere = jedinicaMere;
        this.opis = opis;
    }

    public int getRezultatId() {
        return rezultatId;
    }

    public int getSesijaId() {
        return sesijaId;
    }

    public String getNazivMetrike() {
        return nazivMetrike;
    }

    public BigDecimal getVrednost() {
        return vrednost;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public String getOpis() {
        return opis;
    }
}