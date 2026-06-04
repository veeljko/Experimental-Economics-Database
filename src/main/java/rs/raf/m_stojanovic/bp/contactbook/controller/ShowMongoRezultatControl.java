package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.bp.contactbook.model.MongoEksperimentRezultatDto;
import rs.raf.m_stojanovic.bp.contactbook.model.UspesnoZavrsenEksperimentDto;

public class ShowMongoRezultatControl implements EventHandler<MouseEvent> {

    private final TableView<UspesnoZavrsenEksperimentDto> eksperimentiTable;
    private final TextArea mongoRezultatTextArea;

    public ShowMongoRezultatControl(
            TableView<UspesnoZavrsenEksperimentDto> eksperimentiTable,
            TextArea mongoRezultatTextArea
    ) {
        this.eksperimentiTable = eksperimentiTable;
        this.mongoRezultatTextArea = mongoRezultatTextArea;
    }

    @Override
    public void handle(MouseEvent event) {
        UspesnoZavrsenEksperimentDto selectedEksperiment =
                this.eksperimentiTable.getSelectionModel().getSelectedItem();

        if (selectedEksperiment == null) {
            return;
        }

        int eksperimentId = selectedEksperiment.getEksperimentId();

        MongoEksperimentRezultatDto rezultat =
                MongoEksperimentRezultatDto.loadByEksperimentId(eksperimentId);

        if (rezultat == null) {
            this.mongoRezultatTextArea.setText(
                    "Nema MongoDB dokumenta za eksperiment_id = " + eksperimentId
            );
            return;
        }

        this.mongoRezultatTextArea.setText(rezultat.getJson());
    }
}