package hu.aar;


import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
