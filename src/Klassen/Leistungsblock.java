package Klassen;

import java.util.ArrayList;

public class Leistungsblock 
{
    // member variables
    private String lbName;
    private Student student;
    private ArrayList<Unterblock> uBloecke; //Unterblöcke
    
    // constructor

    public Leistungsblock(String lbName, Student student, ArrayList<Unterblock> uBloecke)
    {
        this.lbName = lbName;
        this.student = student;
        this.uBloecke = uBloecke;
    }

    // get methods
    public String getLbName() { return lbName; }
    public Student getStudent() { return student; }
    public ArrayList<Unterblock> getuBloecke() { return uBloecke; }

    // set methods
    public void setLbName(String lbName) { this.lbName = lbName; }
    public void setStudent(Student student) { this.student = student; }
    public void setuBloecke(ArrayList<Unterblock> uBloecke) { this.uBloecke = uBloecke; }

    // add Unterblock
    public void addUnterblock(Unterblock unterblock){ this.uBloecke.add(unterblock); }

    // remove Unterblock
    public void removeUnterblock(int position){ this.uBloecke.remove(position); }
    public void removeUnterblock(Unterblock unterblock){ this.uBloecke.remove(unterblock); }
}
