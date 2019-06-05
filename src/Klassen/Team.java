package Klassen;

import java.util.ArrayList;

/**
 * Klasse für die Verwaltung der Projektteams.
 * @author Sebastian
 */
public class Team
{
    // member variables
    private int teamID;
    private String thema;
    private ArrayList<Studienganganteil> anteile; //Studienganganteile
    private ArrayList<Leistung> leistungen; //Teamleistungsblöcke
    private Gruppe gruppe;

    // Constructor
    public Team(int teamID, String thema, ArrayList<Studienganganteil> anteile, ArrayList<Leistung> teaml, Gruppe gruppe)
    {
        this.teamID = teamID;
        this.thema = thema;
        this.anteile = anteile;
        this.leistungen = teaml;
        this.gruppe = gruppe;
    }

    // Constructor for Database
    public Team(int teamID, String thema, Gruppe gruppe)
    {
        this.teamID = teamID;
        this.thema = thema;
        this.gruppe = gruppe;
    }
    
    // set methods
    public void setTeamID(int teamID) { this.teamID = teamID; }
    public void setThema(String thema) { this.thema = thema; }
    public void setAnteile(ArrayList<Studienganganteil> anteile) { this.anteile = anteile; }
    public void setLeistungen(ArrayList<Leistung> teaml) { this.leistungen = teaml; }
    public void setGruppe(Gruppe gruppe) { this.gruppe = gruppe; }

    // get methods
    public int getTeamID(){ return teamID;	}
    public String getThema(){ return thema; }
    public ArrayList<Studienganganteil> getAnteile(){ return anteile; }
    public ArrayList<Leistung> getLeistungen(){ return leistungen; }
    public Gruppe getGruppe(){ return gruppe; }

    // add Teamleistung
    public void addLeistung(Leistung teaml){ this.leistungen.add(teaml); }
    // remove Teamleistung
    public void removeLeistung(int position){ this.leistungen.remove(position); }
    public void removeLeistung(Leistung teamleistung){ this.leistungen.remove(teamleistung); }

    // !! add and remove anteile
}
