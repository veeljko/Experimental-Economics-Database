package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.ValutaDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.ValutaTable;

public class ShowValutaControl implements EventHandler<MouseEvent> {

    private final TableCell<?, Integer> cell;

    public ShowValutaControl(TableCell<?, Integer> cell) {
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (cell.isEmpty() || cell.getItem() == null) {
            return;
        }

        int valutaId = cell.getItem();

        ValutaTable valutaTable = new ValutaTable(
                ValutaDto.loadById(Config.getConnection(), valutaId)
        );

        Stage stage = new Stage();
        stage.setTitle("Detalji valute - ID: " + valutaId);
        stage.setScene(new Scene(valutaTable, 600, 250));
        stage.show();
    }
}