package id.ac.ukdw.fti.rpl.kelompokholy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class FXMLController {

    private String text;

    @FXML
    private Text displayText;

    @FXML
    private TextField textField;

    @FXML
    private Button submitButton;

    @FXML
    void submit(ActionEvent event) {
        text = textField.getText().trim ();
        displayText.setText(text);

    }

}

