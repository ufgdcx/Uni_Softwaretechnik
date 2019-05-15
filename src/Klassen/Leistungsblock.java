package Klassen;

import java.util.ArrayList;

public class Leistungsblock {

    private String lbName = new String();

    private Student student;
    private ArrayList<Unterblock> uBloecke; //Unterblöcke
    
    //getter und setter für Klassen.Leistungsblock
    public String getLbName() {

        return lbName;
    }

    public void setLbName(String lbName) {

        this.lbName = lbName;
    }
}
