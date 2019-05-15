package Klassen;

import java.util.ArrayList;

public class Gruppe {

    int gruppenID;
    String email = new String(); //E-Mailadresse des zuständigen Dozenten
    String tag = new String(); //Wochentag
    String zeit = new String(); //Uhrzeit
    String rhythmus = new String(); //Wochenrhythmus
    String frist = new String(); //Einschreibungsfrist

    Veranstaltung veranstaltung;
    ArrayList<Team> teams;
    Dozent dozent;
    
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
