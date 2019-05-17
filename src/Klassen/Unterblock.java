package Klassen;

public class Unterblock 
{
	// member variables
	private String ubName;
	private Float ubPunkte;
	private Leistungsblock lBlock;
	
	// constructor
	public Unterblock(String ubName, Float ubPunkte, Leistungsblock lBlock)
	{
		this.ubName = ubName;
		this.ubPunkte = ubPunkte;
		this.lBlock = lBlock;
	}

	// get methods
	public String getUbName()	{return ubName;	}
	public Float getUbPunkte()	{return ubPunkte;	}
	public Leistungsblock getlBlock()	{return lBlock;	}

	// set methods
	public void setUbName(String ubName)	{this.ubName = ubName;	}
	public void setUbPunkte(Float ubPunkte)	{this.ubPunkte = ubPunkte;	}
	public void setlBlock(Leistungsblock lBlock)	{this.lBlock = lBlock;	}
}
