package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static proapp.NewsetController.ends;

public class setclearController {
    @FXML
    private Button back;

    @FXML
    public void onback(ActionEvent e) {
        back.getScene().getWindow().hide();
    }

    @FXML
    public void onend(ActionEvent e) {
        back.getScene().getWindow().hide();
        ends = -1;
    }
}
