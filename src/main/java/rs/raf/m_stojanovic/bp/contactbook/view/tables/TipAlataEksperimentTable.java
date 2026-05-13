package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.TipAlataEksperimentDto;

import java.util.List;

public class TipAlataEksperimentTable extends TableView<TipAlataEksperimentDto> {

    public TipAlataEksperimentTable(List<TipAlataEksperimentDto> tipoviAlata) {
        super(FXCollections.observableArrayList(tipoviAlata));

        TableColumn<TipAlataEksperimentDto, Integer> tcTipAlataId = new TableColumn<>("Tip alata ID");
        TableColumn<TipAlataEksperimentDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<TipAlataEksperimentDto, String> tcOpis = new TableColumn<>("Opis");
        TableColumn<TipAlataEksperimentDto, Integer> tcBrojPotrebnih = new TableColumn<>("Broj potrebnih alata");
        TableColumn<TipAlataEksperimentDto, String> tcMinimalnaVerzija = new TableColumn<>("Minimalna verzija");
        TableColumn<TipAlataEksperimentDto, String> tcNapomena = new TableColumn<>("Napomena");

        tcTipAlataId.setCellValueFactory(new PropertyValueFactory<>("tipAlataId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcBrojPotrebnih.setCellValueFactory(new PropertyValueFactory<>("brojPotrebnihAlata"));
        tcMinimalnaVerzija.setCellValueFactory(new PropertyValueFactory<>("minimalnaVerzija"));
        tcNapomena.setCellValueFactory(new PropertyValueFactory<>("napomena"));

        super.getColumns().add(tcTipAlataId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcBrojPotrebnih);
        super.getColumns().add(tcMinimalnaVerzija);
        super.getColumns().add(tcNapomena);
    }
}