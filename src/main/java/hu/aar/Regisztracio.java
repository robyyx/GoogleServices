package hu.aar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Regisztracio {

    registrationModel registrationModel = new registrationModel();

    @FXML
    Button Registration;
    @FXML
    TextField registerFieldName;
    @FXML
    TextField registerFieldEmail;
    @FXML
    TextField registerFieldPassword;
    @FXML
    TextField registerFieldPasswordAgain;


    public void switchToStart() throws IOException {
        App.setRoot("progStart");
    }

    public void registerUser() throws IOException {
        registrationModel.createUser(registerFieldEmail.getText(), registerFieldName.getText(), registerFieldPassword.getText());
    }
}
