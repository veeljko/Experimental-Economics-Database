package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDto;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaDto;

import java.util.List;

public class ShowSesijeControl implements EventHandler<MouseEvent> {
    private final TableView<SesijaDto> sesijaTable;
    private final TableView<EksperimentDto> eksperimentTable;

    public ShowSesijeControl(TableView<SesijaDto> sesijaTable, TableView<EksperimentDto> eksperimentTable) {
        this.sesijaTable = sesijaTable;
        this.eksperimentTable = eksperimentTable;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 1) {
            EksperimentDto eksperimentDto = this.eksperimentTable.getSelectionModel().getSelectedItem();
            if (eksperimentDto == null)
                return;
            int eksperimentId = eksperimentDto.getEksperimentId();
            List<SesijaDto> sesijaDtos = SesijaDto.readByEksperimentId(Config.getConnection(), eksperimentId);

            this.sesijaTable.setItems(FXCollections.observableArrayList(sesijaDtos));
        }
    }
}
