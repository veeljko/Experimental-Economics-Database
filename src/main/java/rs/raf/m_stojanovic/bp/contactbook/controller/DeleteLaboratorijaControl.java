package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.AlatLaboratorijaDto;
import rs.raf.m_stojanovic.bp.contactbook.model.LaboratorijaDto;
import rs.raf.m_stojanovic.bp.contactbook.model.ResursLaboratorijaDto;

import java.util.ArrayList;
import java.util.Optional;

public class DeleteLaboratorijaControl implements EventHandler<ActionEvent> {

    private final TableView<LaboratorijaDto> laboratorijeTable;
    private final TableView<ResursLaboratorijaDto> resursiLaboratorijeTable;
    private final TableView<AlatLaboratorijaDto> alatiLaboratorijeTable;
    private final Button btDeleteLaboratorija;

    public DeleteLaboratorijaControl(
            TableView<LaboratorijaDto> laboratorijeTable,
            TableView<ResursLaboratorijaDto> resursiLaboratorijeTable,
            TableView<AlatLaboratorijaDto> alatiLaboratorijeTable,
            Button btDeleteLaboratorija
    ) {
        this.laboratorijeTable = laboratorijeTable;
        this.resursiLaboratorijeTable = resursiLaboratorijeTable;
        this.alatiLaboratorijeTable = alatiLaboratorijeTable;
        this.btDeleteLaboratorija = btDeleteLaboratorija;
    }

    @Override
    public void handle(ActionEvent event) {
        LaboratorijaDto selectedLaboratorija =
                this.laboratorijeTable.getSelectionModel().getSelectedItem();

        if (selectedLaboratorija == null) {
            return;
        }

        int labId = selectedLaboratorija.getLabId();

        if (!LaboratorijaDto.canDelete(Config.getConnection(), labId)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brisanje laboratorije");
            alert.setHeaderText("Laboratorija ne može da se obriše");
            alert.setContentText("Brisanje je dozvoljeno samo ako u toj laboratoriji ne radi nijedan istraživač.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Brisanje laboratorije");
        confirmAlert.setHeaderText("Da li ste sigurni?");
        confirmAlert.setContentText(
                "Biće obrisana laboratorija: " + selectedLaboratorija.getNaziv()
        );

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (!result.isPresent() || result.get() != ButtonType.OK) {
            return;
        }

        try {
            LaboratorijaDto.deleteById(Config.getConnection(), labId);

            this.laboratorijeTable.setItems(FXCollections.observableArrayList(
                    LaboratorijaDto.loadAll(Config.getConnection())
            ));

            this.resursiLaboratorijeTable.setItems(FXCollections.observableArrayList(
                    new ArrayList<>()
            ));

            this.alatiLaboratorijeTable.setItems(FXCollections.observableArrayList(
                    new ArrayList<>()
            ));

            this.btDeleteLaboratorija.setDisable(true);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Brisanje laboratorije");
            successAlert.setHeaderText("Laboratorija je obrisana");
            successAlert.setContentText("Laboratorija je uspešno obrisana iz baze.");
            successAlert.showAndWait();

        } catch (RuntimeException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Greška pri brisanju laboratorije");
            errorAlert.setHeaderText("Laboratorija nije obrisana");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }
}