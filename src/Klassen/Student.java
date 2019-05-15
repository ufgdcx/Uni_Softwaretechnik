package Klassen;

import java.util.ArrayList;

public class Student extends Nutzer {

    private String studiengang = new String();
    private int matrikelnr;

    private ArrayList<Leistungsblock> lBloecke; //Leistungsblöcke
    private Team team;

    public Student(String email,String passwort, String titel, String vorname, String name, String studiengang, int matrikelnr){
        super(email,passwort,titel,vorname,name);
        this.studiengang = studiengang;
        this.matrikelnr = matrikelnr;
    }

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
