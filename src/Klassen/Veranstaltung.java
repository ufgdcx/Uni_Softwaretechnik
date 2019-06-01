package Klassen;

import java.util.ArrayList;

public class Veranstaltung
{
    // member variables
    //Veranstaltungsname
    public static String name;
    private String fakultaet;
    //Teamanzahl je Gruppe
    private int Teamanzahl;
    //maximale Teilnehmeranzahl je Team
    private int maxTeilnehmer;
    //Gruppen der Veranstaltung
    private ArrayList<Gruppe> gruppen;
    //zugehörige Dozenten
    private ArrayList<Dozent> dozenten;
    //Informationen zur Veranstaltung (Tag, Uhrzeit,...)
    private String beschreibung;

    public Veranstaltung(String name, String fakultaet, int teamanzahl, int maxTeilnehmer,
                         ArrayList<Gruppe> gruppen, ArrayList<Dozent> dozenten, String beschreibung)
    {
        this.name = name;
        this.fakultaet = fakultaet;
        Teamanzahl = teamanzahl;
        this.maxTeilnehmer = maxTeilnehmer;
        this.gruppen = gruppen;
        this.dozenten = dozenten;
        this.beschreibung = beschreibung;
    }

    //Constructor for Database
    public Veranstaltung(String name, String fakultaet, int teamanzahl, int maxTeilnehmer)
    {
        this.name = name;
        this.fakultaet = fakultaet;
        Teamanzahl = teamanzahl;
        this.maxTeilnehmer = maxTeilnehmer;
    }

    // get methods
    public String getName()  {return name;  }
    public String getFakultaet()  {return fakultaet;  }
    public int getTeamanzahl()  {    return Teamanzahl;  }
    public int getMaxTeilnehmer()  {    return maxTeilnehmer;  }
    public ArrayList<Gruppe> getGruppen()  {    return gruppen;  }
    public ArrayList<Dozent> getDozenten()  {    return dozenten;  }
    public String getBeschreibung() {return beschreibung;}

    // set methods
    public void setName(String name)  {    this.name = name;  }
    public void setFakultaet(String fakultaet)  {    this.fakultaet = fakultaet;  }
    public void setTeamanzahl(int teamanzahl)  {    Teamanzahl = teamanzahl;  }
    public void setMaxTeilnehmer(int maxTeilnehmer)  {    this.maxTeilnehmer = maxTeilnehmer;  }
    public void setGruppen(ArrayList<Gruppe> gruppen)  {    this.gruppen = gruppen;  }
    public void setDozenten(ArrayList<Dozent> dozenten)  {    this.dozenten = dozenten;  }
    public void setBeschreibung(String beschreibung) {this.beschreibung = beschreibung; }

    // add Gruppe
    public void addGruppe(Gruppe gruppe){ this.gruppen.add(gruppe); }
    // add Dozent
    public void addDozent(Dozent dozent){ this.dozenten.add(dozent); }

    // remove Gruppe
    public void removeGruppe(int position){ this.gruppen.remove(position); }
    public void removeGruppe(Gruppe gruppe){ this.gruppen.remove(gruppe); }
    // remove Dozent
    public void removeDozent(int position){ this.dozenten.remove(position); }
    public void removeDozent(Dozent dozent){ this.dozenten.remove(dozent); }
}
