package Adatbazisokbeadando;

import Adatbazisokbeadando.Naptar.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.YearMonth;


public class FoMenu  {



    @FXML
    Pane NaptarPane;

    public void switchToCreateDocument () throws IOException {

        App.setRoot("CreateDoc");

     }

    public void switchToCalendar () throws IOException {
        NaptarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
    }

}
