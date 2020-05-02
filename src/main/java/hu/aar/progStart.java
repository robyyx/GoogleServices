package hu.aar;


import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Popup;


import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;

import static hu.aar.Hibauzenet.display;

public class progStart {

    LoginModel loginModel = new LoginModel();

    @FXML
    TextField loginEmail;
    @FXML
    PasswordField loginPassword;

    public void switchToLoggedIn() throws IOException, SQLException {
        if(loginEmail.getText() == "" || loginPassword.getText().equals("")) {
            display("HIBA", "Hibás felhasználó vagy jelszó");
        }
        if (loginEmail.getText().equals("") && loginPassword.getText().equals("1")) {
            App.setRoot("FoMenu");
        }
        /*if(loginModel.loginUser(loginEmail.getText(),loginPassword.getText())){
                App.setRoot("FoMenu");
            };*/
    }

    public void switchToRegister() throws IOException {
        App.setRoot("Regisztracio");
    }



}
