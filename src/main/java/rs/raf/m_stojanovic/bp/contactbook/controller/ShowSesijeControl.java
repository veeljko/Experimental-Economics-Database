package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.*;

public class ShowSesijeControl implements EventHandler<MouseEvent> {

    private final TableView<SesijaDto> sesijeTable;
    private final TableView<DizajnerEksperimentDto> dizajneriEksperimentaTable;
    private final TableView<ResursEksperimentDto> resursiEksperimentaTable;
    private final TableView<TeorijaEksperimentDto> teorijeEksperimentaTable;
    private final TableView<TipAlataEksperimentDto> tipoviAlataEksperimentaTable;
    private final TableView<EksperimentDto> eksperimentTable;

    public ShowSesijeControl(
            TableView<SesijaDto> sesijeTable,
            TableView<DizajnerEksperimentDto> dizajneriEksperimentaTable,
            TableView<ResursEksperimentDto> resursiEksperimentaTable,
            TableView<TeorijaEksperimentDto> teorijeEksperimentaTable,
            TableView<TipAlataEksperimentDto> tipoviAlataEksperimentaTable,
            TableView<EksperimentDto> eksperimentTable
    ) {
        this.sesijeTable = sesijeTable;
        this.dizajneriEksperimentaTable = dizajneriEksperimentaTable;
        this.resursiEksperimentaTable = resursiEksperimentaTable;
        this.teorijeEksperimentaTable = teorijeEksperimentaTable;
        this.tipoviAlataEksperimentaTable = tipoviAlataEksperimentaTable;
        this.eksperimentTable = eksperimentTable;
    }

    @Override
    public void handle(MouseEvent event) {
        EksperimentDto selectedEksperiment =
                this.eksperimentTable.getSelectionModel().getSelectedItem();

        if (selectedEksperiment == null) {
            return;
        }

        int eksperimentId = selectedEksperiment.getEksperimentId();

        this.sesijeTable.setItems(FXCollections.observableArrayList(
                SesijaDto.readByEksperimentId(Config.getConnection(), eksperimentId)
        ));

        this.dizajneriEksperimentaTable.setItems(FXCollections.observableArrayList(
                DizajnerEksperimentDto.loadByEksperimentId(Config.getConnection(), eksperimentId)
        ));

        this.resursiEksperimentaTable.setItems(FXCollections.observableArrayList(
                ResursEksperimentDto.loadByEksperimentId(Config.getConnection(), eksperimentId)
        ));

        this.teorijeEksperimentaTable.setItems(FXCollections.observableArrayList(
                TeorijaEksperimentDto.loadByEksperimentId(Config.getConnection(), eksperimentId)
        ));

        this.tipoviAlataEksperimentaTable.setItems(FXCollections.observableArrayList(
                TipAlataEksperimentDto.loadByEksperimentId(Config.getConnection(), eksperimentId)
        ));
    }
}