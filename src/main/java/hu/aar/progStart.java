package hu.aar;


import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static hu.aar.Hibauzenet.display;

public class progStart {

    LoginModel loginModel = new LoginModel();

    @FXML
    TextField loginEmail;
    @FXML
    PasswordField loginPassword;
    @FXML
    Menu menuUserName;

    public void switchToLoggedIn() throws IOException, SQLException {
        if(loginEmail.getText() == "" || loginPassword.getText().equals("")) {
            display("HIBA", "Hibás felhasználó vagy jelszó");
        }
        if (loginEmail.getText().equals("") && loginPassword.getText().equals("1")) {
            App.setRoot("FoMenu");
        }
       /* if(loginModel.loginUser(loginEmail.getText(),loginPassword.getText())){
                App.setRoot("FoMenu");
        };*/
    }

    public void switchToRegister() throws IOException {
        App.setRoot("Regisztracio");
    }



}
