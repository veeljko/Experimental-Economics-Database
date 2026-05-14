package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IstrazivacDto {

    public static List<IstrazivacDto> loadAll(Connection connection) {
        String query = "SELECT * FROM Istrazivac ORDER BY prezime, ime";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<IstrazivacDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new IstrazivacDto(
                        rs.getInt("istrazivac_id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("institucija"),
                        rs.getString("kvalifikacije"),
                        rs.getString("sposobnosti")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int istrazivacId;
    private final String ime;
    private final String prezime;
    private final String email;
    private final String institucija;
    private final String kvalifikacije;
    private final String sposobnosti;

    public IstrazivacDto(
            int istrazivacId,
            String ime,
            String prezime,
            String email,
            String institucija,
            String kvalifikacije,
            String sposobnosti
    ) {
        this.istrazivacId = istrazivacId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.institucija = institucija;
        this.kvalifikacije = kvalifikacije;
        this.sposobnosti = sposobnosti;
    }

    public int getIstrazivacId() {
        return istrazivacId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getInstitucija() {
        return institucija;
    }

    public String getKvalifikacije() {
        return kvalifikacije;
    }

    public String getSposobnosti() {
        return sposobnosti;
    }
}