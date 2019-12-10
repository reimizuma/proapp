package proapp;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;

import java.io.*;

import javafx.fxml.FXML;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class ProappController {

    private static ArrayList<Integer> counter = new ArrayList<Integer>();
    private static int CT = 0;

    @FXML
    private TableView table;
    @FXML
    private TableColumn AssetcodeCol;
    @FXML
    private TableColumn AssetCol;
    @FXML
    private TableColumn AdminCol;
    @FXML
    private TableColumn PlaceCol;
    @FXML
    private TableColumn NumberCol;
    private ObservableList<Data> data;

    @FXML
    private TableColumn checkCol;

    @FXML
    private ComboBox<String> search1;
    @FXML
    private ComboBox<String> search2;

    @FXML
    private int count;

    @FXML
    void initialize() {

        counter.add(-1);

        ObservableList<String> items1 = FXCollections.observableArrayList("資産コード", "管理者", "管理場所");

        search1.setItems(items1);

        data = FXCollections.observableArrayList();
        table.itemsProperty().setValue(data);
        table.setItems(data);


        AssetcodeCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Assetcode"));
        AssetCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Asset"));
        AdminCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Admin"));
        PlaceCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Place"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Number"));

        table.setEditable(true);
        AssetcodeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        AssetCol.setCellFactory(TextFieldTableCell.forTableColumn());
        AdminCol.setCellFactory(TextFieldTableCell.forTableColumn());
        PlaceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        NumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    public void onnewset(ActionEvent e) {
        try {
            showSecondWindow();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void showSecondWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newset.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void onchange(ActionEvent e) {

        int count = 0;
        int i = 0;
        int j = 0;

        ArrayList<ArrayList<String>> dates = new ArrayList<ArrayList<String>>();

        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try {
            //読み込みファイルのインスタンス生成
            //ファイル名を指定する
            fi = new FileInputStream("data1.csv");
            is = new InputStreamReader(fi, "UTF-8");
            br = new BufferedReader(is);
            //読み込み行
            String line;
            //1行ずつ読み込みを行う
            while ((line = br.readLine()) != null) {
                ArrayList<String> date2 = new ArrayList<String>();
                //カンマで分割した内容を配列に格納する
                String[] data1 = line.split(",");
                //配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                for(j = 0; j < data1.length; j++){
                    date2.add(data1[j]);
                }
                count++;
                    if (count != counter.get(i)) {
                        dates.add(date2);
                    } else if(counter.size() - 1 >= i + 1){
                        i++;
                    }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        File file = new File("data1.csv");
        file.delete();

        for(i = 0; i < dates.size(); i++) {
            try {
                FileWriter f = new FileWriter("data1.csv", true);
                PrintWriter p = new PrintWriter(new BufferedWriter(f));
                p.print(dates.get(i).get(0));
                p.print(",");
                p.print(dates.get(i).get(1));
                p.print(",");
                p.print(dates.get(i).get(2));
                p.print(",");
                p.print(dates.get(i).get(3));
                p.print(",");
                p.print(dates.get(i).get(4));
                p.println();
                p.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(counter.get(0) != -1) {
            for (i = 0; i < counter.size(); i++) {
                try {
                    FileWriter f = new FileWriter("data1.csv", true);
                    PrintWriter p = new PrintWriter(new BufferedWriter(f));
                    p.print(data.get(i).getAssetcode());
                    p.print(",");
                    p.print(data.get(i).getAsset());
                    p.print(",");
                    p.print(data.get(i).getAdmin());
                    p.print(",");
                    p.print(data.get(i).getPlace());
                    p.print(",");
                    p.print(data.get(i).getNumber());
                    p.println();
                    p.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if(counter.get(0) != -1) {
            count = 0;
            counter.clear();
            Object itemsXXX = search1.getValue();
            Object itemsXX = search2.getValue();
            try {
                //読み込みファイルのインスタンス生成
                //ファイル名を指定する
                fi = new FileInputStream("data1.csv");
                is = new InputStreamReader(fi, "UTF-8");
                br = new BufferedReader(is);
                //読み込み行
                String line;
                //1行ずつ読み込みを行う
                while ((line = br.readLine()) != null) {
                    //カンマで分割した内容を配列に格納する
                    String[] data1 = line.split(",");
                    //配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                    int colno = 0;
                    int colno2 = 2;
                    int colno3 = 3;
                    count++;
                    if (itemsXXX == "資産コード") {
                        Object ASSETCODE = search2.getValue();
                        if (data1[colno].equals(ASSETCODE)) {
                            counter.add(count);
                        }
                    } else if (itemsXXX == "管理者") {
                        if (itemsXX == "宇都木" && data1[colno2].equals("宇都木")) {
                            counter.add(count);
                        } else if (itemsXX == "島川" && data1[colno2].equals("島川")) {
                            counter.add(count);
                        } else if (itemsXX == "宮田" && data1[colno2].equals("宮田")) {
                            counter.add(count);
                        } else if (itemsXX == "山野辺" && data1[colno2].equals("山野辺")) {
                            counter.add(count);
                        } else if (itemsXX == "佐藤" && data1[colno2].equals("佐藤")) {
                            counter.add(count);
                        } else if (itemsXX == "大島" && data1[colno2].equals("大島")) {
                            counter.add(count);
                        } else if (itemsXX == "川村" && data1[colno2].equals("川村")) {
                            counter.add(count);
                        } else if (itemsXX == "須志田" && data1[colno2].equals("須志田")) {
                            counter.add(count);
                        } else if (itemsXX == "内田" && data1[colno2].equals("内田")) {
                            counter.add(count);
                        }
                    } else {
                        if (itemsXX == "宇都木研" && data1[colno3].equals("宇都木研")) {
                            counter.add(count);
                        } else if (itemsXX == "島川研" && data1[colno3].equals("島川研")) {
                            counter.add(count);
                        } else if (itemsXX == "宮田研" && data1[colno3].equals("宮田研")) {
                            counter.add(count);
                        } else if (itemsXX == "山野辺研" && data1[colno3].equals("山野辺研")) {
                            counter.add(count);
                        } else if (itemsXX == "佐藤研" && data1[colno3].equals("佐藤研")) {
                            counter.add(count);
                        } else if (itemsXX == "大島研" && data1[colno3].equals("大島研")) {
                            counter.add(count);
                        } else if (itemsXX == "川村研" && data1[colno3].equals("川村研")) {
                            counter.add(count);
                        } else if (itemsXX == "須志田研" && data1[colno3].equals("須志田研")) {
                            counter.add(count);
                        } else if (itemsXX == "内田研" && data1[colno3].equals("内田研")) {
                            counter.add(count);
                        }
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void selecter1(ActionEvent e) {
        search2.setEditable(false);
        checkCol.setCellFactory(CheckBoxTableCell.forTableColumn(checkCol));
        ObservableList<String> items3 = FXCollections.observableArrayList("宇都木", "島川", "宮田", "川村", "内田", "山野辺", "大島", "須志田", "佐藤");
        ObservableList<String> items4 = FXCollections.observableArrayList("宇都木研", "島川研", "宮田研", "川村研", "内田研", "山野辺研", "大島研", "須志田研", "佐藤研");

        Object itemsXX = search1.getValue();

        if (itemsXX == "資産コード") {
            search2.getItems().clear();
            search2.setEditable(true);
        } else if (itemsXX == "管理者") {
            search2.getItems().clear();
            search2.setItems(items3);
        } else if (itemsXX == "管理場所") {
            search2.getItems().clear();
            search2.setItems(items4);
        }
    }

    @FXML
    public void selecter2(ActionEvent e) {
        data.clear();
        counter.clear();
        count = 0;
        Object itemsXXX = search1.getValue();
        Object itemsXX = search2.getValue();
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try {
            //読み込みファイルのインスタンス生成
            //ファイル名を指定する
            fi = new FileInputStream("data1.csv");
            is = new InputStreamReader(fi,"UTF-8");
            br = new BufferedReader(is);
            //読み込み行
            String line;
            //1行ずつ読み込みを行う
            while ((line = br.readLine()) != null) {
                //カンマで分割した内容を配列に格納する
                String[] data1 = line.split(",");
                //配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                int colno = 0;
                int colno1 = 1;
                int colno2 = 2;
                int colno3 = 3;
                int colno4 = 4;
                count++;
                if (itemsXXX == "資産コード") {
                    String ASSETCODE = search2.getValue();
                    int a = ASSETCODE.length();
                    int b = data1[colno].length();
                    if(b >= a) {
                        String XXXX = data1[colno].substring(0, a);
                        if (XXXX.equals(ASSETCODE)) {
                            data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                            counter.add(count);
                        }
                    }
                } else if (itemsXXX == "管理者") {
                    if(itemsXX == "宇都木" && data1[colno2].equals("宇都木")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "島川" && data1[colno2].equals("島川")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "宮田" && data1[colno2].equals("宮田")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "山野辺" && data1[colno2].equals("山野辺")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "佐藤" && data1[colno2].equals("佐藤")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "大島" && data1[colno2].equals("大島")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "川村" && data1[colno2].equals("川村")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "須志田" && data1[colno2].equals("須志田")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "内田" && data1[colno2].equals("内田")) {
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }
                }else{
                    if(itemsXX == "宇都木研" && data1[colno3].equals("宇都木研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "島川研" && data1[colno3].equals("島川研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "宮田研" && data1[colno3].equals("宮田研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "山野辺研" && data1[colno3].equals("山野辺研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "佐藤研" && data1[colno3].equals("佐藤研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "大島研" && data1[colno3].equals("大島研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "川村研" && data1[colno3].equals("川村研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "須志田研" && data1[colno3].equals("須志田研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }else if(itemsXX == "内田研" && data1[colno3].equals("内田研")){
                        data.addAll(new Data(data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4]));
                        counter.add(count);
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
