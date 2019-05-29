package Klassen;

import java.util.ArrayList;

public class Unterblock 
{
	// member variables
	private String ubName;
	private int ubPunkte;
	private Leistung oberL;
	private ArrayList<Aufgabe> aufgaben;
	
	// constructor
	public Unterblock(String ubName, int ubPunkte, Leistung l, ArrayList<Aufgabe> a)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.oberL = l;
		this.aufgaben = a;
	}

	// get methods
	public String getUbName(){return ubName;}
	public int getUbPunkte(){return ubPunkte;}
	public Leistung getlBlock(){return oberL;}
	public ArrayList<Aufgabe> getEinzelleistungen() {return aufgaben;}

	// set methods
	public void setUbName(String ubName){this.ubName = ubName;}
	public void setUbPunkte(int ubPunkte){this.ubPunkte = ubPunkte;}
	public void setLeistung(Leistung l){this.oberL = l;}
	public void setEinzelleistungen(ArrayList<Aufgabe> a){this.aufgaben = a;}
	
    // add Einzelleistung
    public void addEinzelleistung(Aufgabe a){this.aufgaben.add(a);}

    // remove Einzelleistung
    public void removeAufgabe(int position){this.aufgaben.remove(position);}
    public void removeAufgabe(Aufgabe a){this.aufgaben.remove(a);}
}
