package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaAlatDetaljiDto;

import java.sql.Date;
import java.util.List;

public class SesijaAlatDetaljiTable extends TableView<SesijaAlatDetaljiDto> {

    public SesijaAlatDetaljiTable(List<SesijaAlatDetaljiDto> alati) {
        super(FXCollections.observableArrayList(alati));

        TableColumn<SesijaAlatDetaljiDto, Integer> tcAlatId = new TableColumn<>("Alat ID");
        TableColumn<SesijaAlatDetaljiDto, Integer> tcTipAlataId = new TableColumn<>("Tip alata ID");
        TableColumn<SesijaAlatDetaljiDto, String> tcTipAlata = new TableColumn<>("Tip alata");
        TableColumn<SesijaAlatDetaljiDto, String> tcOpisTipa = new TableColumn<>("Opis tipa alata");
        TableColumn<SesijaAlatDetaljiDto, Integer> tcLabId = new TableColumn<>("Laboratorija ID");
        TableColumn<SesijaAlatDetaljiDto, String> tcIdentifikacioniBroj = new TableColumn<>("Identifikacioni broj");
        TableColumn<SesijaAlatDetaljiDto, String> tcVerzija = new TableColumn<>("Verzija");
        TableColumn<SesijaAlatDetaljiDto, Date> tcDatumNabavke = new TableColumn<>("Datum nabavke");
        TableColumn<SesijaAlatDetaljiDto, Date> tcDatumProizvodnje = new TableColumn<>("Datum proizvodnje");
        TableColumn<SesijaAlatDetaljiDto, String> tcOpisUpotrebe = new TableColumn<>("Opis upotrebe");

        tcAlatId.setCellValueFactory(new PropertyValueFactory<>("alatId"));
        tcTipAlataId.setCellValueFactory(new PropertyValueFactory<>("tipAlataId"));
        tcTipAlata.setCellValueFactory(new PropertyValueFactory<>("tipAlata"));
        tcOpisTipa.setCellValueFactory(new PropertyValueFactory<>("opisTipaAlata"));
        tcLabId.setCellValueFactory(new PropertyValueFactory<>("labId"));
        tcIdentifikacioniBroj.setCellValueFactory(new PropertyValueFactory<>("identifikacioniBroj"));
        tcVerzija.setCellValueFactory(new PropertyValueFactory<>("verzija"));
        tcDatumNabavke.setCellValueFactory(new PropertyValueFactory<>("datumNabavke"));
        tcDatumProizvodnje.setCellValueFactory(new PropertyValueFactory<>("datumProizvodnje"));
        tcOpisUpotrebe.setCellValueFactory(new PropertyValueFactory<>("opisUpotrebe"));

        super.getColumns().add(tcAlatId);
        super.getColumns().add(tcTipAlataId);
        super.getColumns().add(tcTipAlata);
        super.getColumns().add(tcOpisTipa);
        super.getColumns().add(tcLabId);
        super.getColumns().add(tcIdentifikacioniBroj);
        super.getColumns().add(tcVerzija);
        super.getColumns().add(tcDatumNabavke);
        super.getColumns().add(tcDatumProizvodnje);
        super.getColumns().add(tcOpisUpotrebe);
    }
}