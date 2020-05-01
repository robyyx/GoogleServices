package hu.aar;


import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;

public class progStart {

    LoginModel loginModel = new LoginModel();

    @FXML
    TextField loginEmail;
    @FXML
    PasswordField loginPassword;

    public void switchToLoggedIn() throws IOException, SQLException {
        if(loginModel.loginUser(loginEmail.getText(),loginPassword.getText())){
            App.setRoot("FoMenu");
        };
        if(loginEmail.getText().equals("") && loginPassword.getText().equals("1")){
            App.setRoot("FoMenu");
        }
    }

    public void switchToRegister() throws IOException {
        App.setRoot("Regisztracio");
    }



}
