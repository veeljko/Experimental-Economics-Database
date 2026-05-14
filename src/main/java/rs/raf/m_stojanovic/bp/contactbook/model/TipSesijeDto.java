package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipSesijeDto {

    public static List<TipSesijeDto> loadById(Connection connection, int tipSesijeId) {
        String query =
                "SELECT * FROM Tip_Sesije WHERE tip_sesije_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, tipSesijeId);

            ResultSet rs = statement.executeQuery();

            List<TipSesijeDto> tipSesijeDtos = new ArrayList<>();

            while (rs.next()) {
                tipSesijeDtos.add(new TipSesijeDto(
                        rs.getInt("tip_sesije_id"),
                        rs.getString("naziv"),
                        rs.getString("opis")
                ));
            }

            return tipSesijeDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int tipSesijeId;
    private final String naziv;
    private final String opis;

    public TipSesijeDto(int tipSesijeId, String naziv, String opis) {
        this.tipSesijeId = tipSesijeId;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getTipSesijeId() {
        return tipSesijeId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }
}