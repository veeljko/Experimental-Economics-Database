package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDizajnerDto;
import rs.raf.m_stojanovic.bp.contactbook.model.IstrazivacDto;
import rs.raf.m_stojanovic.bp.contactbook.model.IzvodjenjeIzvodjacDto;

public class ShowIstrazivacDetailsControl implements EventHandler<MouseEvent> {

    private final TableView<EksperimentDizajnerDto> eksperimentiKaoDizajnerTable;
    private final TableView<IzvodjenjeIzvodjacDto> izvodjenjaKaoIzvodjacTable;
    private final TableView<IstrazivacDto> istrazivaciTable;

    public ShowIstrazivacDetailsControl(
            TableView<EksperimentDizajnerDto> eksperimentiKaoDizajnerTable,
            TableView<IzvodjenjeIzvodjacDto> izvodjenjaKaoIzvodjacTable,
            TableView<IstrazivacDto> istrazivaciTable
    ) {
        this.eksperimentiKaoDizajnerTable = eksperimentiKaoDizajnerTable;
        this.izvodjenjaKaoIzvodjacTable = izvodjenjaKaoIzvodjacTable;
        this.istrazivaciTable = istrazivaciTable;
    }

    @Override
    public void handle(MouseEvent event) {
        IstrazivacDto selectedIstrazivac =
                this.istrazivaciTable.getSelectionModel().getSelectedItem();

        if (selectedIstrazivac == null) {
            return;
        }

        int istrazivacId = selectedIstrazivac.getIstrazivacId();

        this.eksperimentiKaoDizajnerTable.setItems(FXCollections.observableArrayList(
                EksperimentDizajnerDto.loadByIstrazivacId(Config.getConnection(), istrazivacId)
        ));

        this.izvodjenjaKaoIzvodjacTable.setItems(FXCollections.observableArrayList(
                IzvodjenjeIzvodjacDto.loadByIstrazivacId(Config.getConnection(), istrazivacId)
        ));
    }
}