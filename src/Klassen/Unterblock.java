package Klassen;

import java.util.ArrayList;

public class Unterblock 
{
	// member variables
	private String ubName;
	private int ubPunkte;
	private Leistung oberL;
	private ArrayList<Aufgabe> aufgaben;
	private String veranstaltungsname;
	private Veranstaltung veranstaltung;
	private int matrikel;
	private Student student;
	
	// constructor
	public Unterblock(String ubName, int ubPunkte, Leistung l, ArrayList<Aufgabe> a, String veranstaltungsname, int matrikel)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.oberL = l;
		this.aufgaben = a;
		this.veranstaltungsname = veranstaltungsname;
		this.matrikel = matrikel;
	}

	// get methods
	public String getUbName(){return ubName;}
	public int getUbPunkte(){return ubPunkte;}
	public Leistung getlBlock(){return oberL;}
	public ArrayList<Aufgabe> getAufgaben() {return aufgaben;}
	public String getVeranstaltungsname(){return veranstaltung.name;}
	public int getMatrikel(){return  student.matrikelnr;}

	// set methods
	public void setUbName(String ubName){this.ubName = ubName;}
	public void setUbPunkte(int ubPunkte){this.ubPunkte = ubPunkte;}
	public void setLeistung(Leistung l){this.oberL = l;}
	public void setAufgaben(ArrayList<Aufgabe> a){this.aufgaben = a;}
	public void setVeranstaltungsname(){this.veranstaltung.name = veranstaltungsname;}
	public void setMatrikel(int matrikel) {	this.student.matrikelnr = matrikel;	}

	// add Einzelleistung
    public void addAufgabe(Aufgabe a){this.aufgaben.add(a);}

    // remove Einzelleistung
    public void removeAufgabe(int position){this.aufgaben.remove(position);}
    public void removeAufgabe(Aufgabe a){this.aufgaben.remove(a);}
}
