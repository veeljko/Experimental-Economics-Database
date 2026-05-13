package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipAlataEksperimentDto {

    public static List<TipAlataEksperimentDto> loadByEksperimentId(Connection connection, int eksperimentId) {
        String query =
                "SELECT " +
                        "ta.tip_alata_id, " +
                        "ta.naziv, " +
                        "ta.opis, " +
                        "eta.broj_potrebnih_alata, " +
                        "eta.minimalna_verzija, " +
                        "eta.napomena " +
                        "FROM Eksperiment_Tip_Alata eta " +
                        "JOIN Tip_Alata ta ON eta.tip_alata_id = ta.tip_alata_id " +
                        "WHERE eta.eksperiment_id = ? " +
                        "ORDER BY ta.naziv";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, eksperimentId);

            ResultSet rs = statement.executeQuery();
            List<TipAlataEksperimentDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new TipAlataEksperimentDto(
                        rs.getInt("tip_alata_id"),
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getInt("broj_potrebnih_alata"),
                        rs.getString("minimalna_verzija"),
                        rs.getString("napomena")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int tipAlataId;
    private final String naziv;
    private final String opis;
    private final int brojPotrebnihAlata;
    private final String minimalnaVerzija;
    private final String napomena;

    public TipAlataEksperimentDto(
            int tipAlataId,
            String naziv,
            String opis,
            int brojPotrebnihAlata,
            String minimalnaVerzija,
            String napomena
    ) {
        this.tipAlataId = tipAlataId;
        this.naziv = naziv;
        this.opis = opis;
        this.brojPotrebnihAlata = brojPotrebnihAlata;
        this.minimalnaVerzija = minimalnaVerzija;
        this.napomena = napomena;
    }

    public int getTipAlataId() {
        return tipAlataId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public int getBrojPotrebnihAlata() {
        return brojPotrebnihAlata;
    }

    public String getMinimalnaVerzija() {
        return minimalnaVerzija;
    }

    public String getNapomena() {
        return napomena;
    }
}