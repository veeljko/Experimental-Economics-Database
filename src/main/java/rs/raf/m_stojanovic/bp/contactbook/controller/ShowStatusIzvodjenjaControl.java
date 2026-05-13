package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.StatusIzvodjenjaDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.StatusIzvodjenjaTable;

public class ShowStatusIzvodjenjaControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowStatusIzvodjenjaControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int statusIzvodjenjaId = cell.getItem();

        StatusIzvodjenjaTable statusIzvodjenjaTable = new StatusIzvodjenjaTable(
                StatusIzvodjenjaDto.loadById(Config.getConnection(), statusIzvodjenjaId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji statusa izvodjenja - ID: " + statusIzvodjenjaId);
        stage.setScene(new Scene(statusIzvodjenjaTable, 700, 250));
        stage.show();
    }
}