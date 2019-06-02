package Klassen;

import java.util.ArrayList;

/**
 * Klasse für die Rolle Dozent (Unterklasse von Nutzer)
 */

public class Dozent extends Nutzer
{
    // member variables
    private String fakultaet;
    private ArrayList<Veranstaltung> veranstaltungen; // von Dozenten geleitete Veranstaltungen
    private ArrayList<Gruppe> gruppen; //von Dozenten betreute Gruppen
    private Veranstaltung veranstaltung;

    public Dozent(String email,String passwort, String titel, String vorname, String name,
                  String fakultaet)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.fakultaet = fakultaet;
    }

    // get methods
    public String getFakultaet() { return fakultaet; }
    public ArrayList<Veranstaltung> getVeranstaltungen(){ return this.veranstaltungen; }
    public ArrayList<Gruppe> getGruppen(){ return this.gruppen; }

    // set methods
    public void setFakultaet(String fakultaet) { this.fakultaet = fakultaet; }
    public void setVeranstaltungen(ArrayList<Veranstaltung> veranstaltungen) {this.veranstaltungen = veranstaltungen; }
    public void setGruppen(ArrayList<Gruppe> gruppen){ this.gruppen = gruppen; }

    // add Veranstaltung
    public void addVeranstaltung(Veranstaltung veranstaltung){ this.veranstaltungen.add(veranstaltung); }
    // add Gruppe
    public void addGruppe(Gruppe gruppe){ this.gruppen.add(gruppe); }

    // remove Veranstaltung
    public void removeVeranstaltung(int position){ this.veranstaltungen.remove(position); }
    public void removeVeranstaltung(Veranstaltung veranstaltung){ this.veranstaltungen.remove(veranstaltung); }
    // remove Gruppe
    public void removeGruppe(int position){ this.gruppen.remove(position); }
    public void removeGruppe(Gruppe gruppe){ this.gruppen.remove(gruppe); }


}
