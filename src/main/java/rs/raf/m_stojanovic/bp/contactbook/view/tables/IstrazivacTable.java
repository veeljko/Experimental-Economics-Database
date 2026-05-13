package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.IstrazivacDto;

import java.util.List;

public class IstrazivacTable extends TableView<IstrazivacDto> {

    public IstrazivacTable(List<IstrazivacDto> istrazivaci) {
        super(FXCollections.observableArrayList(istrazivaci));

        TableColumn<IstrazivacDto, Integer> tcIstrazivacId = new TableColumn<>("Istrazivac ID");
        TableColumn<IstrazivacDto, String> tcIme = new TableColumn<>("Ime");
        TableColumn<IstrazivacDto, String> tcPrezime = new TableColumn<>("Prezime");
        TableColumn<IstrazivacDto, String> tcEmail = new TableColumn<>("Email");
        TableColumn<IstrazivacDto, String> tcInstitucija = new TableColumn<>("Institucija");
        TableColumn<IstrazivacDto, String> tcKvalifikacije = new TableColumn<>("Kvalifikacije");
        TableColumn<IstrazivacDto, String> tcSposobnosti = new TableColumn<>("Sposobnosti");

        tcIstrazivacId.setCellValueFactory(new PropertyValueFactory<>("istrazivacId"));
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcInstitucija.setCellValueFactory(new PropertyValueFactory<>("institucija"));
        tcKvalifikacije.setCellValueFactory(new PropertyValueFactory<>("kvalifikacije"));
        tcSposobnosti.setCellValueFactory(new PropertyValueFactory<>("sposobnosti"));

        super.getColumns().add(tcIstrazivacId);
        super.getColumns().add(tcIme);
        super.getColumns().add(tcPrezime);
        super.getColumns().add(tcEmail);
        super.getColumns().add(tcInstitucija);
        super.getColumns().add(tcKvalifikacije);
        super.getColumns().add(tcSposobnosti);
    }
}