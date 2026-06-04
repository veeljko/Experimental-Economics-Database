package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.UspesnoZavrsenEksperimentDto;

import java.math.BigDecimal;
import java.util.List;

public class UspesnoZavrsenEksperimentTable extends TableView<UspesnoZavrsenEksperimentDto> {

    public UspesnoZavrsenEksperimentTable(List<UspesnoZavrsenEksperimentDto> eksperimenti) {
        super(FXCollections.observableArrayList(eksperimenti));

        TableColumn<UspesnoZavrsenEksperimentDto, Integer> tcEksperimentId =
                new TableColumn<>("Eksperiment ID");
        TableColumn<UspesnoZavrsenEksperimentDto, String> tcNaziv =
                new TableColumn<>("Naziv");
        TableColumn<UspesnoZavrsenEksperimentDto, String> tcOpis =
                new TableColumn<>("Opis");
        TableColumn<UspesnoZavrsenEksperimentDto, String> tcCilj =
                new TableColumn<>("Cilj istrazivanja");
        TableColumn<UspesnoZavrsenEksperimentDto, Integer> tcBrojUcesnika =
                new TableColumn<>("Predvidjeni broj ucesnika");
        TableColumn<UspesnoZavrsenEksperimentDto, BigDecimal> tcBudzet =
                new TableColumn<>("Budzet");
        TableColumn<UspesnoZavrsenEksperimentDto, Integer> tcValutaId =
                new TableColumn<>("Valuta budzeta ID");

        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcCilj.setCellValueFactory(new PropertyValueFactory<>("ciljIstrazivanja"));
        tcBrojUcesnika.setCellValueFactory(new PropertyValueFactory<>("predvidjeniBrojUcesnika"));
        tcBudzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaBudzetaId"));

        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcCilj);
        super.getColumns().add(tcBrojUcesnika);
        super.getColumns().add(tcBudzet);
        super.getColumns().add(tcValutaId);
    }
}