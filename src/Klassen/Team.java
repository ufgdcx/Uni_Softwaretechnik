package Klassen;

import java.util.ArrayList;

public class Team
{
    // member variables
    private int teamID;
    private String thema;
    private ArrayList<Studienganganteil> anteile; //Studienganganteile
    private ArrayList<Teamleistung> teamLBloecke; //Teamleistungsblöcke
    private Gruppe gruppe;

    // Constructor
    public Team(int teamID, String thema, ArrayList<Studienganganteil> anteile, 
                ArrayList<Teamleistung> teamLBloecke, Gruppe gruppe)
    {
        this.teamID = teamID;
        this.thema = thema;
        this.anteile = anteile;
        this.teamLBloecke = teamLBloecke;
        this.gruppe = gruppe;
    }
    
    // set methods
    public void setTeamID(int teamID) { this.teamID = teamID; }
    public void setThema(String thema) { this.thema = thema; }
    public void setAnteile(ArrayList<Studienganganteil> anteile) { this.anteile = anteile; }
    public void setTeamLBloecke(ArrayList<Teamleistung> teamLBloecke) { this.teamLBloecke = teamLBloecke; }
    public void setGruppe(Gruppe gruppe) { this.gruppe = gruppe; }

    // get methods
    public int getTeamID(){ return teamID;	}
    public String getThema(){ return thema; }
    public ArrayList<Studienganganteil> getAnteile(){ return anteile; }
    public ArrayList<Teamleistung> getTeamLBloecke(){ return teamLBloecke; }
    public Gruppe getGruppe(){ return gruppe; }

    // add Teamleistung
    public void addTeamleistung(Teamleistung teamleistung){ this.teamLBloecke.add(teamleistung); }
    // remove Teamleistung
    public void removeTeamLesitung(int position){ this.teamLBloecke.remove(position); }
    public void removeTeamLesitung(Teamleistung teamleistung){ this.teamLBloecke.remove(teamleistung); }

    // !! add and remove anteile
}
