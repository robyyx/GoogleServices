package hu.aar;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static hu.aar.Hibauzenet.display;

public class Regisztracio {

    private RegistrationModel registrationModel = new RegistrationModel();

    @FXML
    TextField registerFieldName;
    @FXML
    TextField registerFieldEmail;
    @FXML
    PasswordField registerFieldPassword;
    @FXML
    PasswordField registerFieldPasswordAgain;


    public void switchToStart() throws IOException {
        App.setRoot("progStart");
    }

    public void registerUser() throws IOException, SQLException {
        if (registerFieldPassword.getText().equals("")|| registerFieldEmail.getText() == "" || registerFieldPasswordAgain.getText().equals("") || registerFieldName.getText() == ""){
            display("HIBA", "Valamelyik érték nincs megadva");
        } else if  (!registerFieldPassword.getText().equals(registerFieldPasswordAgain.getText())) {
            display("HIBA", "Jelszavak nem egyeznek");
        } else {
           /* registrationModel.createUser(registerFieldEmail.getText(), registerFieldName.getText(), registerFieldPassword.getText());
            App.setRoot("progStart");*/
        }
    }
}
