package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.TipSesijeDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.TipSesijeTable;

public class ShowTipSesijeControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowTipSesijeControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int tipSesijeId = cell.getItem();

        TipSesijeTable tipSesijeTable = new TipSesijeTable(
                TipSesijeDto.loadById(Config.getConnection(), tipSesijeId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji tipa sesije - ID: " + tipSesijeId);
        stage.setScene(new Scene(tipSesijeTable, 700, 250));
        stage.show();
    }
}