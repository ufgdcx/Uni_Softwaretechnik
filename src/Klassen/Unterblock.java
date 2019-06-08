/**
 * @author Sven, Christoph
 * Klasse erstellt von Sven und erweitert von Sven und Christoph
 *
 * Klasse für die Verwaltung der Unterbloecke von einer Leistung eines Studenten oder Teams.
 * Setzt sich aus mehreren Aufgaben zusammen.
 * z.B. Uebungsserie 1 der Leistung Uebungsserien
 */

package Klassen;

import java.util.ArrayList;

public class Unterblock 
{
	// member variables
	private String ubName;
	private int ubPunkte;
	private Leistung oberL;
	private ArrayList<Aufgabe> aufgaben;
	private Veranstaltung veranstaltung;
	private int matrikel;
	private Student student;
	
	// constructor
	public Unterblock(String ubName, int ubPunkte, Leistung l, ArrayList<Aufgabe> a, int matrikel)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.oberL = l;
		this.aufgaben = a;
		this.matrikel = matrikel;
	}

	// constructor for Database
	public Unterblock(String ubName, Leistung l)
	{
		this.ubName = ubName;
		this.oberL = l;
	}

	// get methods
	public String getUbName(){return ubName;}
	public int getUbPunkte(){return ubPunkte;}
	public Leistung getlBlock(){return oberL;}
	public ArrayList<Aufgabe> getAufgaben() {return aufgaben;}
	public int getMatrikel(){return  student.matrikelnr;}

	// set methods
	public void setUbName(String ubName){this.ubName = ubName;}
	public void setUbPunkte(int ubPunkte){this.ubPunkte = ubPunkte;}
	public void setLeistung(Leistung l){this.oberL = l;}
	public void setAufgaben(ArrayList<Aufgabe> a){this.aufgaben = a;}
	public void setMatrikel(int matrikel) {	this.student.matrikelnr = matrikel;	}

	// add Einzelleistung
    public void addAufgabe(Aufgabe a){this.aufgaben.add(a);}

    // remove Einzelleistung
    public void removeAufgabe(int position){this.aufgaben.remove(position);}
    public void removeAufgabe(Aufgabe a){this.aufgaben.remove(a);}
}
