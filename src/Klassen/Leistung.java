/**
 * @author Diana, Sebastian, Sven, Christoph
 * Klasse erstellt von Diana und erweitert von Sebastian, Sven und Christoph
 *
 * Klasse fuer eine Leistungskategorie eines Studenten oder Teams.
 * Setzt sich aus mehreren Unterbloecken zusammen.
 * z.B. Uebungsserien (mit den Unterbloecken Serie 1, Serie 2 etc.) oder Projektarbeit (mit den Unterbloecken Lastenheft, Pflichtenheft etc.)
 */

package Klassen;

import java.util.ArrayList;


public class Leistung
{
    // member variables
    /**@author Diana*/
    private String lbName;
    /**@author Sebastian*/
    private Student student;
    private int maxPunkte;
    /**@author Diana*/
    private int lbPunkte;
    //Unterbloecke
    /**@author Sven*/
    private ArrayList<Unterblock> uBloecke;
    private Veranstaltung veranstaltung;
    
    // constructor
    public Leistung(){}
    public Leistung(String lbName, Student student, int lbPunkte, int maxPunkte, ArrayList<Unterblock> uBloecke)
    {
        this.lbName = lbName;
        this.student = student;
        this.lbPunkte = lbPunkte;
        this.maxPunkte = maxPunkte;
        this.uBloecke = uBloecke;
    }

    // constructor for Database
    public Leistung(String lbName, Veranstaltung veranstaltung,Student student)
    {
        this.lbName = lbName;
        this.veranstaltung = veranstaltung;
        this.student = student;
    }

    public Leistung(String lbName, Veranstaltung veranstaltung)
    {
        this.lbName = lbName;
        this.veranstaltung = veranstaltung;
    }

    public Leistung(String lbName)
    {
        this.lbName = lbName;
    }

    // get methods
    /**@author Diana*/
    public String getLbName() {return lbName;}
    /**@author Sebastian*/
    public Student getStudent() {return student;}
    public int getMaxPunkte() {return maxPunkte;}
    /**@author Diana*/
    public int getLbPunkte() {return lbPunkte;}
    /**@author Sven*/
    public ArrayList<Unterblock> getuBloecke() {return uBloecke;}
    public Veranstaltung getVeranstaltung() {return veranstaltung;}



    // set methods
    /**@author Diana*/
    public void setLbName(String lbName) {this.lbName = lbName;}
    /**@author Sebastian*/
    public void setStudent(Student student) {this.student = student;}
    public void setMaxPunkte(int maxPunkte) {this.maxPunkte = maxPunkte;}
    /**@author Diana*/
    public void setLbPunkte(int lbPunkte) {this.lbPunkte = lbPunkte;}
    /**@author Sven*/
    public void setuBloecke(ArrayList<Unterblock> uBloecke) {this.uBloecke = uBloecke;}
    public void setVeranstaltung(Veranstaltung veranstaltung) {this.veranstaltung = veranstaltung;}

    // add Unterblock
    public void addUnterblock(Unterblock unterblock){this.uBloecke.add(unterblock);}

    // remove Unterblock
    public void removeUnterblock(int position){this.uBloecke.remove(position);}
    public void removeUnterblock(Unterblock unterblock){this.uBloecke.remove(unterblock);}
}
