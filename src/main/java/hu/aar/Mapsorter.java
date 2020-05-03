package hu.aar;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static java.lang.StrictMath.random;

public class Mapsorter {
    Mappak root;
    int m = 0;

    public void findRoot(Mappak[] mappak, VBox vbox) {
        for (int i = 0; i < mappak.length; i++) {
            if (mappak[i].getRootId() == 0) {
                Text text = new Text(mappak[i].name + " root");
                vbox.getChildren().add(text);
                root = mappak[i];
                sorter(mappak, vbox, root);
            }
        }
    }

    public void sorter (Mappak[] mappak, VBox vbox, Mappak rootmap){

       for (int j = 0; j < mappak.length; j++) {
           if (rootmap.id == mappak[j].getRootId()){
               m++;
               Text text = new Text(mappak[j].name);

               HBox hbox = new HBox();
               for (int p = 0; p < m; p++){
                   Text space = new Text("    ");
                   hbox.getChildren().add(space);
               }
               hbox.getChildren().add(text);
               vbox.getChildren().add(hbox);
               Mappak folder =  mappak[j];
               sorter(mappak, vbox, folder);
           }
           if(j == mappak.length - 1){
               m =0;
           }
       }
    }

    public Mapsorter (Mappak[] mappak){
        VBox vbox = new VBox();
        findRoot(mappak, vbox);
        sorter(mappak, vbox, root);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Mappak");
        window.setMinWidth(200);
        window.setMinHeight(400);

        Button closeButton = new Button("Bezár");
        closeButton.setOnAction(e -> window.close());
        closeButton.setLineSpacing(60.0);
        vbox.getChildren().add(closeButton);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }


}