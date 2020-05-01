package Adatbazisokbeadando;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Regisztracio {

    @FXML
    Button Registration;



    public void switchToStart() throws IOException {
        App.setRoot("progStart");
    }
}
