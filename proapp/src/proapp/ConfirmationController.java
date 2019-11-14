package proapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

        try {
            FileWriter f = new FileWriter("data1.csv", true);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));

            p.print(AC);
            p.print(",");
            p.print(A);
            p.print(",");
            p.print(AD);
            p.print(",");
            p.print(P);
            p.print(",");
            p.print(N);
            p.println();

            p.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        hai.getScene().getWindow().hide();
    }
}
