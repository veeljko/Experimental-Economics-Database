package rs.raf.m_stojanovic.bp.contactbook.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rs.raf.m_stojanovic.bp.contactbook.model.ContactDto;

import java.util.List;

public class ContactTable extends TableView<ContactDto> {

    public ContactTable(List<ContactDto> contactDtos) {
        super(FXCollections.observableArrayList(contactDtos));

        TableColumn<ContactDto, String> tcFirstName = new TableColumn<>("First Name");
        TableColumn<ContactDto, String> tcLastName = new TableColumn<>("Last Name");

        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
    }

}
