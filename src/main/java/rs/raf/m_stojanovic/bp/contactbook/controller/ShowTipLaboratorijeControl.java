package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.TipLaboratorijeDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.TipLaboratorijeTable;

public class ShowTipLaboratorijeControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowTipLaboratorijeControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int tipLabId = cell.getItem();

        TipLaboratorijeTable tipLaboratorijeTable = new TipLaboratorijeTable(
                TipLaboratorijeDto.loadById(Config.getConnection(), tipLabId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji tipa laboratorije - ID: " + tipLabId);
        stage.setScene(new Scene(tipLaboratorijeTable, 700, 250));
        stage.show();
    }
}