package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addController {
    public static String item;
    @FXML
    private TextField addadmin;
    @FXML
    private Button button;
    @FXML
    protected void onClick(ActionEvent evt){
        item = addadmin.getText();
        button.getScene().getWindow().hide();
    }

    public static String getadd(){
        return item;
    }
}
