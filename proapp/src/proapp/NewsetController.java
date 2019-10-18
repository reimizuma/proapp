package proapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class NewsetController {

    @FXML
    private ComboBox<String> Admin;
    @FXML
    private ComboBox<String> Place;

    @FXML
    void initialize() {
        ObservableList<String> items1 = FXCollections.observableArrayList("宇都木", "島川", "川村");
        ObservableList<String> items2 = FXCollections.observableArrayList("宇都木研究室", "島川研究室", "川村研究室");
        Admin.setItems(items1);
        Place.setItems(items2);
    }

    public void onset(ActionEvent e) {
        try {
            showSecondWindow();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void showSecondWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
