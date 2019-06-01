package Klassen;

import java.util.ArrayList;

public class Student extends Nutzer
{
    // member variables
    private String studiengang;
    public int matrikelnr;
    private ArrayList<Leistung> leistungen;
    private Team team;

    // Constructors
    public Student(String email,String passwort, String titel, String vorname, String name,
                   String studiengang, int matrikelnr, Team team)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.studiengang = studiengang;
        this.matrikelnr = matrikelnr;
        this.team = team;
    }

    public Student(String email,String passwort, String titel, String vorname, String name,
                   String studiengang, int matrikelnr)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.studiengang = studiengang;
        this.matrikelnr = matrikelnr;
    }

    // get methods
    public String getStudiengang() { return studiengang; }
    public int getMatrikelnr() { return matrikelnr; }
    public ArrayList<Leistung> getLeistungsblock(){ return leistungen; }
    public Team getTeam() { return team; }

    // set methods
    public void setStudiengang(String studiengang) { this.studiengang = studiengang; }
    public void setMatrikelnr(int matrikelnr) { this.matrikelnr = matrikelnr; }
    public void setLeistungsblock(ArrayList<Leistung> lBloecke){ this.leistungen = lBloecke; }
    public void setTeam(Team team){ this.team = team; }

    // add a Leistungsblock to the Leistungsblock List
    public void addLeistung(Leistung l){ this.leistungen.add(l); }

    // remove a Leistungsblock in the Leistungsblock List
    public void removeLeistungs(int position){ this.leistungen.remove(position); }
    public void removeLeistungs(Leistung l){ this.leistungen.remove(l); }
}
