package rs.raf.m_stojanovic.bp.contactbook.view.forms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class Login extends VBox {

    private final TextField usernameField;
    private final PasswordField passwordField;
    private final Button loginButton;
    private final Button registerButton;

    public Login() {
        setSpacing(15);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Login");

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");
        registerButton = new Button("Register");

        getChildren().addAll(
                titleLabel,
                usernameField,
                passwordField,
                loginButton,
                registerButton
        );
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getRegisterButton() {
        return registerButton;
    }
}