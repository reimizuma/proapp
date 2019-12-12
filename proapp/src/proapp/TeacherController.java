package proapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TeacherController {
    Text text = null;
    @FXML
    private ListView<String> list;

    @FXML
    private Button aladdin;
    @FXML
    private Button AAA;

    public static ArrayList<String> teacher = filereader.Reader_teacher();

    public Pane pane;


    public void onAAA(){
        //アイテムに入れる文字列を用意する
        ObservableList<String> lm = FXCollections.observableArrayList(teacher);
        //アイテムをセット
        list.setItems(lm);
        //サイズ設定
        list.setPrefSize(200, 100);
        //イベント設定
        list.setOnMouseClicked((MouseEvent event) -> {
            listClicked(event);
        });
    }

    private void listClicked(MouseEvent e) {
        ListView<String> l = (ListView) e.getSource();
        String s = (String) l.getSelectionModel().getSelectedItem();
        if (s == null) {
            return;
        }
        System.out.println(s);
    }

    @FXML
    private void OnaddClick(MouseEvent e)  {
        try {
            showFifthWindow();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        teacher.add(addController.getadd());
        ObservableList<String> lm = FXCollections.observableArrayList(teacher);
        //既存のアイテムをクリアする
        list.getItems().clear();
        //新たなアイテムをセット
        list.setItems(lm);
    }

    void showFifthWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
