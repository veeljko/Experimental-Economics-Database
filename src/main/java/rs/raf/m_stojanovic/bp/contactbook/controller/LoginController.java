package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.view.forms.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class LoginController {

    private final Stage stage;
    private final Login loginView;

    public LoginController(Stage stage) {
        this.stage = stage;
        this.loginView = new Login();

        initializeActions();
    }

    private boolean auth(String username, String password) {
        Path path = Path.of("src", "main", "resources", "korisnici.txt");
        try (BufferedReader r = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = r.readLine()) != null) {
                String [] s = line.split(" ");
                if (s[0].equals(username) && s[1].equals(password)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void initializeActions() {
        loginView.getRegisterButton().setOnAction(event -> {
            RegisterController registerController = new RegisterController(stage);
            registerController.show();
        });
        loginView.getLoginButton().setOnAction(event -> {
            String username = loginView.getUsernameField().getText();
            String password = loginView.getPasswordField().getText();
            if (auth(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Uspesno ste se logovali kao " + username);
                alert.initOwner(stage);
                alert.setTitle("Info");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Neuspesno Logovanje");
                alert.initOwner(stage);
                alert.setTitle("Greška");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
    }

    public void show() {
        Scene scene = new Scene(loginView, 400, 300);

        stage.setTitle("Contact Book - Login");
        stage.setScene(scene);
        stage.show();
    }
}