package hu.aar;

import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;

import static hu.aar.Megnyitaspop.Opendoc;


public class FoMenu  {

    DocumentModel documentModel = new DocumentModel();

    @FXML
    private TextField textFieldDocumentName;

    @FXML
    private TextArea textAreaDocumentContent;


    @FXML
    public Pane Naptar;
    boolean letezik = false;

    public Mappak[] randomGen() {
        Mappak[] test = new Mappak[9];
        test[0] = new Mappak(1, 5, 0, "name1");
        test[1]  = new Mappak(2, 5, 1, "name2");
        test[2]  = new Mappak(3, 5, 2, "name3");
        test[3]  = new Mappak(4, 5, 3, "name4");
        test[4]  = new Mappak(5, 5, 0, "name5");
        test[5]  = new Mappak(6, 5, 2, "name6");
        test[6]  = new Mappak(7, 5, 2, "name7");
        test[7]  = new Mappak(8, 5, 0, "name8");
        test[8] = new Mappak(9, 5, 0, "name9");
        return test;

    }

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
        String[] neat = {"Volvo", "BMW", "Ford", "Mazda"};
        Opendoc(neat);
        //documentModel.loadDocument(textFieldDocumentName,textAreaDocumentContent);
    }

    public void switchToFolders () throws IOException {
        App.setRoot("Folders");
    }

    public void openFolders () throws IOException {
        Mapsorter map = new Mapsorter(randomGen());
    }


}
