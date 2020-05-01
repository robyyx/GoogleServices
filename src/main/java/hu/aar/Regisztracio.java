package hu.aar;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

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
        registrationModel.createUser(registerFieldEmail.getText(), registerFieldName.getText(), registerFieldPassword.getText());
        App.setRoot("progStart");
    }
}
