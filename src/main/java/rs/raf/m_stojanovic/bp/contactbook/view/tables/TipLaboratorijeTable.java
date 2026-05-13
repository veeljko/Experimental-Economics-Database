package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.TipLaboratorijeDto;

import java.util.List;

public class TipLaboratorijeTable extends TableView<TipLaboratorijeDto> {

    public TipLaboratorijeTable(List<TipLaboratorijeDto> tipLaboratorijeDtos) {
        super(FXCollections.observableArrayList(tipLaboratorijeDtos));

        TableColumn<TipLaboratorijeDto, Integer> tcTipLabId = new TableColumn<>("Tip laboratorije ID");
        TableColumn<TipLaboratorijeDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<TipLaboratorijeDto, String> tcOpis = new TableColumn<>("Opis");

        tcTipLabId.setCellValueFactory(new PropertyValueFactory<>("tipLabId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        super.getColumns().add(tcTipLabId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
    }
}