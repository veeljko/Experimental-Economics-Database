package rs.raf.m_stojanovic.bp.contactbook.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.bp.contactbook.view.forms.Register;

import java.io.*;
import java.nio.file.Path;

public class RegisterController {

    private final Stage stage;
    private final Register registerView;

    public RegisterController(Stage stage) {
        this.stage = stage;
        this.registerView = new Register();

        initializeActions();
    }

    private boolean isUsernameUnique(String username) {
        Path path = Path.of("src", "main", "resources", "korisnici.txt");
        try (BufferedReader r = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = r.readLine()) != null) {
                String [] s = line.split(" ");
                if (s[0].equals(username)) {
                    return false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void initializeActions() {
        registerView.getLoginButton().setOnAction(event -> {
            LoginController loginController = new LoginController(stage);
            loginController.show();
        });
        registerView.getRegisterButton().setOnAction(event -> {
            String username = registerView.getUsernameField().getText();
            String password = registerView.getPasswordField().getText();
            String confirmPassword = registerView.getConfirmPasswordField().getText();
            if (password.equals(confirmPassword)) {
                if (!isUsernameUnique(username)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Korisnicko ime je zauzeto");
                    alert.initOwner(stage);
                    alert.setTitle("Greška");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    return;
                }
                Path path = Path.of("src", "main", "resources", "korisnici.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path), true))) {
                    writer.write(username + " " + password);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Polja za lozinke se razlikuju");
                alert.initOwner(stage);
                alert.setTitle("Greška");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
    }

    public void show() {
        Scene scene = new Scene(registerView, 400, 350);

        stage.setTitle("Contact Book - Register");
        stage.setScene(scene);
        stage.show();
    }
}