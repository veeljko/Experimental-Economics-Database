package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeorijaEksperimentDto {

    public static List<TeorijaEksperimentDto> loadByEksperimentId(Connection connection, int eksperimentId) {
        String query =
                "SELECT * FROM Eksperiment_Teorija et JOIN Teorija t ON et.teorija_id = t.teorija_id WHERE et.eksperiment_id = ? ";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, eksperimentId);

            ResultSet rs = statement.executeQuery();
            List<TeorijaEksperimentDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new TeorijaEksperimentDto(
                        rs.getInt("teorija_id"),
                        rs.getString("naziv"),
                        rs.getString("identifikacioni_podaci"),
                        rs.getString("oblast"),
                        rs.getString("opis"),
                        rs.getString("uloga_teorije")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int teorijaId;
    private final String naziv;
    private final String identifikacioniPodaci;
    private final String oblast;
    private final String opis;
    private final String ulogaTeorije;

    public TeorijaEksperimentDto(
            int teorijaId,
            String naziv,
            String identifikacioniPodaci,
            String oblast,
            String opis,
            String ulogaTeorije
    ) {
        this.teorijaId = teorijaId;
        this.naziv = naziv;
        this.identifikacioniPodaci = identifikacioniPodaci;
        this.oblast = oblast;
        this.opis = opis;
        this.ulogaTeorije = ulogaTeorije;
    }

    public int getTeorijaId() {
        return teorijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getIdentifikacioniPodaci() {
        return identifikacioniPodaci;
    }

    public String getOblast() {
        return oblast;
    }

    public String getOpis() {
        return opis;
    }

    public String getUlogaTeorije() {
        return ulogaTeorije;
    }
}