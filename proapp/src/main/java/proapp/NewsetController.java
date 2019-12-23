package proapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class NewsetController {
    public static int ends;
    public int isNumber(String num) {
        try {
            Integer.parseInt(num);
            return 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @FXML
    private ComboBox<String> Admin;
    @FXML
    private ComboBox<String> Place;
    @FXML
    private TextField Assetcode;
    @FXML
    private TextField Asset;
    @FXML
    private TextField Number;

    @FXML
    void initialize() {
        Assetcode.setPromptText("入力されていません"); // 未入力テキスト
        Assetcode.setFocusTraversable(false);
        Asset.setPromptText("入力されていません"); // 未入力テキスト
        Asset.setFocusTraversable(false);
        Admin.setPromptText("選択されていません"); // 未入力テキスト
        Admin.setFocusTraversable(false);
        Place.setPromptText("選択されていません"); // 未入力テキスト
        Place.setFocusTraversable(false);
        Number.setPromptText("入力されていません"); // 未入力テキスト
        Number.setFocusTraversable(false);
        ObservableList<String> items1 = FXCollections.observableArrayList(TeacherController.teacher);
        ObservableList<String> items2 = FXCollections.observableArrayList(PlaceController.place);
        Admin.setItems(items1);
        Place.setItems(items2);
    }

    public void onset(ActionEvent e) {
        ends = 0;
        String AC = Assetcode.getText();
        String AD = Admin.getValue();
        String P = Place.getValue();
        String N = Number.getText();
        if (AC.isEmpty()) {
            try {
                showThirdWindow();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (AD != null && P != null) {
                if(N.isEmpty()) {
                    try {
                        showSecondWindow();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    if (isNumber(N) == 1) {
                        try {
                            showSecondWindow();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        try {
                            showFourthWindow();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            } else {
                try {
                    showThirdWindow();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        if(ends == -1){
            yameru.getScene().getWindow().hide();
        }
    }


    @FXML
    private Button yameru;
    @FXML
    public void onyameru(ActionEvent e)
    {
        yameru.getScene().getWindow().hide();
    }

    void showSecondWindow() throws IOException {
        String AC = Assetcode.getText();
        String A = Asset.getText();
        String AD = Admin.getValue();
        String P = Place.getValue();
        String N = Number.getText();

        if(A.isEmpty()){
            A = "未入力";
        }
        if(N.isEmpty()){
            N = "未入力";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
        Pane root = (Pane) loader.load();
        ((ConfirmationController) loader.getController()).setParam(AC, A, AD, P, N);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }


    void showThirdWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("err1.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    void showFourthWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("err2.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
