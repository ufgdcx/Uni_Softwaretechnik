/**
 * @author Sven, Sebastian
 * Klasse erstellt von Sebastian und erweitert von Sven
 *
 * Klasse fuer die Verwaltung der Aufgaben von einem Unterblock eines Studenten oder Teams.
 * z.B. Aufgabe 1 des Unterblocks Uebungsserie 1
 */

package Klassen;

public class Aufgabe
{
    // member variables
    private String elName;
    private int elPunkte;
    private int maxPunkte;
    private Unterblock unterblock;

    // constructor
    public Aufgabe(){}
    public Aufgabe(String elName, int elPunkte, Unterblock unterblock)
    {
        this.elName = elName;
        this.elPunkte = elPunkte;
        this.unterblock = unterblock;
    }
    public Aufgabe(String elName, int elPunkte, Unterblock unterblock, int maxPunkte)
    {
        this.elName = elName;
        this.elPunkte = elPunkte;
        this.unterblock = unterblock;
        this.maxPunkte =maxPunkte;
    }

    // get methods
    public String getElName(){return elName;}
    public int getElPunkte(){return elPunkte;}
    public Unterblock getUnterblock(){return unterblock;}
    public int getMaxPunkte() {return maxPunkte;}

    // set methods
    public void setElName(String elName){this.elName = elName;}
    public void setElPunkte(int elPunkte){this.elPunkte = elPunkte;}
    public void setUnterblock(Unterblock unterblock){this.unterblock = unterblock;}
    public void setMaxPunkte(int maxPunkte) {this.maxPunkte = maxPunkte;}
}
