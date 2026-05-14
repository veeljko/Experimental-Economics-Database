package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaDto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class EditZakazanaSesijaControl implements EventHandler<ActionEvent> {

    private final TableView<SesijaDto> sveSesijeTable;
    private final Button btEditSesija;

    public EditZakazanaSesijaControl(
            TableView<SesijaDto> sveSesijeTable,
            Button btEditSesija
    ) {
        this.sveSesijeTable = sveSesijeTable;
        this.btEditSesija = btEditSesija;
    }

    @Override
    public void handle(ActionEvent event) {
        SesijaDto selectedSesija =
                this.sveSesijeTable.getSelectionModel().getSelectedItem();

        if (selectedSesija == null) {
            return;
        }

//        if (selectedSesija.getStatusSesijeId() != 1) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Izmena sesije");
//            alert.setHeaderText("Sesija nije zakazana");
//            alert.setContentText("Mogu se menjati samo zakazane sesije.");
//            alert.showAndWait();
//            return;
//        }

        Stage stage = new Stage();
        stage.setTitle("Izmena zakazane sesije - ID: " + selectedSesija.getSesijaId());

        TextField tfTipSesijeId = new TextField(String.valueOf(selectedSesija.getTipSesijeId()));
        TextField tfStatusSesijeId = new TextField(String.valueOf(selectedSesija.getStatusSesijeId()));
        TextField tfRedniBroj = new TextField(String.valueOf(selectedSesija.getRedniBroj()));

        DatePicker dpDatum = new DatePicker();
        dpDatum.setValue(selectedSesija.getDatum().toLocalDate());

        TextField tfVremePocetka = new TextField(selectedSesija.getVremePocetka().toString());
        TextField tfVremeZavrsetka = new TextField(selectedSesija.getVremeZavrsetka().toString());

        TextArea taOpis = new TextArea(selectedSesija.getOpis());
        taOpis.setPrefRowCount(4);

        Button btSave = new Button("Sacuvaj");
        Button btCancel = new Button("Odustani");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.addRow(0, new Label("Tip sesije ID:"), tfTipSesijeId);
        gridPane.addRow(1, new Label("Status sesije ID:"), tfStatusSesijeId);
        gridPane.addRow(2, new Label("Redni broj:"), tfRedniBroj);
        gridPane.addRow(3, new Label("Datum:"), dpDatum);
        gridPane.addRow(4, new Label("Vreme pocetka:"), tfVremePocetka);
        gridPane.addRow(5, new Label("Vreme zavrsetka:"), tfVremeZavrsetka);
        gridPane.addRow(6, new Label("Opis:"), taOpis);
        gridPane.addRow(7, btSave, btCancel);

        btCancel.setOnAction(e -> stage.close());

        btSave.setOnAction(e -> {
            try {
                int tipSesijeId = Integer.parseInt(tfTipSesijeId.getText().trim());
                int statusSesijeId = Integer.parseInt(tfStatusSesijeId.getText().trim());
                int redniBroj = Integer.parseInt(tfRedniBroj.getText().trim());

                LocalDate localDate = dpDatum.getValue();

                if (localDate == null) {
                    throw new IllegalArgumentException("Datum je obavezan.");
                }

                Date datum = Date.valueOf(localDate);
                Time vremePocetka = Time.valueOf(normalizeTime(tfVremePocetka.getText().trim()));
                Time vremeZavrsetka = Time.valueOf(normalizeTime(tfVremeZavrsetka.getText().trim()));

                if (!vremePocetka.before(vremeZavrsetka)) {
                    throw new IllegalArgumentException("Vreme pocetka mora biti pre vremena zavrsetka.");
                }

                String opis = taOpis.getText();

                SesijaDto.updateZakazanaSesija(
                        Config.getConnection(),
                        selectedSesija.getSesijaId(),
                        tipSesijeId,
                        statusSesijeId,
                        redniBroj,
                        datum,
                        vremePocetka,
                        vremeZavrsetka,
                        opis
                );

                this.sveSesijeTable.setItems(FXCollections.observableArrayList(
                        SesijaDto.readAll(Config.getConnection())
                ));

                this.btEditSesija.setDisable(true);

                stage.close();

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska pri izmeni sesije");
                alert.setHeaderText("Podaci nisu ispravni");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        stage.setScene(new Scene(gridPane, 600, 420));
        stage.show();
    }

    private String normalizeTime(String value) {
        if (value.matches("\\d{2}:\\d{2}")) {
            return value + ":00";
        }

        if (value.matches("\\d{2}:\\d{2}:\\d{2}")) {
            return value;
        }

        throw new IllegalArgumentException("Vreme mora biti u formatu HH:mm ili HH:mm:ss.");
    }
}