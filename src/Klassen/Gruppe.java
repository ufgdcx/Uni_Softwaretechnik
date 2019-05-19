package Klassen;

import java.util.ArrayList;

public class Gruppe {

    // member variables
    private  int gruppenID;
    private String email; // E-Mailadresse des zustaendigen Dozenten
    private String tag; // Wochentag
    private String zeit; // Uhrzeit
    private String rhythmus; // Wochenrhythmus
    private String frist; // Einschreibungsfrist
    private Veranstaltung veranstaltung;
    private ArrayList<Team> teams;
    private Dozent dozent;

    // Constructor
    public Gruppe(int gruppenID, String email, String tag, String zeit, String rhythmus,
                  String frist, Veranstaltung veranstaltung, ArrayList<Team> teams, Dozent dozent)
    {
        this.gruppenID = gruppenID;
        this.email = email;
        this.tag = tag;
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

     // set methods
     public void setGruppenID(int gruppenID) {  this.gruppenID = gruppenID; }
     public void setEmail(String email) {  this.email = email; }
     public void setTag(String tag) {  this.tag = tag; }
     public void setZeit(String zeit) {  this.zeit = zeit; }
     public void setRhythmus(String rhythmus) {  this.rhythmus = rhythmus; }
     public void setFrist(String frist) {  this.frist = frist; }
     public void setVeranstaltung(Veranstaltung veranstaltung) {  this.veranstaltung = veranstaltung; }
     public void setTeams(ArrayList<Team> teams) {  this.teams = teams; }
     public void setDozent(Dozent dozent) {  this.dozent = dozent; }

     // add Team
     public void addTeam(Team team){ this.teams.add(team); }

    // remove Team
    public void removeTeam(int position){ this.teams.remove(position); }
    public void removeTeam(Team team){ this.teams.remove(team); }

}
