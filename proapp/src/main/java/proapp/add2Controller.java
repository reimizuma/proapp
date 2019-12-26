package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static proapp.PlaceController.place;

public class add2Controller {
    public static String item;
    @FXML
    private TextField addadmin;
    @FXML
    private Button button;
    @FXML
    protected void onClick(ActionEvent evt){
        if(addadmin.getText().isEmpty()){
            button.getScene().getWindow().hide();
        }
        place.add(item = addadmin.getText());
        // 既存のアイテムをクリアする
        button.getScene().getWindow().hide();

    }
}

