package Klassen;

/**
 * Klasse für die Verwaltung der Aufgaben von einem Unterblock eines Studenten oder Teams.
 * z.B. Aufgabe 1 des Unterblocks Uebungsserie 1
 * @author Oleg
 */
public class Aufgabe
{
    // member variables
    private String elName;
    private int elPunkte;
    private Unterblock unterblock;

    // constructor
    public Aufgabe(String elName, int elPunkte, Unterblock unterblock)
    {
        this.elName = elName;
        this.elPunkte = elPunkte;
        this.unterblock = unterblock;
    }

    // get methods
    public String getElName(){return elName;}
    public int getElPunkte(){return elPunkte;}
    public Unterblock getUnterblock(){return unterblock;}

    // set methods
    public void setElName(String elName){this.elName = elName;}
    public void setElPunkte(int elPunkte){this.elPunkte = elPunkte;}
    public void setUnterblock(Unterblock unterblock){this.unterblock = unterblock;}
}
