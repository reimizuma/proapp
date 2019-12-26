module proapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens proapp to javafx.fxml;
    exports proapp;
}
