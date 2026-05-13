package rs.raf.m_stojanovic.bp.contactbook.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.Config;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowSesijeControl;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDto;
import rs.raf.m_stojanovic.bp.contactbook.model.SesijaDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.EksperimentTable;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.SesijaTable;

public class MainView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<EksperimentDto> eksperimentTable = new EksperimentTable(EksperimentDto.loadAll(Config.getConnection()));
    private final TableView<SesijaDto> sesijeTable = new SesijaTable(new java.util.ArrayList<>());

    private final TextField tfFirstName
            = new TextField();
    private final TextField tfLastName
            = new TextField();
    private final Button btAdd
            = new Button("Add Contact");

    private final TextField tfValue
            = new TextField();
    private final Button btAddEmailAddress
            = new Button("Add Email Address");
    private final Button btAddPhoneNumber
            = new Button("Add Phone Number");

    public MainView() {
        this.eksperimentTable.setOnMouseClicked(new ShowSesijeControl(
                this.sesijeTable, this.eksperimentTable));

        this.root.setCenter(this.eksperimentTable);
        this.root.setLeft(this.gridWest());
        this.root.setRight(this.sesijeTable);
        this.root.setTop(this.horizontalBoxNorth());

        super.setScene(new Scene(this.root));
    }

    private HBox horizontalBoxNorth() {
        HBox hbox = new HBox(10, new Label("Value:"), this.tfValue,
                this.btAddEmailAddress, this.btAddPhoneNumber);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));
        return hbox;
    }

    private GridPane gridWest() {
        GridPane gridPane = new GridPane();
//        gridPane.addRow(0, new Label("First Name:"), this.tfFirstName);
//        gridPane.addRow(1, new Label("Last Name:"), this.tfLastName);
//        gridPane.add(this.btAdd, 1, 2);
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setPadding(new Insets(10));
//        gridPane.setVgap(10);
//        gridPane.setHgap(10);
        return gridPane;
    }

}
