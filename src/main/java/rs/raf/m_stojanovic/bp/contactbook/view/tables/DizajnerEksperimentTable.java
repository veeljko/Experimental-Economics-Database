package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.DizajnerEksperimentDto;

import java.util.List;

public class DizajnerEksperimentTable extends TableView<DizajnerEksperimentDto> {

    public DizajnerEksperimentTable(List<DizajnerEksperimentDto> dizajneri) {
        super(FXCollections.observableArrayList(dizajneri));

        TableColumn<DizajnerEksperimentDto, Integer> tcIstrazivacId = new TableColumn<>("Istrazivac ID");
        TableColumn<DizajnerEksperimentDto, String> tcIme = new TableColumn<>("Ime");
        TableColumn<DizajnerEksperimentDto, String> tcPrezime = new TableColumn<>("Prezime");
        TableColumn<DizajnerEksperimentDto, String> tcEmail = new TableColumn<>("Email");
        TableColumn<DizajnerEksperimentDto, String> tcInstitucija = new TableColumn<>("Institucija");
        TableColumn<DizajnerEksperimentDto, String> tcKvalifikacije = new TableColumn<>("Kvalifikacije");
        TableColumn<DizajnerEksperimentDto, String> tcSposobnosti = new TableColumn<>("Sposobnosti");
        TableColumn<DizajnerEksperimentDto, String> tcOblastDizajna = new TableColumn<>("Oblast dizajna");
        TableColumn<DizajnerEksperimentDto, String> tcNapomena = new TableColumn<>("Napomena dizajnera");
        TableColumn<DizajnerEksperimentDto, String> tcOpisZaduzenja = new TableColumn<>("Opis zaduzenja");

        tcIstrazivacId.setCellValueFactory(new PropertyValueFactory<>("istrazivacId"));
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcInstitucija.setCellValueFactory(new PropertyValueFactory<>("institucija"));
        tcKvalifikacije.setCellValueFactory(new PropertyValueFactory<>("kvalifikacije"));
        tcSposobnosti.setCellValueFactory(new PropertyValueFactory<>("sposobnosti"));
        tcOblastDizajna.setCellValueFactory(new PropertyValueFactory<>("oblastDizajna"));
        tcNapomena.setCellValueFactory(new PropertyValueFactory<>("napomenaDizajnera"));
        tcOpisZaduzenja.setCellValueFactory(new PropertyValueFactory<>("opisZaduzenja"));

        super.getColumns().add(tcIstrazivacId);
        super.getColumns().add(tcIme);
        super.getColumns().add(tcPrezime);
        super.getColumns().add(tcEmail);
        super.getColumns().add(tcInstitucija);
        super.getColumns().add(tcKvalifikacije);
        super.getColumns().add(tcSposobnosti);
        super.getColumns().add(tcOblastDizajna);
        super.getColumns().add(tcNapomena);
        super.getColumns().add(tcOpisZaduzenja);
    }
}