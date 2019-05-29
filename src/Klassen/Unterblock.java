package Klassen;

import java.util.ArrayList;

public class Unterblock 
{
	// member variables
	private String ubName;
	private int ubPunkte;
	private Leistung oberL;
	private ArrayList<Einzelleistung> einzelleistungen;
	
	// constructor
	public Unterblock(String ubName, int ubPunkte, Leistung l, ArrayList<Einzelleistung> einzelleistungen)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.oberL = l;
		this.einzelleistungen = einzelleistungen;
	}

	// get methods
	public String getUbName(){return ubName;}
	public int getUbPunkte(){return ubPunkte;}
	public Leistung getlBlock(){return oberL;}
	public ArrayList<Einzelleistung> getEinzelleistungen() {return einzelleistungen;}

	// set methods
	public void setUbName(String ubName){this.ubName = ubName;}
	public void setUbPunkte(int ubPunkte){this.ubPunkte = ubPunkte;}
	public void setLeistung(Leistung l){this.oberL = l;}
	public void setEinzelleistungen(ArrayList<Einzelleistung> einzelleistungen){this.einzelleistungen = einzelleistungen;}
	
    // add Einzelleistung
    public void addEinzelleistung(Einzelleistung einzelleistung){this.einzelleistungen.add(einzelleistung);}

    // remove Einzelleistung
    public void removeEinzelleistung(int position){this.einzelleistungen.remove(position);}
    public void removeEinzelleistung(Einzelleistung einzelleistung){this.einzelleistungen.remove(einzelleistung);}
}
