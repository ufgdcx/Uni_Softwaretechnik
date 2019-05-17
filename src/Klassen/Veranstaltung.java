package Klassen;

import java.util.ArrayList;

public class Veranstaltung {

    private String name; //Veranstaltungsname
    private String fakultaet;
    private int Teamanzahl; //Teamanzahl je Gruppe
    private int maxTeilnehmer; //maximale Teilnehmeranzahl je Team

    private ArrayList<Gruppe> gruppen; //Gruppen der Veranstaltung
    private ArrayList<Dozent> dozenten; //zugehörige Dozenten

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
