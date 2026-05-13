package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.LaboratorijaDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.LaboratorijaTable;

public class ShowLaboratorijaControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowLaboratorijaControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int labId = cell.getItem();

        LaboratorijaTable laboratorijaTable = new LaboratorijaTable(
                LaboratorijaDto.loadById(Config.getConnection(), labId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji laboratorije - ID: " + labId);
        stage.setScene(new Scene(laboratorijaTable, 1000, 250));
        stage.show();
    }
}