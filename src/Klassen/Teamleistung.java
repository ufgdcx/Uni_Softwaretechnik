package Klassen;

public class Teamleistung {

	// member variables
	private String teamleistungsblockname;
	private float tlPunkte;
	private Team team;
	
	// constructor
	public Teamleistung(String teamleistungsblockname, float tlPunkte, Team team)
	{
		this.teamleistungsblockname = teamleistungsblockname;
		this.tlPunkte = tlPunkte;
		this.team = team;
	}

	// get methods
	public String getTeamleistungsblockname(){return teamleistungsblockname;}
	public float getTlPunkte(){return tlPunkte;}
	public Team getTeam(){return team;}

	// set methods
	public void setTeamleistungsblockname(String teamleistungsblockname){this.teamleistungsblockname = teamleistungsblockname;}
	public void setTlPunkte(float tlPunkte){this.tlPunkte = tlPunkte;}
	public void setTeam(Team team){this.team = team;}
}
