package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.AlatLaboratorijaDto;

import java.sql.Date;
import java.util.List;

public class AlatLaboratorijaTable extends TableView<AlatLaboratorijaDto> {

    public AlatLaboratorijaTable(List<AlatLaboratorijaDto> alati) {
        super(FXCollections.observableArrayList(alati));

        TableColumn<AlatLaboratorijaDto, Integer> tcAlatId = new TableColumn<>("Alat ID");
        TableColumn<AlatLaboratorijaDto, Integer> tcTipAlataId = new TableColumn<>("Tip alata ID");
        TableColumn<AlatLaboratorijaDto, String> tcTipAlata = new TableColumn<>("Tip alata");
        TableColumn<AlatLaboratorijaDto, String> tcOpisTipa = new TableColumn<>("Opis tipa alata");
        TableColumn<AlatLaboratorijaDto, Integer> tcLabId = new TableColumn<>("Laboratorija ID");
        TableColumn<AlatLaboratorijaDto, String> tcIdentifikacioniBroj = new TableColumn<>("Identifikacioni broj");
        TableColumn<AlatLaboratorijaDto, String> tcVerzija = new TableColumn<>("Verzija");
        TableColumn<AlatLaboratorijaDto, Date> tcDatumNabavke = new TableColumn<>("Datum nabavke");
        TableColumn<AlatLaboratorijaDto, Date> tcDatumProizvodnje = new TableColumn<>("Datum proizvodnje");

        tcAlatId.setCellValueFactory(new PropertyValueFactory<>("alatId"));
        tcTipAlataId.setCellValueFactory(new PropertyValueFactory<>("tipAlataId"));
        tcTipAlata.setCellValueFactory(new PropertyValueFactory<>("tipAlata"));
        tcOpisTipa.setCellValueFactory(new PropertyValueFactory<>("opisTipaAlata"));
        tcLabId.setCellValueFactory(new PropertyValueFactory<>("labId"));
        tcIdentifikacioniBroj.setCellValueFactory(new PropertyValueFactory<>("identifikacioniBroj"));
        tcVerzija.setCellValueFactory(new PropertyValueFactory<>("verzija"));
        tcDatumNabavke.setCellValueFactory(new PropertyValueFactory<>("datumNabavke"));
        tcDatumProizvodnje.setCellValueFactory(new PropertyValueFactory<>("datumProizvodnje"));

        super.getColumns().add(tcAlatId);
        super.getColumns().add(tcTipAlataId);
        super.getColumns().add(tcTipAlata);
        super.getColumns().add(tcOpisTipa);
        super.getColumns().add(tcLabId);
        super.getColumns().add(tcIdentifikacioniBroj);
        super.getColumns().add(tcVerzija);
        super.getColumns().add(tcDatumNabavke);
        super.getColumns().add(tcDatumProizvodnje);
    }
}