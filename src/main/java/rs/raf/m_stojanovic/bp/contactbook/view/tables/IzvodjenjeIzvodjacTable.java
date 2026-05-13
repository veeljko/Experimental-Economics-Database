package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.IzvodjenjeIzvodjacDto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class IzvodjenjeIzvodjacTable extends TableView<IzvodjenjeIzvodjacDto> {

    public IzvodjenjeIzvodjacTable(List<IzvodjenjeIzvodjacDto> izvodjenja) {
        super(FXCollections.observableArrayList(izvodjenja));

        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcIzvodjenjeId = new TableColumn<>("Izvodjenje ID");
        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcEksperimentId = new TableColumn<>("Eksperiment ID");
        TableColumn<IzvodjenjeIzvodjacDto, String> tcNazivEksperimenta = new TableColumn<>("Naziv eksperimenta");
        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcLabId = new TableColumn<>("Laboratorija ID");
        TableColumn<IzvodjenjeIzvodjacDto, String> tcNazivLaboratorije = new TableColumn<>("Naziv laboratorije");
        TableColumn<IzvodjenjeIzvodjacDto, Date> tcDatum = new TableColumn<>("Datum");
        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcStatusId = new TableColumn<>("Status izvodjenja ID");
        TableColumn<IzvodjenjeIzvodjacDto, String> tcStatus = new TableColumn<>("Status izvodjenja");
        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcBrojRundi = new TableColumn<>("Broj rundi");
        TableColumn<IzvodjenjeIzvodjacDto, BigDecimal> tcKapital = new TableColumn<>("Pocetni kapital");
        TableColumn<IzvodjenjeIzvodjacDto, Integer> tcValutaId = new TableColumn<>("Valuta ID");
        TableColumn<IzvodjenjeIzvodjacDto, String> tcValutaSifra = new TableColumn<>("Valuta");
        TableColumn<IzvodjenjeIzvodjacDto, String> tcOpisUloge = new TableColumn<>("Opis uloge");

        tcIzvodjenjeId.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeId"));
        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcNazivEksperimenta.setCellValueFactory(new PropertyValueFactory<>("nazivEksperimenta"));
        tcLabId.setCellValueFactory(new PropertyValueFactory<>("labId"));
        tcNazivLaboratorije.setCellValueFactory(new PropertyValueFactory<>("nazivLaboratorije"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcStatusId.setCellValueFactory(new PropertyValueFactory<>("statusIzvodjenjaId"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("statusIzvodjenja"));
        tcBrojRundi.setCellValueFactory(new PropertyValueFactory<>("brojRundi"));
        tcKapital.setCellValueFactory(new PropertyValueFactory<>("pocetniKapitalUcesnika"));
        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaId"));
        tcValutaSifra.setCellValueFactory(new PropertyValueFactory<>("valutaSifra"));
        tcOpisUloge.setCellValueFactory(new PropertyValueFactory<>("opisUloge"));

        super.getColumns().add(tcIzvodjenjeId);
        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcNazivEksperimenta);
        super.getColumns().add(tcLabId);
        super.getColumns().add(tcNazivLaboratorije);
        super.getColumns().add(tcDatum);
        super.getColumns().add(tcStatusId);
        super.getColumns().add(tcStatus);
        super.getColumns().add(tcBrojRundi);
        super.getColumns().add(tcKapital);
        super.getColumns().add(tcValutaId);
        super.getColumns().add(tcValutaSifra);
        super.getColumns().add(tcOpisUloge);
    }
}