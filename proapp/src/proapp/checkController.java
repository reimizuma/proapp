package proapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class checkController {
    public static String check = "false";
    @FXML
    private Button inter;
    @FXML
    private Button remove;
    @FXML
    private void OnremoveClick(){
        check = "true";
        remove.getScene().getWindow().hide();
    }
    @FXML
    private void OninterruptionClick(){
        check = "false";
        inter.getScene().getWindow().hide();
    }

}
