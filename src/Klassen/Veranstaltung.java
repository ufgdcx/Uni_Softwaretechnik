package Klassen;

import java.util.ArrayList;

public class Veranstaltung {

    String name = new String(); //Veranstaltungsname
    String fakultaet = new String();
    int Teamanzahl; //Teamanzahl je Gruppe
    int maxTeilnehmer; //maximale Teilnehmeranzahl je Team 
    
    ArrayList<Gruppe> gruppen; //Gruppen der Veranstaltung
    ArrayList<Dozent> dozenten; //zugehörige Dozenten

    //getter und setter für Name
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    //getter und setter für Fakultaet
    public String getFakultaet() {

        return fakultaet;
    }

    public void setFakultaet(String fakultaet) {

        this.fakultaet = fakultaet;
    }
    
}
