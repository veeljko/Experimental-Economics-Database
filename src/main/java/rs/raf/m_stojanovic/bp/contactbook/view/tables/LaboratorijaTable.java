package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowTipLaboratorijeControl;
import rs.raf.m_stojanovic.bp.contactbook.model.LaboratorijaDto;

import java.util.List;

public class LaboratorijaTable extends TableView<LaboratorijaDto> {

    public LaboratorijaTable(List<LaboratorijaDto> laboratorijaDtos) {
        super(FXCollections.observableArrayList(laboratorijaDtos));

        TableColumn<LaboratorijaDto, Integer> tcLabId = new TableColumn<>("Laboratorija ID");
        TableColumn<LaboratorijaDto, Integer> tcTipLabId = new TableColumn<>("Tip laboratorije ID");
        TableColumn<LaboratorijaDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<LaboratorijaDto, String> tcOpisLokacije = new TableColumn<>("Opis lokacije");
        TableColumn<LaboratorijaDto, Integer> tcKapacitet = new TableColumn<>("Kapacitet");
        TableColumn<LaboratorijaDto, String> tcTehnickiUslovi = new TableColumn<>("Tehnicki uslovi");

        tcLabId.setCellValueFactory(new PropertyValueFactory<>("labId"));
        tcTipLabId.setCellValueFactory(new PropertyValueFactory<>("tipLabId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpisLokacije.setCellValueFactory(new PropertyValueFactory<>("opisLokacije"));
        tcKapacitet.setCellValueFactory(new PropertyValueFactory<>("kapacitet"));
        tcTehnickiUslovi.setCellValueFactory(new PropertyValueFactory<>("tehnickiUslovi"));

        tcTipLabId.setCellFactory(column -> {
            TableCell<LaboratorijaDto, Integer> cell = new TableCell<LaboratorijaDto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(new ShowTipLaboratorijeControl(cell));

            return cell;
        });

        super.getColumns().add(tcLabId);
        super.getColumns().add(tcTipLabId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpisLokacije);
        super.getColumns().add(tcKapacitet);
        super.getColumns().add(tcTehnickiUslovi);
    }
}