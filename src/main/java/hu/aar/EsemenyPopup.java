package hu.aar;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EsemenyPopup {

    public EsemenyPopup(String[] string){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Dokumentumok");
        window.setMinWidth(100);


        VBox vbox = new VBox();

        Button closeButton = new Button("Oké");
        closeButton.setOnAction(e -> window.close());
        closeButton.setLineSpacing(60.0);

        for (String nev: string) {
            Text text = new Text(nev);
            text.setLineSpacing(25.0);
            text.setOnMouseClicked(
                    event -> {
                        System.out.println(nev);
                    }
            );
            vbox.getChildren().add(text);
        }

        vbox.getChildren().add(closeButton);
        vbox.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

}

