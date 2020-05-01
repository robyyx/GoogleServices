package hu.aar;

import hu.aar.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.YearMonth;


public class FoMenu  {



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

    public void switchToEventModifier () throws IOException {
        App.setRoot("EsemenyModositas");
    }

    public void switchToGroups() throws IOException {
        App.setRoot("CsoportokMegtekintese");
    }



}
