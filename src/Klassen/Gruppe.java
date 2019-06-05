package Klassen;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Gruppe {

    // member variables
    private  int gruppenID;
    private String wochentag; // Wochentag
    private Time zeit; // Uhrzeit
    private String rhythmus; // Wochenrhythmus
    private Date frist; // Einschreibungsfrist
    private Veranstaltung veranstaltung;
    private ArrayList<Team> teams;
    private Dozent dozent;

    // Constructor for Database
    public Gruppe(int gruppenID, String wochentag, Time zeit, String rhythmus,
                  java.sql.Date frist, Veranstaltung veranstaltung, Dozent dozent)
    {
        this.gruppenID = gruppenID;
        this.wochentag = wochentag;
        this.zeit = zeit;
        this.rhythmus = rhythmus;
        this.frist = frist;
        this.veranstaltung = veranstaltung;
        this.teams = teams;
        this.dozent = dozent;
    }

    // get methods
    public int getGruppenID() {  return gruppenID; }
    public String getRhythmus() {  return rhythmus; }
    public Veranstaltung getVeranstaltung() {  return veranstaltung; }
    public ArrayList<Team> getTeams() {  return teams; }
    public Dozent getDozent() {  return dozent; }
    public Date getFrist() { return  frist;}
    public String getWochentag() { return wochentag; }
    public Time getZeit() {return zeit;}

    // set methods
     public void setGruppenID(int gruppenID) {  this.gruppenID = gruppenID; }
     public void setTag(String tag) {  this.wochentag = tag; }
     public void setZeit(Time zeit) {  this.zeit = zeit; }
     public void setRhythmus(String rhythmus) {  this.rhythmus = rhythmus; }
     public void setFrist(Date frist) {  this.frist = frist; }
     public void setVeranstaltung(Veranstaltung veranstaltung) {  this.veranstaltung = veranstaltung; }
     public void setTeams(ArrayList<Team> teams) {  this.teams = teams; }
     public void setDozent(Dozent dozent) {  this.dozent = dozent; }

     // add Team
     public void addTeam(Team team){ this.teams.add(team); }

    // remove Team
    public void removeTeam(int position){ this.teams.remove(position); }
    public void removeTeam(Team team){ this.teams.remove(team); }

}
