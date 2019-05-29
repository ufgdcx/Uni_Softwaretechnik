package Klassen;

public class Teamleistung {

	// member variables
	private String tlName;
	private int tlPunkte;
	private Teamblock teamblock;
	
	// constructor
	public Teamleistung(String tlName, int tlPunkte, Teamblock teamblock)
	{
		this.tlName = tlName;
		this.tlPunkte = tlPunkte;
		this.teamblock = teamblock;
	}

	// get methods
	public String geTtlName(){return tlName;}
	public int getTlPunkte(){return tlPunkte;}
	public Teamblock getTeamblock(){return teamblock;}

	// set methods
	public void setTlName(String tlName){this.tlName = tlName;}
	public void setTlPunkte(int tlPunkte){this.tlPunkte = tlPunkte;}
	public void setTeamblock(Teamblock teamblock){this.teamblock = teamblock;}
}
