package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.TeorijaEksperimentDto;

import java.util.List;

public class TeorijaEksperimentTable extends TableView<TeorijaEksperimentDto> {

    public TeorijaEksperimentTable(List<TeorijaEksperimentDto> teorije) {
        super(FXCollections.observableArrayList(teorije));

        TableColumn<TeorijaEksperimentDto, Integer> tcTeorijaId = new TableColumn<>("Teorija ID");
        TableColumn<TeorijaEksperimentDto, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<TeorijaEksperimentDto, String> tcIdentifikacioniPodaci = new TableColumn<>("Identifikacioni podaci");
        TableColumn<TeorijaEksperimentDto, String> tcOblast = new TableColumn<>("Oblast");
        TableColumn<TeorijaEksperimentDto, String> tcOpis = new TableColumn<>("Opis");
        TableColumn<TeorijaEksperimentDto, String> tcUloga = new TableColumn<>("Uloga teorije");

        tcTeorijaId.setCellValueFactory(new PropertyValueFactory<>("teorijaId"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcIdentifikacioniPodaci.setCellValueFactory(new PropertyValueFactory<>("identifikacioniPodaci"));
        tcOblast.setCellValueFactory(new PropertyValueFactory<>("oblast"));
        tcOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tcUloga.setCellValueFactory(new PropertyValueFactory<>("ulogaTeorije"));

        super.getColumns().add(tcTeorijaId);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcIdentifikacioniPodaci);
        super.getColumns().add(tcOblast);
        super.getColumns().add(tcOpis);
        super.getColumns().add(tcUloga);
    }
}