package rs.raf.m_stojanovic.bp.contactbook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.controller.LoginController;
import rs.raf.m_stojanovic.bp.contactbook.view.MainView;
import rs.raf.m_stojanovic.bp.contactbook.view.forms.Login;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        LoginController loginController = new LoginController(primaryStage);
//        loginController.show();
        MainView mw = new MainView();
        mw.show();
    }
}
