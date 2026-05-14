package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.AlatLaboratorijaDto;
import rs.raf.m_stojanovic.bp.contactbook.model.LaboratorijaDto;
import rs.raf.m_stojanovic.bp.contactbook.model.ResursLaboratorijaDto;

public class ShowLaboratorijaDetailsControl implements EventHandler<MouseEvent> {

    private final TableView<ResursLaboratorijaDto> resursiLaboratorijeTable;
    private final TableView<AlatLaboratorijaDto> alatiLaboratorijeTable;
    private final TableView<LaboratorijaDto> laboratorijeTable;

    public ShowLaboratorijaDetailsControl(
            TableView<ResursLaboratorijaDto> resursiLaboratorijeTable,
            TableView<AlatLaboratorijaDto> alatiLaboratorijeTable,
            TableView<LaboratorijaDto> laboratorijeTable
    ) {
        this.resursiLaboratorijeTable = resursiLaboratorijeTable;
        this.alatiLaboratorijeTable = alatiLaboratorijeTable;
        this.laboratorijeTable = laboratorijeTable;
    }

    @Override
    public void handle(MouseEvent event) {
        LaboratorijaDto selectedLaboratorija =
                this.laboratorijeTable.getSelectionModel().getSelectedItem();

        if (selectedLaboratorija == null) {
            return;
        }

        int labId = selectedLaboratorija.getLabId();

        this.resursiLaboratorijeTable.setItems(FXCollections.observableArrayList(
                ResursLaboratorijaDto.loadByLabId(Config.getConnection(), labId)
        ));

        this.alatiLaboratorijeTable.setItems(FXCollections.observableArrayList(
                AlatLaboratorijaDto.loadByLabId(Config.getConnection(), labId)
        ));
    }
}