package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class err1Controller {
    @FXML
    private Button back;

    @FXML
    public void onback(ActionEvent e) {
        back.getScene().getWindow().hide();
    }
}
