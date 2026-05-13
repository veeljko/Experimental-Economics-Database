package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusIzvodjenjaDto {

    public static List<StatusIzvodjenjaDto> loadById(Connection connection, int statusIzvodjenjaId) {
        String query =
                "SELECT " +
                        "status_izvodjenja_id, " +
                        "naziv, " +
                        "opis " +
                        "FROM Status_Izvodjenja " +
                        "WHERE status_izvodjenja_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, statusIzvodjenjaId);

            ResultSet rs = statement.executeQuery();

            List<StatusIzvodjenjaDto> statusIzvodjenjaDtos = new ArrayList<>();

            while (rs.next()) {
                statusIzvodjenjaDtos.add(new StatusIzvodjenjaDto(
                        rs.getInt("status_izvodjenja_id"),
                        rs.getString("naziv"),
                        rs.getString("opis")
                ));
            }

            return statusIzvodjenjaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int statusIzvodjenjaId;
    private final String naziv;
    private final String opis;

    public StatusIzvodjenjaDto(int statusIzvodjenjaId, String naziv, String opis) {
        this.statusIzvodjenjaId = statusIzvodjenjaId;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getStatusIzvodjenjaId() {
        return statusIzvodjenjaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }
}