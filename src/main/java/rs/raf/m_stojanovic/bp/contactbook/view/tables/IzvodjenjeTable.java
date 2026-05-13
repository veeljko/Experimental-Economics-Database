package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowLaboratorijaControl;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowStatusIzvodjenjaControl;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowValutaControl;
import rs.raf.m_stojanovic.bp.contactbook.model.IzvodjenjeDto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class IzvodjenjeTable extends TableView<IzvodjenjeDto> {

    public IzvodjenjeTable(List<IzvodjenjeDto> izvodjenjeDtos) {
        super(FXCollections.observableArrayList(izvodjenjeDtos));

        TableColumn<IzvodjenjeDto, Integer> tcIzvodjenjeId = new TableColumn<>("Izvodjenje ID");
        TableColumn<IzvodjenjeDto, Integer> tcEksperimentId = new TableColumn<>("Eksperiment ID");
        TableColumn<IzvodjenjeDto, Integer> tcLabId = new TableColumn<>("Laboratorija ID");
        TableColumn<IzvodjenjeDto, Date> tcDatum = new TableColumn<>("Datum");
        TableColumn<IzvodjenjeDto, Integer> tcStatusIzvodjenjaId = new TableColumn<>("Status izvodjenja ID");
        TableColumn<IzvodjenjeDto, Integer> tcBrojRundi = new TableColumn<>("Broj rundi");
        TableColumn<IzvodjenjeDto, BigDecimal> tcPocetniKapital = new TableColumn<>("Pocetni kapital ucesnika");
        TableColumn<IzvodjenjeDto, Integer> tcValutaId = new TableColumn<>("Valuta ID");

        tcIzvodjenjeId.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeId"));
        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcLabId.setCellValueFactory(new PropertyValueFactory<>("labId"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcStatusIzvodjenjaId.setCellValueFactory(new PropertyValueFactory<>("statusIzvodjenjaId"));
        tcBrojRundi.setCellValueFactory(new PropertyValueFactory<>("brojRundi"));
        tcPocetniKapital.setCellValueFactory(new PropertyValueFactory<>("pocetniKapitalUcesnika"));
        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaId"));

        tcLabId.setCellFactory(column -> {
            TableCell<IzvodjenjeDto, Integer> cell = new TableCell<IzvodjenjeDto, Integer>() {
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

            cell.setOnMouseClicked(new ShowLaboratorijaControl(cell));

            return cell;
        });

        tcStatusIzvodjenjaId.setCellFactory(column -> {
            TableCell<IzvodjenjeDto, Integer> cell = new TableCell<IzvodjenjeDto, Integer>() {
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

            cell.setOnMouseClicked(new ShowStatusIzvodjenjaControl(cell));

            return cell;
        });

        tcValutaId.setCellFactory(column -> {
            TableCell<IzvodjenjeDto, Integer> cell = new TableCell<IzvodjenjeDto, Integer>() {
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

            cell.setOnMouseClicked(new ShowValutaControl(cell));

            return cell;
        });

        super.getColumns().add(tcIzvodjenjeId);
        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcLabId);
        super.getColumns().add(tcDatum);
        super.getColumns().add(tcStatusIzvodjenjaId);
        super.getColumns().add(tcBrojRundi);
        super.getColumns().add(tcPocetniKapital);
        super.getColumns().add(tcValutaId);
    }
}