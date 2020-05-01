package hu.aar;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

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
