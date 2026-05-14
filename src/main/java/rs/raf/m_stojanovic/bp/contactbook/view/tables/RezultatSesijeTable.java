package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.RezultatSesijeDto;

import java.math.BigDecimal;
import java.util.List;

public class RezultatSesijeTable extends TableView<RezultatSesijeDto> {

    public RezultatSesijeTable(List<RezultatSesijeDto> rezultati) {
        super(FXCollections.observableArrayList(rezultati));

        TableColumn<RezultatSesijeDto, Integer> tcRezultatId = new TableColumn<>("Rezultat ID");
        TableColumn<RezultatSesijeDto, Integer> tcSesijaId = new TableColumn<>("Sesija ID");
        TableColumn<RezultatSesijeDto, String> tcNazivMetrike = new TableColumn<>("Naziv metrike");
        TableColumn<RezultatSesijeDto, BigDecimal> tcVrednost = new TableColumn<>("Vrednost");
        TableColumn<RezultatSesijeDto, String> tcJedinicaMere = new TableColumn<>("Jedinica mere");
        TableColumn<RezultatSesijeDto, String> tcOpis = new TableColumn<>("Opis");

        tcRezultatId.setCellValueFactory(new PropertyValueFactory<>("rezultatId"));
        tcSesijaId.setCellValueFactory(new PropertyValueFactory<>("sesijaId"));
        tcNazivMetrike.setCellValueFactory(new PropertyValueFactory<>("nazivMetrike"));
        tcVrednost.setCellValueFactory(new PropertyValueFactory<>("vrednost"));
        tcJedinicaMere.setCellValueFactory(new PropertyValueFactory<>("jedinicaMere"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        super.getColumns().add(tcRezultatId);
        super.getColumns().add(tcSesijaId);
        super.getColumns().add(tcNazivMetrike);
        super.getColumns().add(tcVrednost);
        super.getColumns().add(tcJedinicaMere);
        super.getColumns().add(tcOpis);
    }
}