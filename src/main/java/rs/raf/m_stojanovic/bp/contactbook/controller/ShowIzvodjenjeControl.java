package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.IzvodjenjeDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.IzvodjenjeTable;

public class ShowIzvodjenjeControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowIzvodjenjeControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int izvodjenjeId = cell.getItem();

        IzvodjenjeTable izvodjenjeTable = new IzvodjenjeTable(
                IzvodjenjeDto.loadById(Config.getConnection(), izvodjenjeId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji izvodjenja - ID: " + izvodjenjeId);
        stage.setScene(new Scene(izvodjenjeTable, 1000, 250));
        stage.show();
    }
}