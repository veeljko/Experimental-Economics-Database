package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResursLaboratorijaDto {

    public static List<ResursLaboratorijaDto> loadByLabId(Connection connection, int labId) {
        String query =
                "SELECT " +
                        "r.resurs_id, " +
                        "r.naziv, " +
                        "vr.naziv AS vrsta_resursa, " +
                        "jm.naziv AS jedinica_mere, " +
                        "jm.oznaka AS oznaka_jedinice, " +
                        "r.svojstva, " +
                        "r.kolicina, " +
                        "rl.dostupna_kolicina, " +
                        "srl.naziv AS status_resursa, " +
                        "srl.opis AS opis_statusa " +
                        "FROM Resurs_Laboratorija rl " +
                        "JOIN Resurs r ON rl.resurs_id = r.resurs_id " +
                        "JOIN Vrsta_Resursa vr ON r.vrsta_resursa_id = vr.vrsta_resursa_id " +
                        "JOIN Jedinica_Mere jm ON r.jedinica_mere_id = jm.jedinica_mere_id " +
                        "JOIN Status_Resursa_Laboratorije srl ON rl.status_resursa_id = srl.status_resursa_id " +
                        "WHERE rl.lab_id = ? " +
                        "ORDER BY vr.naziv, r.naziv";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, labId);

            ResultSet rs = statement.executeQuery();

            List<ResursLaboratorijaDto> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new ResursLaboratorijaDto(
                        rs.getInt("resurs_id"),
                        rs.getString("naziv"),
                        rs.getString("vrsta_resursa"),
                        rs.getString("jedinica_mere"),
                        rs.getString("oznaka_jedinice"),
                        rs.getString("svojstva"),
                        rs.getBigDecimal("kolicina"),
                        rs.getBigDecimal("dostupna_kolicina"),
                        rs.getString("status_resursa"),
                        rs.getString("opis_statusa")
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
    private final BigDecimal dostupnaKolicina;
    private final String statusResursa;
    private final String opisStatusa;

    public ResursLaboratorijaDto(
            int resursId,
            String naziv,
            String vrstaResursa,
            String jedinicaMere,
            String oznakaJedinice,
            String svojstva,
            BigDecimal kolicina,
            BigDecimal dostupnaKolicina,
            String statusResursa,
            String opisStatusa
    ) {
        this.resursId = resursId;
        this.naziv = naziv;
        this.vrstaResursa = vrstaResursa;
        this.jedinicaMere = jedinicaMere;
        this.oznakaJedinice = oznakaJedinice;
        this.svojstva = svojstva;
        this.kolicina = kolicina;
        this.dostupnaKolicina = dostupnaKolicina;
        this.statusResursa = statusResursa;
        this.opisStatusa = opisStatusa;
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

    public BigDecimal getDostupnaKolicina() {
        return dostupnaKolicina;
    }

    public String getStatusResursa() {
        return statusResursa;
    }

    public String getOpisStatusa() {
        return opisStatusa;
    }
}