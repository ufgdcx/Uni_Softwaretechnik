/**
 * @author Diana, Sebastian, Sven, Christoph
 * Klasse erstellt von Diana und erweitert von Sebastian, Sven und Christoph
 *
 * Klasse fuer die Rolle Student (Unterklasse von Nutzer).
 */

package Klassen;

import java.util.ArrayList;

public class Student extends Nutzer
{
    // member variables
    /**@author Diana*/
    private String studiengang;
    protected int matrikelnr;
    /**@author Sven*/
    private ArrayList<Leistung> leistungen;
    private Team team;

    // Constructors
    public Student(){}
    public Student(String email,String passwort, String titel, String vorname, String name,
                   String studiengang, int matrikelnr, Team team)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.studiengang = studiengang;
        this.matrikelnr = matrikelnr;
        this.team = team;
    }

    /**@author Christoph*/
    public Student(String email,String passwort, String titel, String vorname, String name,
                   String studiengang, int matrikelnr)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.studiengang = studiengang;
        this.matrikelnr = matrikelnr;
    }

    // get methods
    /**@author Diana*/
    public String getStudiengang() { return studiengang; }
    public int getMatrikelnr() { return matrikelnr; }
    /**@author Sven*/
    public ArrayList<Leistung> getLeistungsblock(){ return leistungen; }
    public Team getTeam() { return team; }

    // set methods
    /**@author Diana*/
    public void setStudiengang(String studiengang) { this.studiengang = studiengang; }
    public void setMatrikelnr(int matrikelnr) { this.matrikelnr = matrikelnr; }
    /**@author Sven*/
    public void setLeistungsblock(ArrayList<Leistung> lBloecke){ this.leistungen = lBloecke; }
    public void setTeam(Team team){ this.team = team; }

    // add a Leistungsblock to the Leistungsblock List
    public void addLeistung(Leistung l){ this.leistungen.add(l); }

    // remove a Leistungsblock in the Leistungsblock List
    public void removeLeistungs(int position){ this.leistungen.remove(position); }
    public void removeLeistungs(Leistung l){ this.leistungen.remove(l); }
}
