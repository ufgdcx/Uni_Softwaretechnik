package Klassen;

import java.util.ArrayList;

public class Unterblock 
{
	// member variables
	private String ubName;
	private int ubPunkte;
	private Leistungsblock lBlock;
	private ArrayList<Einzelleistung> einzelleistungen;
	
	// constructor
	public Unterblock(String ubName, int ubPunkte, Leistungsblock lBlock, ArrayList<Einzelleistung> einzelleistungen)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.lBlock = lBlock;
		this.einzelleistungen = einzelleistungen;
	}

	// get methods
	public String getUbName(){return ubName;}
	public int getUbPunkte(){return ubPunkte;}
	public Leistungsblock getlBlock(){return lBlock;}
	public ArrayList<Einzelleistung> getEinzelleistungen() {return einzelleistungen;}

	// set methods
	public void setUbName(String ubName){this.ubName = ubName;}
	public void setUbPunkte(int ubPunkte){this.ubPunkte = ubPunkte;}
	public void setlBlock(Leistungsblock lBlock){this.lBlock = lBlock;}
	public void setEinzelleistungen(ArrayList<Einzelleistung> einzelleistungen){this.einzelleistungen = einzelleistungen;}
	
    // add Einzelleistung
    public void addEinzelleistung(Einzelleistung einzelleistung){this.einzelleistungen.add(einzelleistung);}

    // remove Einzelleistung
    public void removeEinzelleistung(int position){this.einzelleistungen.remove(position);}
    public void removeEinzelleistung(Einzelleistung einzelleistung){this.einzelleistungen.remove(einzelleistung);}
}
