module hu.aar {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.aar to javafx.fxml;
    exports hu.aar;
}