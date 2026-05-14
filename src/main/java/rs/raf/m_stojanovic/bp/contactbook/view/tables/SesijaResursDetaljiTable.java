package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaResursDetaljiDto;

import java.math.BigDecimal;
import java.util.List;

public class SesijaResursDetaljiTable extends TableView<SesijaResursDetaljiDto> {

    public SesijaResursDetaljiTable(List<SesijaResursDetaljiDto> resursi) {
        super(FXCollections.observableArrayList(resursi));

        TableColumn<SesijaResursDetaljiDto, Integer> tcResursId = new TableColumn<>("Resurs ID");
        TableColumn<SesijaResursDetaljiDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<SesijaResursDetaljiDto, String> tcVrsta = new TableColumn<>("Vrsta resursa");
        TableColumn<SesijaResursDetaljiDto, String> tcJedinica = new TableColumn<>("Jedinica mere");
        TableColumn<SesijaResursDetaljiDto, String> tcOznaka = new TableColumn<>("Oznaka");
        TableColumn<SesijaResursDetaljiDto, String> tcSvojstva = new TableColumn<>("Svojstva");
        TableColumn<SesijaResursDetaljiDto, BigDecimal> tcKolicina = new TableColumn<>("Ukupna kolicina");
        TableColumn<SesijaResursDetaljiDto, BigDecimal> tcIskoriscena = new TableColumn<>("Iskoriscena kolicina");
        TableColumn<SesijaResursDetaljiDto, String> tcNapomena = new TableColumn<>("Napomena");

        tcResursId.setCellValueFactory(new PropertyValueFactory<>("resursId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrstaResursa"));
        tcJedinica.setCellValueFactory(new PropertyValueFactory<>("jedinicaMere"));
        tcOznaka.setCellValueFactory(new PropertyValueFactory<>("oznakaJedinice"));
        tcSvojstva.setCellValueFactory(new PropertyValueFactory<>("svojstva"));
        tcKolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        tcIskoriscena.setCellValueFactory(new PropertyValueFactory<>("iskoriscenaKolicina"));
        tcNapomena.setCellValueFactory(new PropertyValueFactory<>("napomena"));

        super.getColumns().add(tcResursId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcVrsta);
        super.getColumns().add(tcJedinica);
        super.getColumns().add(tcOznaka);
        super.getColumns().add(tcSvojstva);
        super.getColumns().add(tcKolicina);
        super.getColumns().add(tcIskoriscena);
        super.getColumns().add(tcNapomena);
    }
}