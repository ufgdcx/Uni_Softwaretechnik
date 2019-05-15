package Klassen;

import java.util.ArrayList;

public class Gruppe {

    private  int gruppenID;
    private String email = new String(); //E-Mailadresse des zuständigen Dozenten
    private String tag = new String(); //Wochentag
    private String zeit = new String(); //Uhrzeit
    private String rhythmus = new String(); //Wochenrhythmus
    private String frist = new String(); //Einschreibungsfrist

    private Veranstaltung veranstaltung;
    private ArrayList<Team> teams;
    private Dozent dozent;
    
    //getter und setter für Tag
    public String getTag() {

        return tag;
    }

    public void setTag(String tag) {

        this.tag = tag;
    }

    //getter und setter für Zeit
    public String getZeit() {

        return zeit;
    }

    public void setZeit(String zeit) {

        this.zeit = zeit;
    }

    //getter und setter für Einschreibungsfrist
    public String getFrist() {

        return frist;
    }

    public void setFrist(String frist) {

        this.frist = frist;
    }
}
