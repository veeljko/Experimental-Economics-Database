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

    public static boolean canDelete(Connection connection, int labId) {
        String query =
                "SELECT COUNT(*) AS broj " +
                        "FROM Izvodjenje i " +
                        "JOIN Izvodjenje_Izvodjac ii ON i.izvodjenje_id = ii.izvodjenje_id " +
                        "WHERE i.lab_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, labId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("broj") == 0;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteById(Connection connection, int labId) {
        if (!canDelete(connection, labId)) {
            throw new RuntimeException("Brisanje nije dozvoljeno jer u laboratoriji radi najmanje jedan istraživač.");
        }

        String deleteAlati =
                "DELETE FROM Alat " +
                        "WHERE lab_id = ?";

        String deleteResursiLaboratorije =
                "DELETE FROM Resurs_Laboratorija " +
                        "WHERE lab_id = ?";

        String deleteLaboratorija =
                "DELETE FROM Laboratorija " +
                        "WHERE lab_id = ?";

        try {
            connection.setAutoCommit(false);

            PreparedStatement deleteAlatiStatement = connection.prepareStatement(deleteAlati);
            deleteAlatiStatement.setInt(1, labId);
            deleteAlatiStatement.executeUpdate();

            PreparedStatement deleteResursiStatement = connection.prepareStatement(deleteResursiLaboratorije);
            deleteResursiStatement.setInt(1, labId);
            deleteResursiStatement.executeUpdate();

            PreparedStatement deleteLaboratorijaStatement = connection.prepareStatement(deleteLaboratorija);
            deleteLaboratorijaStatement.setInt(1, labId);

            int rowsAffected = deleteLaboratorijaStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Laboratorija nije pronađena.");
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException rollbackException) {
                throw new RuntimeException(rollbackException);
            }

            throw new RuntimeException(
                    "Laboratorija nije obrisana. Proveri da li postoje izvođenja ili drugi podaci koji još uvek referenciraju ovu laboratoriju."
            );
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