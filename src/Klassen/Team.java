package Klassen;

import java.util.ArrayList;

public class Team {

    int teamID;
	String thema = new String();
	
	ArrayList<Studienganganteil> anteile; //Studienganganteile
    ArrayList<Teamleistung> teamLBloecke; //Teamleistungsblöcke
    Gruppe gruppe;

    //getter und setter für Thema
    public String getThema() {

        return thema;
    }

    public void setThema(String thema) {

        this.thema = thema;
    }

}
