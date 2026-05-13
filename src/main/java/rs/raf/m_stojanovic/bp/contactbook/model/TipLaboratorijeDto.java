package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipLaboratorijeDto {

    public static List<TipLaboratorijeDto> loadById(Connection connection, int tipLabId) {
        String query =
                "SELECT " +
                        "tip_lab_id, " +
                        "naziv, " +
                        "opis " +
                        "FROM Tip_Laboratorije " +
                        "WHERE tip_lab_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, tipLabId);

            ResultSet rs = statement.executeQuery();

            List<TipLaboratorijeDto> tipLaboratorijeDtos = new ArrayList<>();

            while (rs.next()) {
                tipLaboratorijeDtos.add(new TipLaboratorijeDto(
                        rs.getInt("tip_lab_id"),
                        rs.getString("naziv"),
                        rs.getString("opis")
                ));
            }

            return tipLaboratorijeDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int tipLabId;
    private final String naziv;
    private final String opis;

    public TipLaboratorijeDto(int tipLabId, String naziv, String opis) {
        this.tipLabId = tipLabId;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getTipLabId() {
        return tipLabId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }
}