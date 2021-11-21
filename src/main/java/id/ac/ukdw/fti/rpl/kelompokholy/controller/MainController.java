package id.ac.ukdw.fti.rpl.kelompokholy.controller;

import id.ac.ukdw.fti.rpl.kelompokholy.model.Verses;
import id.ac.ukdw.fti.rpl.kelompokholy.dao.MainDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Verses> tableVerses;

    @FXML
    private TableColumn<Verses, Integer> verseIdColumn;

    @FXML
    private TableColumn<Verses, String> verseColumn;

    @FXML
    private TableColumn<Verses, String> verseTextColumn;

    @FXML
    private TableColumn<Verses, String> placeColumn;

    @FXML
    private TableColumn<Verses, String> eventColumn;

    @FXML
    private TextField txtSrc;

    @FXML
    private Button btnSrc;

    @FXML
    void exit() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        URL url = Paths.get("./src/main/resources/id/ac/ukdw/fti/rpl/kelompokholy/login.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void find(){
        tableVerses.getItems().clear();
        ObservableList<Verses> verses = MainDAO.getInstance().findVerses(txtSrc.getText());
        verseIdColumn.setCellValueFactory(new PropertyValueFactory<>("verseId"));
        verseColumn.setCellValueFactory(new PropertyValueFactory<>("verse"));
        verseTextColumn.setCellValueFactory(new PropertyValueFactory<>("verseText"));
        placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("eventDescribed"));
        tableVerses.setItems(verses);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Verses> verses = MainDAO.getInstance().getAllVerses();
        verseIdColumn.setCellValueFactory(new PropertyValueFactory<>("verseId"));
        verseColumn.setCellValueFactory(new PropertyValueFactory<>("verse"));
        verseTextColumn.setCellValueFactory(new PropertyValueFactory<>("verseText"));
        placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("eventDescribed"));
        tableVerses.setItems(verses);
    }
}













































