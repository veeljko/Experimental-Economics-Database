package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDizajnerDto;

import java.math.BigDecimal;
import java.util.List;

public class EksperimentDizajnerTable extends TableView<EksperimentDizajnerDto> {

    public EksperimentDizajnerTable(List<EksperimentDizajnerDto> eksperimenti) {
        super(FXCollections.observableArrayList(eksperimenti));

        TableColumn<EksperimentDizajnerDto, Integer> tcEksperimentId = new TableColumn<>("Eksperiment ID");
        TableColumn<EksperimentDizajnerDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<EksperimentDizajnerDto, String> tcOpis = new TableColumn<>("Opis");
        TableColumn<EksperimentDizajnerDto, String> tcCilj = new TableColumn<>("Cilj istrazivanja");
        TableColumn<EksperimentDizajnerDto, Integer> tcBrojUcesnika = new TableColumn<>("Predvidjeni broj ucesnika");
        TableColumn<EksperimentDizajnerDto, BigDecimal> tcBudzet = new TableColumn<>("Budzet");
        TableColumn<EksperimentDizajnerDto, Integer> tcValutaId = new TableColumn<>("Valuta budzeta ID");
        TableColumn<EksperimentDizajnerDto, String> tcPravila = new TableColumn<>("Pravila");
        TableColumn<EksperimentDizajnerDto, String> tcTrzisniUslovi = new TableColumn<>("Trzisni uslovi");
        TableColumn<EksperimentDizajnerDto, String> tcMerenje = new TableColumn<>("Nacin merenja rezultata");
        TableColumn<EksperimentDizajnerDto, String> tcOpisZaduzenja = new TableColumn<>("Opis zaduzenja");

        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcCilj.setCellValueFactory(new PropertyValueFactory<>("ciljIstrazivanja"));
        tcBrojUcesnika.setCellValueFactory(new PropertyValueFactory<>("predvidjeniBrojUcesnika"));
        tcBudzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaBudzetaId"));
        tcPravila.setCellValueFactory(new PropertyValueFactory<>("pravila"));
        tcTrzisniUslovi.setCellValueFactory(new PropertyValueFactory<>("trzisniUslovi"));
        tcMerenje.setCellValueFactory(new PropertyValueFactory<>("nacinMerenjaRezultata"));
        tcOpisZaduzenja.setCellValueFactory(new PropertyValueFactory<>("opisZaduzenja"));

        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcCilj);
        super.getColumns().add(tcBrojUcesnika);
        super.getColumns().add(tcBudzet);
        super.getColumns().add(tcValutaId);
        super.getColumns().add(tcPravila);
        super.getColumns().add(tcTrzisniUslovi);
        super.getColumns().add(tcMerenje);
        super.getColumns().add(tcOpisZaduzenja);
    }
}