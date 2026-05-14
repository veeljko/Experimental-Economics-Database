package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.*;

public class ShowPregledSesijeDetailsControl implements EventHandler<MouseEvent> {

    private final TableView<SesijaDto> sveSesijeTable;
    private final TableView<EksperimentDto> sesijaEksperimentTable;
    private final TableView<LaboratorijaDto> sesijaLaboratorijaTable;
    private final TableView<SesijaResursDetaljiDto> sesijaResursiTable;
    private final TableView<SesijaAlatDetaljiDto> sesijaAlatiTable;
    private final TableView<RezultatSesijeDto> rezultatiSesijeTable;
    private final Button btEditSesija;

    public ShowPregledSesijeDetailsControl(
            TableView<SesijaDto> sveSesijeTable,
            TableView<EksperimentDto> sesijaEksperimentTable,
            TableView<LaboratorijaDto> sesijaLaboratorijaTable,
            TableView<SesijaResursDetaljiDto> sesijaResursiTable,
            TableView<SesijaAlatDetaljiDto> sesijaAlatiTable,
            TableView<RezultatSesijeDto> rezultatiSesijeTable,
            Button btEditSesija
    ) {
        this.sveSesijeTable = sveSesijeTable;
        this.sesijaEksperimentTable = sesijaEksperimentTable;
        this.sesijaLaboratorijaTable = sesijaLaboratorijaTable;
        this.sesijaResursiTable = sesijaResursiTable;
        this.sesijaAlatiTable = sesijaAlatiTable;
        this.rezultatiSesijeTable = rezultatiSesijeTable;
        this.btEditSesija = btEditSesija;
    }

    @Override
    public void handle(MouseEvent event) {
        SesijaDto selectedSesija =
                this.sveSesijeTable.getSelectionModel().getSelectedItem();

        if (selectedSesija == null) {
            return;
        }

        this.btEditSesija.setDisable(false);

        int sesijaId = selectedSesija.getSesijaId();

        this.sesijaEksperimentTable.setItems(FXCollections.observableArrayList(
                EksperimentDto.loadBySesijaId(Config.getConnection(), sesijaId)
        ));

        this.sesijaLaboratorijaTable.setItems(FXCollections.observableArrayList(
                LaboratorijaDto.loadBySesijaId(Config.getConnection(), sesijaId)
        ));

        this.sesijaResursiTable.setItems(FXCollections.observableArrayList(
                SesijaResursDetaljiDto.loadBySesijaId(Config.getConnection(), sesijaId)
        ));

        this.sesijaAlatiTable.setItems(FXCollections.observableArrayList(
                SesijaAlatDetaljiDto.loadBySesijaId(Config.getConnection(), sesijaId)
        ));

        this.rezultatiSesijeTable.setItems(FXCollections.observableArrayList(
                RezultatSesijeDto.loadBySesijaId(Config.getConnection(), sesijaId)
        ));
    }
}