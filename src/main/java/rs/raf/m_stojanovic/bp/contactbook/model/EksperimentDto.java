package rs.raf.m_stojanovic.bp.contactbook.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EksperimentDto {

    public static List<EksperimentDto> loadEksperiment(Connection connection, int izvodjenjeId) {
        String query = "{CALL get_eksperiment_from_izvodjenjeId(?)}";

        try {
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1, izvodjenjeId);

            ResultSet rs = statement.executeQuery();

            List<EksperimentDto> eksperimentDtos = new ArrayList<>();

            while (rs.next()) {
                int eksperimentId = rs.getInt("eksperiment_id");
                int valutaId = rs.getInt("valuta_id");
                String naziv = rs.getString("naziv");
                String tipEksperimenta = rs.getString("tip_eksperimenta");
                String opis = rs.getString("opis");
                int brojUcesnika = rs.getInt("broj_ucesnika");
                String cilj = rs.getString("cilj");
                BigDecimal budzet = rs.getBigDecimal("budzet");
                String pravilaIgre = rs.getString("pravila_igre");

                EksperimentDto eksperimentDto = new EksperimentDto(
                        eksperimentId,
                        valutaId,
                        naziv,
                        tipEksperimenta,
                        opis,
                        brojUcesnika,
                        cilj,
                        budzet,
                        pravilaIgre
                );

                eksperimentDtos.add(eksperimentDto);
            }

            return eksperimentDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<EksperimentDto> loadAll(Connection connection) {
        String query = "SELECT * FROM eksperiment";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<EksperimentDto> eksperimentDtos = new ArrayList<>();

            while (rs.next()) {
                int eksperimentId = rs.getInt("eksperiment_id");
                int valutaId = rs.getInt("valuta_id");
                String naziv = rs.getString("naziv");
                String tipEksperimenta = rs.getString("tip_eksperimenta");
                String opis = rs.getString("opis");
                int brojUcesnika = rs.getInt("broj_ucesnika");
                String cilj = rs.getString("cilj");
                BigDecimal budzet = rs.getBigDecimal("budzet");
                String pravilaIgre = rs.getString("pravila_igre");

                EksperimentDto eksperimentDto = new EksperimentDto(
                        eksperimentId,
                        valutaId,
                        naziv,
                        tipEksperimenta,
                        opis,
                        brojUcesnika,
                        cilj,
                        budzet,
                        pravilaIgre
                );

                eksperimentDtos.add(eksperimentDto);
            }

            return eksperimentDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int eksperimentId;
    private final int valutaId;
    private final String naziv;
    private final String tipEksperimenta;
    private final String opis;
    private final int brojUcesnika;
    private final String cilj;
    private final BigDecimal budzet;
    private final String pravilaIgre;

    public EksperimentDto(
            int eksperimentId,
            int valutaId,
            String naziv,
            String tipEksperimenta,
            String opis,
            int brojUcesnika,
            String cilj,
            BigDecimal budzet,
            String pravilaIgre
    ) {
        this.eksperimentId = eksperimentId;
        this.valutaId = valutaId;
        this.naziv = naziv;
        this.tipEksperimenta = tipEksperimenta;
        this.opis = opis;
        this.brojUcesnika = brojUcesnika;
        this.cilj = cilj;
        this.budzet = budzet;
        this.pravilaIgre = pravilaIgre;
    }

    public int getEksperimentId() {
        return eksperimentId;
    }

    public int getValutaId() {
        return valutaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getTipEksperimenta() {
        return tipEksperimenta;
    }

    public String getOpis() {
        return opis;
    }

    public int getBrojUcesnika() {
        return brojUcesnika;
    }

    public String getCilj() {
        return cilj;
    }

    public BigDecimal getBudzet() {
        return budzet;
    }

    public String getPravilaIgre() {
        return pravilaIgre;
    }
}