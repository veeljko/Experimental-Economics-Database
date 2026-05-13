package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusSesijeDto {

    public static List<StatusSesijeDto> loadById(Connection connection, int statusSesijeId) {
        String query =
                "SELECT " +
                        "status_sesije_id, " +
                        "naziv, " +
                        "opis " +
                        "FROM Status_Sesije " +
                        "WHERE status_sesije_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, statusSesijeId);

            ResultSet rs = statement.executeQuery();

            List<StatusSesijeDto> statusSesijeDtos = new ArrayList<>();

            while (rs.next()) {
                statusSesijeDtos.add(new StatusSesijeDto(
                        rs.getInt("status_sesije_id"),
                        rs.getString("naziv"),
                        rs.getString("opis")
                ));
            }

            return statusSesijeDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int statusSesijeId;
    private final String naziv;
    private final String opis;

    public StatusSesijeDto(int statusSesijeId, String naziv, String opis) {
        this.statusSesijeId = statusSesijeId;
        this.naziv = naziv;
        this.opis = opis;
    }

    public int getStatusSesijeId() {
        return statusSesijeId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }
}