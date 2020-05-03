package hu.aar;

import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;


public class FoMenu  {

    DocumentModel documentModel = new DocumentModel();
    LoginModel loginModel = new LoginModel();
    EventModel eventModel = new EventModel();

    @FXML
    private TextField textFieldDocumentName;

    @FXML
    private TextArea textAreaDocumentContent;


    @FXML
    public Pane Naptar;
    boolean letezik = false;


    public void addCalendar () throws IOException{
    if (letezik == false) {
        Naptar.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
      letezik = !letezik;
            }
    }

    public void switchToDocuments () throws IOException {
        App.setRoot("Documents");
     }

    public void switchToCalendar () throws IOException {
        App.setRoot("FoMenu");
    }

    public void switchToEventCreator () throws IOException {
        App.setRoot("Esemenykeszitese");
    }

    public void switchToGroups() throws IOException {
        App.setRoot("CsoportokMegtekintese");
    }

    public void clearDocument(){
        textFieldDocumentName.setText("");
        textAreaDocumentContent.setText("");
    }

    public void saveDocumentToRootFolder() throws SQLException {
        documentModel.saveDocumentToRootFolder(textFieldDocumentName.getText(), textAreaDocumentContent.getText());
    }

    public void loadDocument() throws SQLException {
        documentModel.loadDocument(textFieldDocumentName,textAreaDocumentContent);
    }

    public void logOut() throws IOException, SQLException {
        loginModel.logoutUser();
        App.setRoot("progStart");
    }


    @FXML
    TextField textFieldEventName;

    @FXML
    DatePicker datePickerEventDate;

    @FXML
    TextArea textAreaEventDescription;

    public void clearEventFields(){
        textFieldEventName.setText("");
        datePickerEventDate.setValue(null);
        textAreaEventDescription.setText("");
    }

    public void saveEvent() throws SQLException {

        eventModel.saveEventToOwnCalendar(textFieldEventName.getText(), datePickerEventDate.getValue(), textAreaEventDescription.getText());
    }

}
