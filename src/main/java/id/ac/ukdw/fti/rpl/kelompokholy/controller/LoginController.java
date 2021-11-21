package id.ac.ukdw.fti.rpl.kelompokholy.controller;

import id.ac.ukdw.fti.rpl.kelompokholy.dao.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    private Alert alertWarning = new Alert(Alert.AlertType.WARNING);
    private Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPaneLoginLayout;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    void doLogin(ActionEvent event) throws IOException {
        validation();
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

    }

    private boolean isFieldEmpty(TextField textField) {
        return textField.getText().equals("");
    }

    private boolean isTextFieldEmpty(TextField username, TextField password) {
        return isFieldEmpty(username) || isFieldEmpty(password);
    }

    private boolean isUserExist(TextField username, TextField password) {
        return LoginDAO.getInstance().doLogin(username.getText(), password.getText());
    }

    private void validation() throws IOException {
        boolean resultField = isTextFieldEmpty(textFieldUsername, textFieldPassword);

        if (resultField) {
            alertWarning.setTitle("Warning!");
            alertWarning.setHeaderText(null);
            alertWarning.setContentText("Username atau password tidak boleh kosong!");

            alertWarning.showAndWait();
        } else {
            boolean isLoginSuccess = isUserExist(textFieldUsername, textFieldPassword);

            if (isLoginSuccess) {
                alertInformation.setTitle("Sukses!");
                alertInformation.setHeaderText(null);
                alertInformation.setContentText("Login sukses!");

                alertInformation.showAndWait();

                Stage stage = (Stage) borderPaneLoginLayout.getScene().getWindow();
                URL url = Paths.get("./src/main/resources/id/ac/ukdw/fti/rpl/kelompokholy/main.fxml").toUri().toURL();
                Parent root = FXMLLoader.load(url);

                stage.setScene(new Scene(root));
                stage.show();

            } else {
                alertWarning.setTitle("Warning!");
                alertWarning.setHeaderText(null);
                alertWarning.setContentText("Username atau password salah!");

                alertWarning.showAndWait();
            }
        }

        textFieldUsername.clear();
        textFieldPassword.clear();
    }

}













































