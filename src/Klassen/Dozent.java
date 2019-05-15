package Klassen;

import java.util.ArrayList;

public class Dozent extends Nutzer{

    private String fakultaet = new String();
    
    private  ArrayList<Veranstaltung> veranstaltungen; //von Dozenten geleitete Veranstaltungen
    private ArrayList<Gruppe> gruppen; //von Dozenten betreute Gruppen

    public Dozent(String email,String passwort, String titel, String vorname, String name, String fakultaet){
        super(email,passwort,titel,vorname,name);
        this.fakultaet = fakultaet;
    }
    //getter und setter für Fakultaet
    public String getFakultaet() {

        return fakultaet;
    }

    public void setFakultaet(String fakultaet) {

        this.fakultaet = fakultaet;
    }
}
