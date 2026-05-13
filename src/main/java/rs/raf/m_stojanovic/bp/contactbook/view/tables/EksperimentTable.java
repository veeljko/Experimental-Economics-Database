package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDto;

import java.math.BigDecimal;
import java.util.List;

public class EksperimentTable extends TableView<EksperimentDto> {

    public EksperimentTable(List<EksperimentDto> eksperimentDtos) {
        super(FXCollections.observableArrayList(eksperimentDtos));

        TableColumn<EksperimentDto, Integer> tcEksperimentId = new TableColumn<>("Eksperiment ID");
        TableColumn<EksperimentDto, Integer> tcValutaId = new TableColumn<>("Valuta ID");
        TableColumn<EksperimentDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<EksperimentDto, String> tcTipEksperimenta = new TableColumn<>("Tip eksperimenta");
        TableColumn<EksperimentDto, String> tcOpis = new TableColumn<>("Opis");
        TableColumn<EksperimentDto, Integer> tcBrojUcesnika = new TableColumn<>("Broj ucesnika");
        TableColumn<EksperimentDto, String> tcCilj = new TableColumn<>("Cilj");
        TableColumn<EksperimentDto, BigDecimal> tcBudzet = new TableColumn<>("Budzet");
        TableColumn<EksperimentDto, String> tcPravilaIgre = new TableColumn<>("Pravila igre");

        tcEksperimentId.setCellValueFactory(new PropertyValueFactory<>("eksperimentId"));
        tcValutaId.setCellValueFactory(new PropertyValueFactory<>("valutaId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcTipEksperimenta.setCellValueFactory(new PropertyValueFactory<>("tipEksperimenta"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcBrojUcesnika.setCellValueFactory(new PropertyValueFactory<>("brojUcesnika"));
        tcCilj.setCellValueFactory(new PropertyValueFactory<>("cilj"));
        tcBudzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
        tcPravilaIgre.setCellValueFactory(new PropertyValueFactory<>("pravilaIgre"));

        super.getColumns().add(tcEksperimentId);
        super.getColumns().add(tcValutaId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcTipEksperimenta);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcBrojUcesnika);
        super.getColumns().add(tcCilj);
        super.getColumns().add(tcBudzet);
        super.getColumns().add(tcPravilaIgre);
    }
}