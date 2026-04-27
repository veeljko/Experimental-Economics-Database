package rs.raf.m_stojanovic.bp.contactbook;

import javafx.application.Application;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.view.MainView;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new MainView().show();
    }
}
