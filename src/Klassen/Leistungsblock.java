package Klassen;

import java.util.ArrayList;

public class Leistungsblock {

    String lbName = new String();

    Student student;
    ArrayList<Unterblock> uBloecke; //Unterblöcke
    
    //getter und setter für Klassen.Leistungsblock
    public String getLbName() {

        return lbName;
    }

    public void setLbName(String lbName) {

        this.lbName = lbName;
    }
}
