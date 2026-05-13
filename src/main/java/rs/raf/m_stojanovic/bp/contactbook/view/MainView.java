package rs.raf.m_stojanovic.bp.contactbook.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private final HBox showEksperimenti = new HBox();
    private final HBox showLaboratorije = new HBox();
    private final HBox showIstrazivaci = new HBox();

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

        showEksperimenti.setAlignment(Pos.CENTER);
        showLaboratorije.setAlignment(Pos.CENTER);
        showIstrazivaci.setAlignment(Pos.CENTER);

        showEksperimenti.setSpacing(10);
        showLaboratorije.setSpacing(10);
        showIstrazivaci.setSpacing(10);

        showEksperimenti.getChildren().addAll(eksperimentTable, sesijeTable);

        // Za sada placeholder-i, kasnije ovde dodaj svoje tabele.
        showIstrazivaci.getChildren().add(new Label("Ovde ce biti prikaz istrazivaca"));
        showLaboratorije.getChildren().add(new Label("Ovde ce biti prikaz laboratorija"));

        this.root.setCenter(this.showEksperimenti);
        this.root.setLeft(this.gridWest());
        this.root.setTop(this.horizontalBoxNorth());

        super.setScene(new Scene(this.root));
    }

    private HBox horizontalBoxNorth() {
        RadioButton rbEksperimenti = new RadioButton();
        RadioButton rbIstrazivaci = new RadioButton();
        RadioButton rbLaboratorije = new RadioButton();

        ToggleGroup toggleGroup = new ToggleGroup();

        rbEksperimenti.setToggleGroup(toggleGroup);
        rbIstrazivaci.setToggleGroup(toggleGroup);
        rbLaboratorije.setToggleGroup(toggleGroup);

        rbEksperimenti.setSelected(true);

        rbEksperimenti.setOnAction(e -> this.root.setCenter(this.showEksperimenti));
        rbIstrazivaci.setOnAction(e -> this.root.setCenter(this.showIstrazivaci));
        rbLaboratorije.setOnAction(e -> this.root.setCenter(this.showLaboratorije));

        VBox vbEksperimenti = new VBox(5, rbEksperimenti, new Label("Eksperimenti"));
        VBox vbIstrazivaci = new VBox(5, rbIstrazivaci, new Label("Istrazivaci"));
        VBox vbLaboratorije = new VBox(5, rbLaboratorije, new Label("Laboratorije"));

        vbEksperimenti.setAlignment(Pos.CENTER);
        vbIstrazivaci.setAlignment(Pos.CENTER);
        vbLaboratorije.setAlignment(Pos.CENTER);

        HBox hbox = new HBox(40, vbEksperimenti, vbIstrazivaci, vbLaboratorije);
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
