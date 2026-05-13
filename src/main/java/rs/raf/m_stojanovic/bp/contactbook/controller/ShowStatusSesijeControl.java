package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.StatusSesijeDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.StatusSesijeTable;

public class ShowStatusSesijeControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowStatusSesijeControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int statusSesijeId = cell.getItem();

        StatusSesijeTable statusSesijeTable = new StatusSesijeTable(
                StatusSesijeDto.loadById(Config.getConnection(), statusSesijeId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji statusa sesije - ID: " + statusSesijeId);
        stage.setScene(new Scene(statusSesijeTable, 700, 250));
        stage.show();
    }
}