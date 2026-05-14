package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.ResursLaboratorijaDto;

import java.math.BigDecimal;
import java.util.List;

public class ResursLaboratorijaTable extends TableView<ResursLaboratorijaDto> {

    public ResursLaboratorijaTable(List<ResursLaboratorijaDto> resursi) {
        super(FXCollections.observableArrayList(resursi));

        TableColumn<ResursLaboratorijaDto, Integer> tcResursId = new TableColumn<>("Resurs ID");
        TableColumn<ResursLaboratorijaDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<ResursLaboratorijaDto, String> tcVrsta = new TableColumn<>("Vrsta resursa");
        TableColumn<ResursLaboratorijaDto, String> tcJedinica = new TableColumn<>("Jedinica mere");
        TableColumn<ResursLaboratorijaDto, String> tcOznaka = new TableColumn<>("Oznaka");
        TableColumn<ResursLaboratorijaDto, String> tcSvojstva = new TableColumn<>("Svojstva");
        TableColumn<ResursLaboratorijaDto, BigDecimal> tcUkupnaKolicina = new TableColumn<>("Ukupna kolicina");
        TableColumn<ResursLaboratorijaDto, BigDecimal> tcDostupnaKolicina = new TableColumn<>("Dostupna kolicina");
        TableColumn<ResursLaboratorijaDto, String> tcStatus = new TableColumn<>("Status");
        TableColumn<ResursLaboratorijaDto, String> tcOpisStatusa = new TableColumn<>("Opis statusa");

        tcResursId.setCellValueFactory(new PropertyValueFactory<>("resursId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrstaResursa"));
        tcJedinica.setCellValueFactory(new PropertyValueFactory<>("jedinicaMere"));
        tcOznaka.setCellValueFactory(new PropertyValueFactory<>("oznakaJedinice"));
        tcSvojstva.setCellValueFactory(new PropertyValueFactory<>("svojstva"));
        tcUkupnaKolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        tcDostupnaKolicina.setCellValueFactory(new PropertyValueFactory<>("dostupnaKolicina"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("statusResursa"));
        tcOpisStatusa.setCellValueFactory(new PropertyValueFactory<>("opisStatusa"));

        super.getColumns().add(tcResursId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcVrsta);
        super.getColumns().add(tcJedinica);
        super.getColumns().add(tcOznaka);
        super.getColumns().add(tcSvojstva);
        super.getColumns().add(tcUkupnaKolicina);
        super.getColumns().add(tcDostupnaKolicina);
        super.getColumns().add(tcStatus);
        super.getColumns().add(tcOpisStatusa);
    }
}