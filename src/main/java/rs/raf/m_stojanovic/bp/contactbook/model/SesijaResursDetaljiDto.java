package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SesijaResursDetaljiDto {

    public static List<SesijaResursDetaljiDto> loadBySesijaId(Connection connection, int sesijaId) {
        String query =
                "SELECT " +
                        "r.resurs_id, " +
                        "r.naziv, " +
                        "vr.naziv AS vrsta_resursa, " +
                        "jm.naziv AS jedinica_mere, " +
                        "jm.oznaka AS oznaka_jedinice, " +
                        "r.svojstva, " +
                        "r.kolicina, " +
                        "sr.iskoriscena_kolicina, " +
                        "sr.napomena " +
                        "FROM Sesija_Resurs sr " +
                        "JOIN Resurs r ON sr.resurs_id = r.resurs_id " +
                        "JOIN Vrsta_Resursa vr ON r.vrsta_resursa_id = vr.vrsta_resursa_id " +
                        "JOIN Jedinica_Mere jm ON r.jedinica_mere_id = jm.jedinica_mere_id " +
                        "WHERE sr.sesija_id = ? " +
                        "ORDER BY vr.naziv, r.naziv";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sesijaId);

            ResultSet rs = statement.executeQuery();

            List<SesijaResursDetaljiDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new SesijaResursDetaljiDto(
                        rs.getInt("resurs_id"),
                        rs.getString("naziv"),
                        rs.getString("vrsta_resursa"),
                        rs.getString("jedinica_mere"),
                        rs.getString("oznaka_jedinice"),
                        rs.getString("svojstva"),
                        rs.getBigDecimal("kolicina"),
                        rs.getBigDecimal("iskoriscena_kolicina"),
                        rs.getString("napomena")
                ));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int resursId;
    private final String naziv;
    private final String vrstaResursa;
    private final String jedinicaMere;
    private final String oznakaJedinice;
    private final String svojstva;
    private final BigDecimal kolicina;
    private final BigDecimal iskoriscenaKolicina;
    private final String napomena;

    public SesijaResursDetaljiDto(
            int resursId,
            String naziv,
            String vrstaResursa,
            String jedinicaMere,
            String oznakaJedinice,
            String svojstva,
            BigDecimal kolicina,
            BigDecimal iskoriscenaKolicina,
            String napomena
    ) {
        this.resursId = resursId;
        this.naziv = naziv;
        this.vrstaResursa = vrstaResursa;
        this.jedinicaMere = jedinicaMere;
        this.oznakaJedinice = oznakaJedinice;
        this.svojstva = svojstva;
        this.kolicina = kolicina;
        this.iskoriscenaKolicina = iskoriscenaKolicina;
        this.napomena = napomena;
    }

    public int getResursId() {
        return resursId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getVrstaResursa() {
        return vrstaResursa;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public String getOznakaJedinice() {
        return oznakaJedinice;
    }

    public String getSvojstva() {
        return svojstva;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public BigDecimal getIskoriscenaKolicina() {
        return iskoriscenaKolicina;
    }

    public String getNapomena() {
        return napomena;
    }
}