package Klassen;

import java.util.ArrayList;

public class Dozent extends Nutzer{

    String fakultaet = new String();
    
    ArrayList<Veranstaltung> veranstaltungen; //von Dozenten geleitete Veranstaltungen
    ArrayList<Gruppe> gruppen; //von Dozenten betreute Gruppen
    
    //getter und setter für Fakultaet
    public String getFakultaet() {

        return fakultaet;
    }

    public void setFakultaet(String fakultaet) {

        this.fakultaet = fakultaet;
    }
}
