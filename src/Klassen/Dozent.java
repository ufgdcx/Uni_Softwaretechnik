/**
 * @author Diana, Sebastian, Sven
 * Klasse erstellt von Diana und erweitert von Sebastian und Sven
 *
 * Klasse für die Rolle Dozent (Unterklasse von Nutzer).
 *
 */

package Klassen;

import java.util.ArrayList;


public class Dozent extends Nutzer
{
    // member variables
    /**@author Diana*/
    private String fakultaet;
    // von Dozenten geleitete Veranstaltungen
    /**@author Sven*/
    private ArrayList<Veranstaltung> veranstaltungen;
    //von Dozenten betreute Gruppen
    private ArrayList<Gruppe> gruppen;
    private Veranstaltung veranstaltung;

    public Dozent(String email,String passwort, String titel, String vorname, String name,
                  String fakultaet)
    {
        super(email,passwort,titel,vorname,name); // make use of the superclass's constructor
        this.fakultaet = fakultaet;
    }

    // get methods
    /**@author Diana*/
    public String getFakultaet() { return fakultaet; }
    /**@author Sven*/
    public ArrayList<Veranstaltung> getVeranstaltungen(){ return this.veranstaltungen; }
    public ArrayList<Gruppe> getGruppen(){ return this.gruppen; }

    // set methods
    /**@author Diana*/
    public void setFakultaet(String fakultaet) { this.fakultaet = fakultaet; }
    /**@author Sven*/
    public void setVeranstaltungen(ArrayList<Veranstaltung> veranstaltungen) {this.veranstaltungen = veranstaltungen; }
    public void setGruppen(ArrayList<Gruppe> gruppen){ this.gruppen = gruppen; }

    // add Veranstaltung
    /**@author Christoph*/
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
