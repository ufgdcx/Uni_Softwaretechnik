package Klassen;

import java.util.ArrayList;

public class Teamblock {

	// member variables
	private String teamBlockName;
	private int tbPunkte;
	private Team team;
	private ArrayList<Teamleistung> teamLeistungen;
	
	// constructor
	public Teamblock(String teamBlockName, int tbPunkte, Team team, ArrayList<Teamleistung> teamLeistungen)
	{
		this.teamBlockName = teamBlockName;
		this.tbPunkte = tbPunkte;
		this.team = team;
		this.teamLeistungen = teamLeistungen;
	}

	// get methods
	public String getTeamBlockName(){return teamBlockName;}
	public int getTbPunkte(){return tbPunkte;}
	public Team getTeam(){return team;}
	public ArrayList<Teamleistung> getTeamLeistungen(){return teamLeistungen;}

	// set methods
	public void setTeamBlockName(String teamBlockName){this.teamBlockName = teamBlockName;}
	public void setTbPunkte(int tbPunkte){this.tbPunkte = tbPunkte;}
	public void setTeam(Team team){this.team = team;}
	public void setTeamLeistungen(ArrayList<Teamleistung> teamLeistungen){this.teamLeistungen = teamLeistungen;}
	
	// add Teamleistung
	public void addTeamleistung(Teamleistung teamLeistung){this.teamLeistungen.add(teamLeistung);}
	
	// remove Teamleistung
	public void removeTeamleistung(int position){this.teamLeistungen.remove(position);}
	public void removeTeamleistung(Teamleistung teamLeistung){this.teamLeistungen.remove(teamLeistung);}
}
