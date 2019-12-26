package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConfirmationController {

    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Text text5;

    public void setParam(String AC, String A, String AD, String P, String N) {
        text1.setText(AC);
        text2.setText(A);
        text3.setText(AD);
        text4.setText(P);
        text5.setText(N);
    }

    @FXML
    private Button iie;
    @FXML
    private Button hai;

    @FXML
    public void oniie(ActionEvent e) {
        iie.getScene().getWindow().hide();
    }

    public void onhai(ActionEvent e) {

        String AC = text1.getText();
        String A = text2.getText();
        String AD = text3.getText();
        String P = text4.getText();
        String N = text5.getText();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
        String strDate = sdf.format(cal.getTime());
        try {
            PrintWriter p = new PrintWriter(new BufferedWriter((new OutputStreamWriter(new FileOutputStream("data1.csv",true),StandardCharsets.UTF_8))));

            p.print(AC);
            p.print(",");
            p.print(A);
            p.print(",");
            p.print(AD);
            p.print(",");
            p.print(P);
            p.print(",");
            p.print(N);
            p.print(",");
            p.print(strDate);
            p.println();

            p.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            showSecondWindow();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        hai.getScene().getWindow().hide();
    }

    void showSecondWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("setclear.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
