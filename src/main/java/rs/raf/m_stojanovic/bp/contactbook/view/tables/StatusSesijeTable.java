package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.StatusSesijeDto;

import java.util.List;

public class StatusSesijeTable extends TableView<StatusSesijeDto> {

    public StatusSesijeTable(List<StatusSesijeDto> statusSesijeDtos) {
        super(FXCollections.observableArrayList(statusSesijeDtos));

        TableColumn<StatusSesijeDto, Integer> tcStatusSesijeId = new TableColumn<>("Status sesije ID");
        TableColumn<StatusSesijeDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<StatusSesijeDto, String> tcOpis = new TableColumn<>("Opis");

        tcStatusSesijeId.setCellValueFactory(new PropertyValueFactory<>("statusSesijeId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        super.getColumns().add(tcStatusSesijeId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
    }
}