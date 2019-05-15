package Klassen;

import java.util.ArrayList;

public class Team {

    private int teamID;
    private String thema = new String();

    private ArrayList<Studienganganteil> anteile; //Studienganganteile
    private ArrayList<Teamleistung> teamLBloecke; //Teamleistungsblöcke
    private Gruppe gruppe;

    //getter und setter für Thema
    public String getThema() {

        return thema;
    }

    public void setThema(String thema) {

        this.thema = thema;
    }

}
