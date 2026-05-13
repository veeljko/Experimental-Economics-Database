package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowIzvodjenjeControl;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowStatusSesijeControl;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowTipSesijeControl;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaDto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class SesijaTable extends TableView<SesijaDto> {

    public SesijaTable(List<SesijaDto> sesijaDtos) {
        super(FXCollections.observableArrayList(sesijaDtos));

        TableColumn<SesijaDto, Integer> tcSesijaId = new TableColumn<>("Sesija ID");
        TableColumn<SesijaDto, Integer> tcIzvodjenjeId = new TableColumn<>("Izvodjenje ID");
        TableColumn<SesijaDto, Integer> tcTipSesijeId = new TableColumn<>("Tip sesije ID");
        TableColumn<SesijaDto, Integer> tcStatusSesijeId = new TableColumn<>("Status sesije ID");
        TableColumn<SesijaDto, Integer> tcRedniBroj = new TableColumn<>("Redni broj");
        TableColumn<SesijaDto, Date> tcDatum = new TableColumn<>("Datum");
        TableColumn<SesijaDto, Time> tcVremePocetka = new TableColumn<>("Vreme pocetka");
        TableColumn<SesijaDto, Time> tcVremeZavrsetka = new TableColumn<>("Vreme zavrsetka");
        TableColumn<SesijaDto, String> tcOpis = new TableColumn<>("Opis");

        tcSesijaId.setCellValueFactory(new PropertyValueFactory<>("sesijaId"));
        tcIzvodjenjeId.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeId"));
        tcTipSesijeId.setCellValueFactory(new PropertyValueFactory<>("tipSesijeId"));
        tcStatusSesijeId.setCellValueFactory(new PropertyValueFactory<>("statusSesijeId"));
        tcRedniBroj.setCellValueFactory(new PropertyValueFactory<>("redniBroj"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcVremePocetka.setCellValueFactory(new PropertyValueFactory<>("vremePocetka"));
        tcVremeZavrsetka.setCellValueFactory(new PropertyValueFactory<>("vremeZavrsetka"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcIzvodjenjeId.setCellFactory(column -> {
            TableCell<SesijaDto, Integer> cell = new TableCell<SesijaDto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(new ShowIzvodjenjeControl(cell));

            return cell;
        });

        tcTipSesijeId.setCellFactory(column -> {
            TableCell<SesijaDto, Integer> cell = new TableCell<SesijaDto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(new ShowTipSesijeControl(cell));

            return cell;
        });

        tcStatusSesijeId.setCellFactory(column -> {
            TableCell<SesijaDto, Integer> cell = new TableCell<SesijaDto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(new ShowStatusSesijeControl(cell));

            return cell;
        });

        super.getColumns().add(tcSesijaId);
        super.getColumns().add(tcIzvodjenjeId);
        super.getColumns().add(tcTipSesijeId);
        super.getColumns().add(tcStatusSesijeId);
        super.getColumns().add(tcRedniBroj);
        super.getColumns().add(tcDatum);
        super.getColumns().add(tcVremePocetka);
        super.getColumns().add(tcVremeZavrsetka);
        super.getColumns().add(tcOpis);
    }
}