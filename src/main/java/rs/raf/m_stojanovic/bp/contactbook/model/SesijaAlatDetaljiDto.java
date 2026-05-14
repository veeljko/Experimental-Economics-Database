package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SesijaAlatDetaljiDto {

    public static List<SesijaAlatDetaljiDto> loadBySesijaId(Connection connection, int sesijaId) {
        String query =
                "SELECT " +
                        "a.alat_id, " +
                        "a.tip_alata_id, " +
                        "ta.naziv AS tip_alata, " +
                        "ta.opis AS opis_tipa_alata, " +
                        "a.lab_id, " +
                        "a.identifikacioni_broj, " +
                        "a.verzija, " +
                        "a.datum_nabavke, " +
                        "a.datum_proizvodnje, " +
                        "sa.opis_upotrebe " +
                        "FROM Sesija_Alat sa " +
                        "JOIN Alat a ON sa.alat_id = a.alat_id " +
                        "JOIN Tip_Alata ta ON a.tip_alata_id = ta.tip_alata_id " +
                        "WHERE sa.sesija_id = ? " +
                        "ORDER BY ta.naziv, a.alat_id";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sesijaId);

            ResultSet rs = statement.executeQuery();

            List<SesijaAlatDetaljiDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new SesijaAlatDetaljiDto(
                        rs.getInt("alat_id"),
                        rs.getInt("tip_alata_id"),
                        rs.getString("tip_alata"),
                        rs.getString("opis_tipa_alata"),
                        rs.getInt("lab_id"),
                        rs.getString("identifikacioni_broj"),
                        rs.getString("verzija"),
                        rs.getDate("datum_nabavke"),
                        rs.getDate("datum_proizvodnje"),
                        rs.getString("opis_upotrebe")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int alatId;
    private final int tipAlataId;
    private final String tipAlata;
    private final String opisTipaAlata;
    private final int labId;
    private final String identifikacioniBroj;
    private final String verzija;
    private final Date datumNabavke;
    private final Date datumProizvodnje;
    private final String opisUpotrebe;

    public SesijaAlatDetaljiDto(
            int alatId,
            int tipAlataId,
            String tipAlata,
            String opisTipaAlata,
            int labId,
            String identifikacioniBroj,
            String verzija,
            Date datumNabavke,
            Date datumProizvodnje,
            String opisUpotrebe
    ) {
        this.alatId = alatId;
        this.tipAlataId = tipAlataId;
        this.tipAlata = tipAlata;
        this.opisTipaAlata = opisTipaAlata;
        this.labId = labId;
        this.identifikacioniBroj = identifikacioniBroj;
        this.verzija = verzija;
        this.datumNabavke = datumNabavke;
        this.datumProizvodnje = datumProizvodnje;
        this.opisUpotrebe = opisUpotrebe;
    }

    public int getAlatId() {
        return alatId;
    }

    public int getTipAlataId() {
        return tipAlataId;
    }

    public String getTipAlata() {
        return tipAlata;
    }

    public String getOpisTipaAlata() {
        return opisTipaAlata;
    }

    public int getLabId() {
        return labId;
    }

    public String getIdentifikacioniBroj() {
        return identifikacioniBroj;
    }

    public String getVerzija() {
        return verzija;
    }

    public Date getDatumNabavke() {
        return datumNabavke;
    }

    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public String getOpisUpotrebe() {
        return opisUpotrebe;
    }
}