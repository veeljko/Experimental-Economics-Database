package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.StatusIzvodjenjaDto;

import java.util.List;

public class StatusIzvodjenjaTable extends TableView<StatusIzvodjenjaDto> {

    public StatusIzvodjenjaTable(List<StatusIzvodjenjaDto> statusIzvodjenjaDtos) {
        super(FXCollections.observableArrayList(statusIzvodjenjaDtos));

        TableColumn<StatusIzvodjenjaDto, Integer> tcStatusIzvodjenjaId = new TableColumn<>("Status izvodjenja ID");
        TableColumn<StatusIzvodjenjaDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<StatusIzvodjenjaDto, String> tcOpis = new TableColumn<>("Opis");

        tcStatusIzvodjenjaId.setCellValueFactory(new PropertyValueFactory<>("statusIzvodjenjaId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        super.getColumns().add(tcStatusIzvodjenjaId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
    }
}