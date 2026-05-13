package rs.raf.m_stojanovic.bp.contactbook.view.forms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class Register extends VBox {

    private final TextField usernameField;
    private final PasswordField passwordField;
    private final PasswordField confirmPasswordField;
    private final Button registerButton;
    private final Button loginButton;

    public Register() {
        setSpacing(15);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Register");

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");

        registerButton = new Button("Register");
        loginButton = new Button("Back to Login");

        getChildren().addAll(
                titleLabel,
                usernameField,
                passwordField,
                confirmPasswordField,
                registerButton,
                loginButton
        );
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public PasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}