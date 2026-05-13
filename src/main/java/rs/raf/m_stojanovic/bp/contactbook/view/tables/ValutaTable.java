package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.ValutaDto;

import java.util.List;

public class ValutaTable extends TableView<ValutaDto> {

    public ValutaTable(List<ValutaDto> valutaDtos) {
        super(FXCollections.observableArrayList(valutaDtos));

        TableColumn<ValutaDto, Integer> tcValutaId = new TableColumn<>("Valuta ID");
        TableColumn<ValutaDto, String> tcSifra = new TableColumn<>("Sifra");
        TableColumn<ValutaDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<ValutaDto, String> tcSimbol = new TableColumn<>("Simbol");

        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaId"));
        tcSifra.setCellValueFactory(new PropertyValueFactory<>("sifra"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcSimbol.setCellValueFactory(new PropertyValueFactory<>("simbol"));

        super.getColumns().add(tcValutaId);
        super.getColumns().add(tcSifra);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcSimbol);
    }
}