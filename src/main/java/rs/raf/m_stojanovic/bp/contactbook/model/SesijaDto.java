package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SesijaDto {

    public static List<SesijaDto> readAll(Connection connection) {
        String query =
                "SELECT " +
                        "sesija_id, " +
                        "izvodjenje_id, " +
                        "tip_sesije_id, " +
                        "status_sesije_id, " +
                        "redni_broj, " +
                        "datum, " +
                        "vreme_pocetka, " +
                        "vreme_zavrsetka, " +
                        "opis " +
                        "FROM Sesija";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<SesijaDto> sesijaDtos = new ArrayList<>();

            while (rs.next()) {
                SesijaDto sesijaDto = createFromResultSet(rs);
                sesijaDtos.add(sesijaDto);
            }

            return sesijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SesijaDto> readByEksperimentId(Connection connection, int eksperimentId) {
        String query =
                "SELECT " +
                        "s.sesija_id, " +
                        "s.izvodjenje_id, " +
                        "s.tip_sesije_id, " +
                        "s.status_sesije_id, " +
                        "s.redni_broj, " +
                        "s.datum, " +
                        "s.vreme_pocetka, " +
                        "s.vreme_zavrsetka, " +
                        "s.opis " +
                        "FROM Sesija s " +
                        "JOIN Izvodjenje i ON s.izvodjenje_id = i.izvodjenje_id " +
                        "WHERE i.eksperiment_id = ? " +
                        "ORDER BY s.datum, s.vreme_pocetka";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, eksperimentId);

            ResultSet rs = statement.executeQuery();

            List<SesijaDto> sesijaDtos = new ArrayList<>();

            while (rs.next()) {
                SesijaDto sesijaDto = createFromResultSet(rs);
                sesijaDtos.add(sesijaDto);
            }

            return sesijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static SesijaDto createFromResultSet(ResultSet rs) throws SQLException {
        int sesijaId = rs.getInt("sesija_id");
        int izvodjenjeId = rs.getInt("izvodjenje_id");
        int tipSesijeId = rs.getInt("tip_sesije_id");
        int statusSesijeId = rs.getInt("status_sesije_id");
        int redniBroj = rs.getInt("redni_broj");
        Date datum = rs.getDate("datum");
        Time vremePocetka = rs.getTime("vreme_pocetka");
        Time vremeZavrsetka = rs.getTime("vreme_zavrsetka");
        String opis = rs.getString("opis");

        return new SesijaDto(
                sesijaId,
                izvodjenjeId,
                tipSesijeId,
                statusSesijeId,
                redniBroj,
                datum,
                vremePocetka,
                vremeZavrsetka,
                opis
        );
    }

    private final int sesijaId;
    private final int izvodjenjeId;
    private final int tipSesijeId;
    private final int statusSesijeId;
    private final int redniBroj;
    private final Date datum;
    private final Time vremePocetka;
    private final Time vremeZavrsetka;
    private final String opis;

    public SesijaDto(
            int sesijaId,
            int izvodjenjeId,
            int tipSesijeId,
            int statusSesijeId,
            int redniBroj,
            Date datum,
            Time vremePocetka,
            Time vremeZavrsetka,
            String opis
    ) {
        this.sesijaId = sesijaId;
        this.izvodjenjeId = izvodjenjeId;
        this.tipSesijeId = tipSesijeId;
        this.statusSesijeId = statusSesijeId;
        this.redniBroj = redniBroj;
        this.datum = datum;
        this.vremePocetka = vremePocetka;
        this.vremeZavrsetka = vremeZavrsetka;
        this.opis = opis;
    }

    public int getSesijaId() {
        return sesijaId;
    }

    public int getIzvodjenjeId() {
        return izvodjenjeId;
    }

    public int getTipSesijeId() {
        return tipSesijeId;
    }

    public int getStatusSesijeId() {
        return statusSesijeId;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public Date getDatum() {
        return datum;
    }

    public Time getVremePocetka() {
        return vremePocetka;
    }

    public Time getVremeZavrsetka() {
        return vremeZavrsetka;
    }

    public String getOpis() {
        return opis;
    }
}