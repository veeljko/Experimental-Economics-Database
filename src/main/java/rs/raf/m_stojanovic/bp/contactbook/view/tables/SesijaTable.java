package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaDto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class SesijaTable extends TableView<SesijaDto> {

    public SesijaTable(List<SesijaDto> sesijaDtos) {
        super(FXCollections.observableArrayList(sesijaDtos));

        TableColumn<SesijaDto, Integer> tcSesijaId = new TableColumn<>("Sesija ID");
        TableColumn<SesijaDto, Integer> tcIzvodjenjeId = new TableColumn<>("Izvodjenje ID");
        TableColumn<SesijaDto, Date> tcDatum = new TableColumn<>("Datum");
        TableColumn<SesijaDto, Time> tcVremePocetka = new TableColumn<>("Vreme pocetka");
        TableColumn<SesijaDto, Time> tcVremeZavrsetka = new TableColumn<>("Vreme zavrsetka");
        TableColumn<SesijaDto, Integer> tcBrojPrisutnihUcesnika = new TableColumn<>("Broj prisutnih ucesnika");
        TableColumn<SesijaDto, Integer> tcRundaOd = new TableColumn<>("Runda od");
        TableColumn<SesijaDto, Integer> tcRundaDo = new TableColumn<>("Runda do");

        tcSesijaId.setCellValueFactory(new PropertyValueFactory<>("sesijaId"));
        tcIzvodjenjeId.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeId"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcVremePocetka.setCellValueFactory(new PropertyValueFactory<>("vremePocetka"));
        tcVremeZavrsetka.setCellValueFactory(new PropertyValueFactory<>("vremeZavrsetka"));
        tcBrojPrisutnihUcesnika.setCellValueFactory(new PropertyValueFactory<>("brojPrisutnihUcesnika"));
        tcRundaOd.setCellValueFactory(new PropertyValueFactory<>("rundaOd"));
        tcRundaDo.setCellValueFactory(new PropertyValueFactory<>("rundaDo"));

        super.getColumns().add(tcSesijaId);
        super.getColumns().add(tcIzvodjenjeId);
        super.getColumns().add(tcDatum);
        super.getColumns().add(tcVremePocetka);
        super.getColumns().add(tcVremeZavrsetka);
        super.getColumns().add(tcBrojPrisutnihUcesnika);
        super.getColumns().add(tcRundaOd);
        super.getColumns().add(tcRundaDo);
    }


}