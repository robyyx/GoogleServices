package hu.aar;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Mappak {
    int id;
    int ownId;
    int rootId;
    String name;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnId() {
        return ownId;
    }

    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Mappak mappak){
        this.id = mappak.getId();
        this.ownId = mappak.getOwnId();
        this.rootId = mappak.getRootId();
        this.name = mappak.getName();

    }



    public Mappak(){
        this.id = 0;
        this.ownId = 0;
        this.rootId = 0;
        this.name = "default";
    }

    public Mappak(int id, int ownId, int rootId, String name){
        this.id = id;
        this.ownId = ownId;
        this.rootId = rootId;
        this.name = name;
    }




}
