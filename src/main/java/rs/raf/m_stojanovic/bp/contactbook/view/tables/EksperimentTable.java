package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowValutaControl;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDto;

import java.math.BigDecimal;
import java.util.List;

public class EksperimentTable extends TableView<EksperimentDto> {

    public EksperimentTable(List<EksperimentDto> eksperimentDtos) {
        super(FXCollections.observableArrayList(eksperimentDtos));

        TableColumn<EksperimentDto, Integer> tcEksperimentId = new TableColumn<>("Eksperiment ID");
        TableColumn<EksperimentDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<EksperimentDto, String> tcOpis = new TableColumn<>("Opis");
        TableColumn<EksperimentDto, String> tcCiljIstrazivanja = new TableColumn<>("Cilj istrazivanja");
        TableColumn<EksperimentDto, Integer> tcPredvidjeniBrojUcesnika = new TableColumn<>("Predvidjeni broj ucesnika");
        TableColumn<EksperimentDto, BigDecimal> tcBudzet = new TableColumn<>("Budzet");
        TableColumn<EksperimentDto, Integer> tcValutaBudzetaId = new TableColumn<>("Valuta budzeta ID");
        TableColumn<EksperimentDto, String> tcPravila = new TableColumn<>("Pravila");
        TableColumn<EksperimentDto, String> tcTrzisniUslovi = new TableColumn<>("Trzisni uslovi");
        TableColumn<EksperimentDto, String> tcNacinMerenjaRezultata = new TableColumn<>("Nacin merenja rezultata");

        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcCiljIstrazivanja.setCellValueFactory(new PropertyValueFactory<>("ciljIstrazivanja"));
        tcPredvidjeniBrojUcesnika.setCellValueFactory(new PropertyValueFactory<>("predvidjeniBrojUcesnika"));
        tcBudzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
        tcValutaBudzetaId.setCellValueFactory(new PropertyValueFactory<>("valutaBudzetaId"));
        tcValutaBudzetaId.setCellFactory(column -> {
            TableCell<EksperimentDto, Integer> cell = new TableCell<EksperimentDto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseClicked(new ShowValutaControl(cell));

            return cell;
        });
        tcPravila.setCellValueFactory(new PropertyValueFactory<>("pravila"));
        tcTrzisniUslovi.setCellValueFactory(new PropertyValueFactory<>("trzisniUslovi"));
        tcNacinMerenjaRezultata.setCellValueFactory(new PropertyValueFactory<>("nacinMerenjaRezultata"));

        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcCiljIstrazivanja);
        super.getColumns().add(tcPredvidjeniBrojUcesnika);
        super.getColumns().add(tcBudzet);
        super.getColumns().add(tcValutaBudzetaId);
        super.getColumns().add(tcPravila);
        super.getColumns().add(tcTrzisniUslovi);
        super.getColumns().add(tcNacinMerenjaRezultata);
    }
}