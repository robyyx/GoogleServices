package Adatbazisokbeadando;


import Adatbazisokbeadando.Naptar.FullCalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.YearMonth;

public class progStart {

    @FXML
    Button login;
    @FXML
    Button register;

    FoMenu fomenu =new FoMenu();

    public void switchToLoggedIn() throws IOException {
        App.setRoot("FoMenu");

    }

    public void switchToRegister() throws IOException {
        App.setRoot("Regisztracio");
    }



}
