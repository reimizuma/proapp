package proapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import java.io.*;
import javafx.fxml.FXML;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import java.lang.String;

public class ProappController {

    private static int tabledatecount;

    private static ArrayList<Integer> counter = new ArrayList<Integer>();

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
    @FXML
    private TableColumn checkCol;
    @FXML
    private TableColumn DayCol;
    @FXML
    private ObservableList<Data> data;

    @FXML
    private ComboBox<String> search1;
    @FXML
    private ComboBox<String> search2;

    @FXML
    private int count;

    public ContextMenu menu = new ContextMenu();

    public MenuItem[] menui = new MenuItem[1];

    public int isNumber(String num) {
        try {
            Integer.parseInt(num);
            return 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void dateset(){
        String N = search2.getValue();
        if (N == null) {

        } else if(N.isEmpty()) {

        } else {
            data.clear();
            counter.clear();
            count = 0;
            int L;
            Object itemsXXX = search1.getValue();
            Object itemsXX = search2.getValue();
            FileInputStream fi = null;
            InputStreamReader is = null;
            BufferedReader br = null;
            try {
                // 読み込みファイルのインスタンス生成
                // ファイル名を指定する
                fi = new FileInputStream("data1.csv");
                is = new InputStreamReader(fi, StandardCharsets.UTF_8);
                br = new BufferedReader(is);
                // 読み込み行
                String line;
                // 1行ずつ読み込みを行う
                while ((line = br.readLine()) != null) {
                    // カンマで分割した内容を配列に格納する
                    String[] data1 = line.split(",");
                    // 配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                    int colno = 0;
                    int colno1 = 1;
                    int colno2 = 2;
                    int colno3 = 3;
                    int colno4 = 4;
                    int colno5 = 5;
                    count++;
                    if (itemsXXX == "資産コード") {
                        String ASSETCODE = search2.getValue();
                        if (ASSETCODE != null) {
                            int a = ASSETCODE.length();
                            int b = data1[colno].length();
                            if (b >= a) {
                                String XXXX = data1[colno].substring(0, a);
                                if (XXXX.equals(ASSETCODE)) {
                                    data.addAll(new Data(false, data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4], data1[colno5]));
                                    counter.add(count);
                                }
                            }
                        }
                    } else if (itemsXXX == "管理者") {
                        for (L = 0; L < TeacherController.teacher.size(); L++) {
                            if (itemsXX == TeacherController.teacher.get(L) && data1[colno2].equals(TeacherController.teacher.get(L))) {
                                data.addAll(new Data(false, data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4], data1[colno5]));
                                counter.add(count);
                            }
                        }
                    } else {
                        for (L = 0; L < PlaceController.place.size(); L++) {
                            if (itemsXX == PlaceController.place.get(L) && data1[colno3].equals(PlaceController.place.get(L))) {
                                data.addAll(new Data(false, data1[colno], data1[colno1], data1[colno2], data1[colno3], data1[colno4], data1[colno5]));
                                counter.add(count);
                            }
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
            tabledatecount = counter.size();
        }
    }

    @FXML
    void initialize() {
        table.setOnMouseClicked(this::mouseClicked);

        tabledatecount = -1;

        menui[0] = new MenuItem( "削除" );
        menu.getItems().addAll( menui );
        menu.equals("削除");

        counter.add(-1);

        ObservableList<String> items1 = FXCollections.observableArrayList("資産コード", "管理者", "管理場所");

        search1.setItems(items1);

        data = FXCollections.observableArrayList();
        table.itemsProperty().setValue(data);
        table.setItems(data);

        checkCol.setCellValueFactory(new PropertyValueFactory<Data, Boolean>("Check"));
        AssetcodeCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Assetcode"));
        AssetCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Asset"));
        AdminCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Admin"));
        PlaceCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Place"));
        NumberCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Number"));
        DayCol.setCellValueFactory(new PropertyValueFactory<Data, String>("Day"));


        table.setEditable(true);
        AssetcodeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        AssetCol.setCellFactory(TextFieldTableCell.forTableColumn());
        AdminCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(TeacherController.teacher.toArray()));
        PlaceCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(PlaceController.place.toArray()));
        NumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseButton.SECONDARY) {
            menu.show( table , e.getScreenX() , e.getScreenY() );
            menu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        ShowSevensWindow();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    if (checkController.check.equals("true")) {
                        checkController.check = "false";
                        int a = 0;
                        int i;
                        TableView.TableViewSelectionModel<Data> selectionModel = table.getSelectionModel();
                        i = selectionModel.getSelectedIndex();
                        if (i != -1 || tabledatecount > 0) {
                            ArrayList<ArrayList<String>> dateX = new ArrayList<ArrayList<String>>();
                            ArrayList<Boolean> dateC = new ArrayList<Boolean>();
                            for (a = 0; a < tabledatecount; a++) {
                                ArrayList<String> dateXX = new ArrayList<String>();
                                if (i != a) {
                                    dateC.add(data.get(a).getCheck());
                                    dateXX.add(data.get(a).getAssetcode());
                                    dateXX.add(data.get(a).getAsset());
                                    dateXX.add(data.get(a).getAdmin());
                                    dateXX.add(data.get(a).getPlace());
                                    dateXX.add(data.get(a).getNumber());
                                    dateXX.add(data.get(a).getDay());
                                    dateX.add(dateXX);
                                }
                            }
                            tabledatecount = tabledatecount - 1;
                            data.clear();
                            for (a = 0; a < tabledatecount; a++) {
                                data.addAll(new Data(dateC.get(a), dateX.get(a).get(0), dateX.get(a).get(1), dateX.get(a).get(2), dateX.get(a).get(3), dateX.get(a).get(4), dateX.get(a).get(5)));
                            }
                        }
                    }
                }
            });
        }else{
            menu.hide();
        }
    }

    @FXML
    public void onnewset(ActionEvent e) {
        try {
            showSecondWindow();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        dateset();
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
        int check = 0;
        int l = 0;
        int errCount = 0;
        int errCount2 = 0;
        int errCount3 = 0;
        for (check = 0; check < tabledatecount; check++) {
            if (data.get(check).getNumber().equals("未入力") || data.get(check).getNumber().isEmpty()) {
            } else {
                if (isNumber(data.get(check).getNumber()) != 1 || data.get(check).getNumber().equals("-") || data.get(check).getNumber().equals("ー")){
                    errCount++;
                } else {
                    int num = Integer.parseInt(data.get(check).getNumber());
                    if (num < 1) {
                        errCount2++;
                    }
                }
            }
            if(data.get(check).getAssetcode().isEmpty()){
                errCount3++;
            }
        }
        if(errCount3 == 0){
        if (errCount == 0) {
            if (errCount2 == 0) {
                int count = 0;
                int i = 0;
                int j = 0;

                ArrayList<ArrayList<String>> dates = new ArrayList<ArrayList<String>>();

                FileInputStream fi = null;
                InputStreamReader is = null;
                BufferedReader br = null;
                try {
                    // 読み込みファイルのインスタンス生成
                    // ファイル名を指定する
                    fi = new FileInputStream("data1.csv");
                    is = new InputStreamReader(fi, StandardCharsets.UTF_8);
                    br = new BufferedReader(is);
                    // 読み込み行
                    String line;
                    // 1行ずつ読み込みを行う
                    while ((line = br.readLine()) != null) {
                        ArrayList<String> date2 = new ArrayList<String>();
                        // カンマで分割した内容を配列に格納する
                        String[] data1 = line.split(",");
                        // 配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                        for (j = 0; j < data1.length; j++) {
                            date2.add(data1[j]);
                        }
                        count++;
                        if (count != counter.get(i)) {
                            dates.add(date2);
                        } else if (counter.size() - 1 >= i + 1) {
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

                for (i = 0; i < dates.size(); i++) {
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
                        p.print(",");
                        p.print(dates.get(i).get(5));
                        p.println();
                        p.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if (tabledatecount != -1) {
                    for (i = 0; i < tabledatecount; i++) {
                        try {
                            FileWriter f = new FileWriter("data1.csv", true);
                            PrintWriter p = new PrintWriter(new BufferedWriter(f));
                            p.print(data.get(i).getAssetcode());
                            p.print(",");
                            if(data.get(i).getAsset().isEmpty()){
                                p.print("未入力");
                                p.print(",");
                            }else {
                                p.print(data.get(i).getAsset());
                                p.print(",");
                            }
                            p.print(data.get(i).getAdmin());
                            p.print(",");
                            p.print(data.get(i).getPlace());
                            p.print(",");
                            if(data.get(i).getNumber().isEmpty()){
                                p.print("未入力");
                                p.print(",");
                            }else {
                                p.print(data.get(i).getNumber());
                                p.print(",");
                            }
                            if (data.get(i).getCheck() == true) {
                                Calendar cal = Calendar.getInstance();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
                                String strDate = sdf.format(cal.getTime());
                                p.print(strDate);
                            } else {
                                p.print(data.get(i).getDay());
                            }
                            p.println();
                            p.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if (counter.get(0) != -1) {
                    count = 0;
                    counter.clear();
                    Object itemsXXX = search1.getValue();
                    Object itemsXX = search2.getValue();
                    try {
                        // 読み込みファイルのインスタンス生成
                        // ファイル名を指定する
                        fi = new FileInputStream("data1.csv");
                        is = new InputStreamReader(fi, StandardCharsets.UTF_8);
                        br = new BufferedReader(is);
                        // 読み込み行
                        String line;
                        // 1行ずつ読み込みを行う
                        while ((line = br.readLine()) != null) {
                            // カンマで分割した内容を配列に格納する
                            String[] data1 = line.split(",");
                            // 配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す
                            int colno = 0;
                            int colno2 = 2;
                            int colno3 = 3;
                            count++;
                            if (itemsXXX == "資産コード") {
                                String ASSETCODE = search2.getValue();
                                int a = ASSETCODE.length();
                                int b = data1[colno].length();
                                if (b >= a) {
                                    String XXXX = data1[colno].substring(0, a);
                                    if (XXXX.equals(ASSETCODE)) {
                                        counter.add(count);
                                    }
                                }
                            } else if (itemsXXX == "管理者") {
                                for (l = 0; l < TeacherController.teacher.size(); l++) {
                                    if (itemsXX == TeacherController.teacher.get(l) && data1[colno2].equals(TeacherController.teacher.get(l))) {
                                        counter.add(count);
                                    }
                                }
                            } else {
                                for (l = 0; l < PlaceController.place.size(); l++) {
                                    if (itemsXX == PlaceController.place.get(l) && data1[colno3].equals(PlaceController.place.get(l))) {
                                        counter.add(count);
                                    }
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
                try {
                    showFourthWindow();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                dateset();
            } else {
                try {
                    showFifthWindow();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            } else {
                try {
                    ShowEightWindow();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            try {
                ShowNineWindow();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    public void selecter1(ActionEvent e) {
        search2.setEditable(false);
        checkCol.setCellFactory(CheckBoxTableCell.forTableColumn(checkCol));
        ObservableList<String> items3 = FXCollections.observableArrayList(TeacherController.teacher);
        ObservableList<String> items4 = FXCollections.observableArrayList(PlaceController.place);
        ObservableList<String> items2 = FXCollections.observableArrayList("");

        Object itemsXX = search1.getValue();

        if (itemsXX == "資産コード") {
            search2.setItems(items2);
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
        dateset();
    }

    public void onteacher(ActionEvent e){
        try{
            showThirdWindow();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        AdminCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(TeacherController.teacher.toArray()));
        ObservableList<String> items3 = FXCollections.observableArrayList(TeacherController.teacher);
        search2.setItems(items3);
    }

    public void onplace(ActionEvent e){
        try{
            showSixWindow();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        PlaceCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(PlaceController.place.toArray()));
        ObservableList<String> items4 = FXCollections.observableArrayList(PlaceController.place);
        search2.setItems(items4);
    }

    void showThirdWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacher.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void showFourthWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changeclear.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void showFifthWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("err2.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void showSixWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Place.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void ShowSevensWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("check.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void ShowEightWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("err3.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    void ShowNineWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("err4.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
