package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SesijaDto {

    public static List<SesijaDto> readAll(Connection connection) {
        String query = "SELECT * FROM Sesija";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<SesijaDto> sesijaDtos = new ArrayList<>();

            while (rs.next()) {
                int sesijaId = rs.getInt("sesija_id");
                int izvodjenjeId = rs.getInt("izvodjenje_id");
                Date datum = rs.getDate("datum");
                Time vremePocetka = rs.getTime("vreme_pocetka");
                Time vremeZavrsetka = rs.getTime("vreme_zavrsetka");
                int brojPrisutnihUcesnika = rs.getInt("broj_prisutnih_ucesnika");
                int rundaOd = rs.getInt("runda_od");
                int rundaDo = rs.getInt("runda_do");

                SesijaDto sesijaDto = new SesijaDto(
                        sesijaId,
                        izvodjenjeId,
                        datum,
                        vremePocetka,
                        vremeZavrsetka,
                        brojPrisutnihUcesnika,
                        rundaOd,
                        rundaDo
                );

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
                        "s.datum, " +
                        "s.vreme_pocetka, " +
                        "s.vreme_zavrsetka, " +
                        "s.broj_prisutnih_ucesnika, " +
                        "s.runda_od, " +
                        "s.runda_do " +
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
                int sesijaId = rs.getInt("sesija_id");
                int izvodjenjeId = rs.getInt("izvodjenje_id");
                Date datum = rs.getDate("datum");
                Time vremePocetka = rs.getTime("vreme_pocetka");
                Time vremeZavrsetka = rs.getTime("vreme_zavrsetka");
                int brojPrisutnihUcesnika = rs.getInt("broj_prisutnih_ucesnika");
                int rundaOd = rs.getInt("runda_od");
                int rundaDo = rs.getInt("runda_do");

                SesijaDto sesijaDto = new SesijaDto(
                        sesijaId,
                        izvodjenjeId,
                        datum,
                        vremePocetka,
                        vremeZavrsetka,
                        brojPrisutnihUcesnika,
                        rundaOd,
                        rundaDo
                );

                sesijaDtos.add(sesijaDto);
            }

            return sesijaDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int sesijaId;
    private final int izvodjenjeId;
    private final Date datum;
    private final Time vremePocetka;
    private final Time vremeZavrsetka;
    private final int brojPrisutnihUcesnika;
    private final int rundaOd;
    private final int rundaDo;

    public SesijaDto(
            int sesijaId,
            int izvodjenjeId,
            Date datum,
            Time vremePocetka,
            Time vremeZavrsetka,
            int brojPrisutnihUcesnika,
            int rundaOd,
            int rundaDo
    ) {
        this.sesijaId = sesijaId;
        this.izvodjenjeId = izvodjenjeId;
        this.datum = datum;
        this.vremePocetka = vremePocetka;
        this.vremeZavrsetka = vremeZavrsetka;
        this.brojPrisutnihUcesnika = brojPrisutnihUcesnika;
        this.rundaOd = rundaOd;
        this.rundaDo = rundaDo;
    }

    public int getSesijaId() {
        return sesijaId;
    }

    public int getIzvodjenjeId() {
        return izvodjenjeId;
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

    public int getBrojPrisutnihUcesnika() {
        return brojPrisutnihUcesnika;
    }

    public int getRundaOd() {
        return rundaOd;
    }

    public int getRundaDo() {
        return rundaDo;
    }
}