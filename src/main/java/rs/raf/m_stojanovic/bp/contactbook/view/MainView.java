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
import javafx.scene.layout.Priority;
import javafx.scene.control.ScrollPane;
import rs.raf.m_stojanovic.bp.contactbook.model.*;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import rs.raf.m_stojanovic.bp.contactbook.controller.ShowIstrazivacDetailsControl;
import rs.raf.m_stojanovic.bp.contactbook.model.IstrazivacDto;
import rs.raf.m_stojanovic.bp.contactbook.model.EksperimentDizajnerDto;
import rs.raf.m_stojanovic.bp.contactbook.model.IzvodjenjeIzvodjacDto;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.IstrazivacTable;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.EksperimentDizajnerTable;
import rs.raf.m_stojanovic.bp.contactbook.view.tables.IzvodjenjeIzvodjacTable;

public class MainView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<EksperimentDto> eksperimentTable = new EksperimentTable(EksperimentDto.loadAll(Config.getConnection()));
    private final TableView<SesijaDto> sesijeTable =
            new SesijaTable(new java.util.ArrayList<>());

    private final TableView<DizajnerEksperimentDto> dizajneriEksperimentaTable =
            new DizajnerEksperimentTable(new java.util.ArrayList<>());

    private final TableView<ResursEksperimentDto> resursiEksperimentaTable =
            new ResursEksperimentTable(new java.util.ArrayList<>());

    private final TableView<TeorijaEksperimentDto> teorijeEksperimentaTable =
            new TeorijaEksperimentTable(new java.util.ArrayList<>());

    private final TableView<TipAlataEksperimentDto> tipoviAlataEksperimentaTable =
            new TipAlataEksperimentTable(new java.util.ArrayList<>());

    private final TableView<IstrazivacDto> istrazivaciTable =
            new IstrazivacTable(IstrazivacDto.loadAll(Config.getConnection()));

    private final TableView<EksperimentDizajnerDto> eksperimentiKaoDizajnerTable =
            new EksperimentDizajnerTable(new java.util.ArrayList<>());

    private final TableView<IzvodjenjeIzvodjacDto> izvodjenjaKaoIzvodjacTable =
            new IzvodjenjeIzvodjacTable(new java.util.ArrayList<>());

    private final VBox istrazivaciDetailsBox = new VBox(10);

    private final VBox detailsBox = new VBox(10);
    private final HBox showEksperimenti = new HBox();
    private final HBox showLaboratorije = new HBox();
    private final HBox showIstrazivaci = new HBox();


    public MainView() {
        this.eksperimentTable.setOnMouseClicked(new ShowSesijeControl(
                this.sesijeTable,
                this.dizajneriEksperimentaTable,
                this.resursiEksperimentaTable,
                this.teorijeEksperimentaTable,
                this.tipoviAlataEksperimentaTable,
                this.eksperimentTable
        ));

        showEksperimenti.setAlignment(Pos.CENTER);
        showLaboratorije.setAlignment(Pos.CENTER);
        showIstrazivaci.setAlignment(Pos.CENTER);

        showEksperimenti.setSpacing(10);
        showLaboratorije.setSpacing(10);
        showIstrazivaci.setSpacing(10);

        this.sesijeTable.setPrefHeight(180);
        this.dizajneriEksperimentaTable.setPrefHeight(180);
        this.resursiEksperimentaTable.setPrefHeight(180);
        this.teorijeEksperimentaTable.setPrefHeight(180);
        this.tipoviAlataEksperimentaTable.setPrefHeight(180);

        detailsBox.setPadding(new Insets(10));
        detailsBox.getChildren().addAll(
                new Label("Sesije za izabrani eksperiment"),
                sesijeTable,
                new Label("Dizajneri za izabrani eksperiment"),
                dizajneriEksperimentaTable,
                new Label("Resursi za izabrani eksperiment"),
                resursiEksperimentaTable,
                new Label("Teorije za izabrani eksperiment"),
                teorijeEksperimentaTable,
                new Label("Tipovi alata za izabrani eksperiment"),
                tipoviAlataEksperimentaTable
        );

        ScrollPane detailsScrollPane = new ScrollPane(detailsBox);
        detailsScrollPane.setFitToWidth(true);
        detailsScrollPane.setPrefWidth(900);

        HBox.setHgrow(detailsScrollPane, Priority.ALWAYS);
        HBox.setHgrow(eksperimentTable, Priority.ALWAYS);

        showEksperimenti.getChildren().addAll(eksperimentTable, detailsScrollPane);

        this.istrazivaciTable.setOnMouseClicked(new ShowIstrazivacDetailsControl(
                this.eksperimentiKaoDizajnerTable,
                this.izvodjenjaKaoIzvodjacTable,
                this.istrazivaciTable
        ));

        setupIstrazivaciView();

        this.root.setCenter(this.showEksperimenti);
        this.root.setLeft(this.gridWest());
        this.root.setTop(this.horizontalBoxNorth());
        super.setScene(new Scene(this.root, 1500, 850));
    }

    private void setupIstrazivaciView() {
        showIstrazivaci.setAlignment(Pos.CENTER);
        showIstrazivaci.setSpacing(10);
        showIstrazivaci.setPadding(new Insets(10));

        istrazivaciTable.setPrefWidth(650);

        eksperimentiKaoDizajnerTable.setPrefHeight(300);
        izvodjenjaKaoIzvodjacTable.setPrefHeight(300);

        istrazivaciDetailsBox.setPadding(new Insets(10));
        istrazivaciDetailsBox.getChildren().addAll(
                new Label("Eksperimenti u kojima je istrazivac bio dizajner"),
                eksperimentiKaoDizajnerTable,
                new Label("Izvodjenja u kojima je istrazivac bio izvodjac"),
                izvodjenjaKaoIzvodjacTable
        );

        ScrollPane detailsScrollPane = new ScrollPane(istrazivaciDetailsBox);
        detailsScrollPane.setFitToWidth(true);
        detailsScrollPane.setPrefWidth(900);

        HBox.setHgrow(istrazivaciTable, Priority.ALWAYS);
        HBox.setHgrow(detailsScrollPane, Priority.ALWAYS);

        showIstrazivaci.getChildren().addAll(istrazivaciTable, detailsScrollPane);
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
