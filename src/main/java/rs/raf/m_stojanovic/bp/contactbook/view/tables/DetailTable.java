package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.DetailDto;

public class DetailTable extends TableView<DetailDto> {

    public DetailTable() {
        TableColumn<DetailDto, String> tcValue = new TableColumn<>("Value");
        TableColumn<DetailDto, String> tcCategory = new TableColumn<>("Category");

        tcValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        tcCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        super.getColumns().add(tcValue);
        super.getColumns().add(tcCategory);
    }

}
