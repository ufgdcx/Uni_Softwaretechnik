package Klassen;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Gruppe {

    // member variables
    private  int gruppenID;
    private String email; // E-Mailadresse des zustaendigen Dozenten
    private String wochentag; // Wochentag
    private Time zeit; // Uhrzeit
    private String rhythmus; // Wochenrhythmus
    private java.sql.Date frist; // Einschreibungsfrist
    private Veranstaltung veranstaltung;
    private ArrayList<Team> teams;
    private Dozent dozent;

    // Constructor
    public Gruppe(int gruppenID, String email, String wochentag, Time zeit, String rhythmus,
                  java.sql.Date frist, Veranstaltung veranstaltung, ArrayList<Team> teams, Dozent dozent)
    {
        this.gruppenID = gruppenID;
        this.email = email;
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
    public String getEmail() {  return email; }
    public String getRhythmus() {  return rhythmus; }
    public Veranstaltung getVeranstaltung() {  return veranstaltung; }
    public ArrayList<Team> getTeams() {  return teams; }
    public Dozent getDozent() {  return dozent; }
    public java.sql.Date getFrist() { return  frist;}
    public String getWochentag() { return wochentag; }
    public Time getZeit() {return zeit;}

    // set methods
     public void setGruppenID(int gruppenID) {  this.gruppenID = gruppenID; }
     public void setEmail(String email) {  this.email = email; }
     public void setTag(String tag) {  this.wochentag = tag; }
     public void setZeit(Time zeit) {  this.zeit = zeit; }
     public void setRhythmus(String rhythmus) {  this.rhythmus = rhythmus; }
     public void setFrist(java.sql.Date frist) {  this.frist = frist; }
     public void setVeranstaltung(Veranstaltung veranstaltung) {  this.veranstaltung = veranstaltung; }
     public void setTeams(ArrayList<Team> teams) {  this.teams = teams; }
     public void setDozent(Dozent dozent) {  this.dozent = dozent; }

     // add Team
     public void addTeam(Team team){ this.teams.add(team); }

    // remove Team
    public void removeTeam(int position){ this.teams.remove(position); }
    public void removeTeam(Team team){ this.teams.remove(team); }

}
