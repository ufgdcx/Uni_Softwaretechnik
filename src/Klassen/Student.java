package Klassen;

import java.util.ArrayList;

public class Student extends Nutzer {

    private String studiengang = new String();
    private int matrikelnr;

    private ArrayList<Leistungsblock> lBloecke; //Leistungsblöcke
    private Team team;
    
    //getter und setter für Studiengang
    public String getStudiengang() {

        return studiengang;
    }

    public void setStudiengang(String studiengang) {

        this.studiengang = studiengang;
    }

    //getter und setter für MatrikelNr
    public int getMatrikelnr() {

        return matrikelnr;
    }

    public void setMatrikelnr(int matrikelnr) {

        this.matrikelnr = matrikelnr;
    }
}
