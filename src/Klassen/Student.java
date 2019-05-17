package Klassen;

import java.util.ArrayList;

public class Student extends Nutzer
{
    // member variables
    private String studiengang;
    private int matrikelnr;
    private ArrayList<Leistungsblock> lBloecke;
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
    public ArrayList<Leistungsblock> getLeistungsblock(){ return lBloecke; }
    public Team getTeam() { return team; }

    // set methods
    public void setStudiengang(String studiengang) { this.studiengang = studiengang; }
    public void setMatrikelnr(int matrikelnr) { this.matrikelnr = matrikelnr; }
    public void setLeistungsblock(ArrayList<Leistungsblock> lBloecke){ this.lBloecke = lBloecke; }
    public void setTeam(Team team){ this.team = team; }

    // add a Leistungsblock to the Leistungsblock List
    public void addLeistungsblock(Leistungsblock lBlock){ this.lBloecke.add(lBlock); }

    // remove a Leistungsblock in the Leistungsblock List
    public void removeLeistungsblock(int position){ this.lBloecke.remove(position); }
    public void removeLeistungsblock(Leistungsblock lBlcok){ this.lBloecke.remove(lBlcok); }
}
