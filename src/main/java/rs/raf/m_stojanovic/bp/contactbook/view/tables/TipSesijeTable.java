package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.TipSesijeDto;

import java.util.List;

public class TipSesijeTable extends TableView<TipSesijeDto> {

    public TipSesijeTable(List<TipSesijeDto> tipSesijeDtos) {
        super(FXCollections.observableArrayList(tipSesijeDtos));

        TableColumn<TipSesijeDto, Integer> tcTipSesijeId = new TableColumn<>("Tip sesije ID");
        TableColumn<TipSesijeDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<TipSesijeDto, String> tcOpis = new TableColumn<>("Opis");

        tcTipSesijeId.setCellValueFactory(new PropertyValueFactory<>("tipSesijeId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        super.getColumns().add(tcTipSesijeId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
    }
}