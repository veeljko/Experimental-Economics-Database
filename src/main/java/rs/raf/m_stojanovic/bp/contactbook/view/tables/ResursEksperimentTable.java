package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.ResursEksperimentDto;

import java.math.BigDecimal;
import java.util.List;

public class ResursEksperimentTable extends TableView<ResursEksperimentDto> {

    public ResursEksperimentTable(List<ResursEksperimentDto> resursi) {
        super(FXCollections.observableArrayList(resursi));

        TableColumn<ResursEksperimentDto, Integer> tcResursId = new TableColumn<>("Resurs ID");
        TableColumn<ResursEksperimentDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<ResursEksperimentDto, String> tcVrsta = new TableColumn<>("Vrsta resursa");
        TableColumn<ResursEksperimentDto, String> tcJedinica = new TableColumn<>("Jedinica mere");
        TableColumn<ResursEksperimentDto, String> tcOznaka = new TableColumn<>("Oznaka");
        TableColumn<ResursEksperimentDto, String> tcSvojstva = new TableColumn<>("Svojstva");
        TableColumn<ResursEksperimentDto, BigDecimal> tcKolicina = new TableColumn<>("Ukupna kolicina");
        TableColumn<ResursEksperimentDto, BigDecimal> tcPotrebna = new TableColumn<>("Potrebna kolicina");
        TableColumn<ResursEksperimentDto, String> tcNapomena = new TableColumn<>("Napomena");

        tcResursId.setCellValueFactory(new PropertyValueFactory<>("resursId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrstaResursa"));
        tcJedinica.setCellValueFactory(new PropertyValueFactory<>("jedinicaMere"));
        tcOznaka.setCellValueFactory(new PropertyValueFactory<>("oznakaJedinice"));
        tcSvojstva.setCellValueFactory(new PropertyValueFactory<>("svojstva"));
        tcKolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        tcPotrebna.setCellValueFactory(new PropertyValueFactory<>("potrebnaKolicina"));
        tcNapomena.setCellValueFactory(new PropertyValueFactory<>("napomena"));

        super.getColumns().add(tcResursId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcVrsta);
        super.getColumns().add(tcJedinica);
        super.getColumns().add(tcOznaka);
        super.getColumns().add(tcSvojstva);
        super.getColumns().add(tcKolicina);
        super.getColumns().add(tcPotrebna);
        super.getColumns().add(tcNapomena);
    }
}