package proapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static proapp.TeacherController.teacher;

public class addController {
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
        teacher.add(item = addadmin.getText());
        //既存のアイテムをクリアする
        button.getScene().getWindow().hide();

    }
}

