package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratorijaDto {

    public static List<LaboratorijaDto> loadAll(Connection connection) {
        String query =
                "SELECT " +
                        "lab_id, " +
                        "tip_lab_id, " +
                        "naziv, " +
                        "opis_lokacije, " +
                        "kapacitet, " +
                        "tehnicki_uslovi " +
                        "FROM Laboratorija " +
                        "ORDER BY lab_id";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<LaboratorijaDto> laboratorijaDtos = new ArrayList<>();

            while (rs.next()) {
                laboratorijaDtos.add(createFromResultSet(rs));
            }

            return laboratorijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LaboratorijaDto> loadById(Connection connection, int labId) {
        String query =
                "SELECT " +
                        "lab_id, " +
                        "tip_lab_id, " +
                        "naziv, " +
                        "opis_lokacije, " +
                        "kapacitet, " +
                        "tehnicki_uslovi " +
                        "FROM Laboratorija " +
                        "WHERE lab_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, labId);

            ResultSet rs = statement.executeQuery();

            List<LaboratorijaDto> laboratorijaDtos = new ArrayList<>();

            while (rs.next()) {
                laboratorijaDtos.add(createFromResultSet(rs));
            }

            return laboratorijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LaboratorijaDto> loadBySesijaId(Connection connection, int sesijaId) {
        String query =
                "SELECT " +
                        "l.lab_id, " +
                        "l.tip_lab_id, " +
                        "l.naziv, " +
                        "l.opis_lokacije, " +
                        "l.kapacitet, " +
                        "l.tehnicki_uslovi " +
                        "FROM Sesija s " +
                        "JOIN Izvodjenje i ON s.izvodjenje_id = i.izvodjenje_id " +
                        "JOIN Laboratorija l ON i.lab_id = l.lab_id " +
                        "WHERE s.sesija_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sesijaId);

            ResultSet rs = statement.executeQuery();

            List<LaboratorijaDto> laboratorijaDtos = new ArrayList<>();

            while (rs.next()) {
                laboratorijaDtos.add(createFromResultSet(rs));
            }

            return laboratorijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static LaboratorijaDto createFromResultSet(ResultSet rs) throws SQLException {
        return new LaboratorijaDto(
                rs.getInt("lab_id"),
                rs.getInt("tip_lab_id"),
                rs.getString("naziv"),
                rs.getString("opis_lokacije"),
                rs.getInt("kapacitet"),
                rs.getString("tehnicki_uslovi")
        );
    }

    private final int labId;
    private final int tipLabId;
    private final String naziv;
    private final String opisLokacije;
    private final int kapacitet;
    private final String tehnickiUslovi;

    public LaboratorijaDto(
            int labId,
            int tipLabId,
            String naziv,
            String opisLokacije,
            int kapacitet,
            String tehnickiUslovi
    ) {
        this.labId = labId;
        this.tipLabId = tipLabId;
        this.naziv = naziv;
        this.opisLokacije = opisLokacije;
        this.kapacitet = kapacitet;
        this.tehnickiUslovi = tehnickiUslovi;
    }

    public int getLabId() {
        return labId;
    }

    public int getTipLabId() {
        return tipLabId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpisLokacije() {
        return opisLokacije;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public String getTehnickiUslovi() {
        return tehnickiUslovi;
    }
}