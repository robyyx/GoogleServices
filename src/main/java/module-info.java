module hu.aar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens hu.aar to javafx.fxml;
    exports hu.aar;
}