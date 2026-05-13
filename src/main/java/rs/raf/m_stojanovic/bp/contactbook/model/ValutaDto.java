package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValutaDto {

    public static List<ValutaDto> loadById(Connection connection, int valutaId) {
        String query =
                "SELECT " +
                        "valuta_id, " +
                        "sifra, " +
                        "naziv, " +
                        "simbol " +
                        "FROM Valuta " +
                        "WHERE valuta_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, valutaId);

            ResultSet rs = statement.executeQuery();

            List<ValutaDto> valutaDtos = new ArrayList<>();

            while (rs.next()) {
                valutaDtos.add(new ValutaDto(
                        rs.getInt("valuta_id"),
                        rs.getString("sifra"),
                        rs.getString("naziv"),
                        rs.getString("simbol")
                ));
            }

            return valutaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int valutaId;
    private final String sifra;
    private final String naziv;
    private final String simbol;

    public ValutaDto(int valutaId, String sifra, String naziv, String simbol) {
        this.valutaId = valutaId;
        this.sifra = sifra;
        this.naziv = naziv;
        this.simbol = simbol;
    }

    public int getValutaId() {
        return valutaId;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getSimbol() {
        return simbol;
    }
}