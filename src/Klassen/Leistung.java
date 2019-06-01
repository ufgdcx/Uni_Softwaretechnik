package Klassen;

import java.util.ArrayList;

public class Leistung
{
    // member variables
    private String lbName;
    private Student student;
    private int lbPunkte;
    private ArrayList<Unterblock> uBloecke; //Unterblöcke
    private String veranstaltungsname;
    private Veranstaltung veranstaltung;
    
    // constructor
    public Leistung(String lbName, Student student, int lbPunkte, ArrayList<Unterblock> uBloecke, String veranstaltungsname)
    {
        this.lbName = lbName;
        this.student = student;
        this.lbPunkte = lbPunkte;
        this.uBloecke = uBloecke;
        this.veranstaltungsname = veranstaltungsname;
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
    public String getVeranstaltungsname(){return veranstaltung.name;}

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
