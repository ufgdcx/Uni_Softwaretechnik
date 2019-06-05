package Klassen;

import java.util.ArrayList;

/**
 * Klasse für eine Leistungskategorie eines Studenten oder Teams.
 * Setzt sich aus mehreren Unterblöcken zusammen.
 * z.B. Übungsserien (mit den Unterblöcken Serie 1, Serie 2 etc.) oder Projektarbeit (mit den Unterblöcken Lastenheft, Pflichtenheft etc.)
 * @author Oleg
 */
public class Leistung
{
    // member variables
    private String lbName;
    private Student student;
    private int lbPunkte;
    private ArrayList<Unterblock> uBloecke; //Unterblöcke
    private Veranstaltung veranstaltung;
    
    // constructor
    public Leistung(String lbName, Student student, int lbPunkte, ArrayList<Unterblock> uBloecke)
    {
        this.lbName = lbName;
        this.student = student;
        this.lbPunkte = lbPunkte;
        this.uBloecke = uBloecke;
    }

    // constructor for Database
    public Leistung(String lbName)
    {
        this.lbName = lbName;
    }

    // get methods
    public String getLbName() {return lbName;}
    public Student getStudent() {return student;}
    public int getLbPunkte() {return lbPunkte;}
    public ArrayList<Unterblock> getuBloecke() {return uBloecke;}

    // set methods
    public void setLbName(String lbName) {this.lbName = lbName;}
    public void setStudent(Student student) {this.student = student;}
    public void setLbPunkte(int lbPunkte) {this.lbPunkte = lbPunkte;}
    public void setuBloecke(ArrayList<Unterblock> uBloecke) {this.uBloecke = uBloecke;}

    // add Unterblock
    public void addUnterblock(Unterblock unterblock){this.uBloecke.add(unterblock);}

    // remove Unterblock
    public void removeUnterblock(int position){this.uBloecke.remove(position);}
    public void removeUnterblock(Unterblock unterblock){this.uBloecke.remove(unterblock);}
}
