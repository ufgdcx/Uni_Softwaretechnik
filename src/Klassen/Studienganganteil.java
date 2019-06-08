/**
 * @author Sven, Christoph
 * Klasse erstellt von Sven und erweitert von Sven und Christoph
 *
 * Klasse für die Verwaltung von Studiengangsanteilen bei der Verteilung der Projektteams.
 *
 */

package Klassen;

public class Studienganganteil 
{
	// member variables
	private String Studiengang;
	private int anteil;
	private Team team;
	
	// constructor
	public Studienganganteil(){}
	public Studienganganteil(String studiengang, int anteil, Team team)
	{
		Studiengang = studiengang;
		this.anteil = anteil;
		this.team = team;
	}

	// get methods
	public String getStudiengang(){return Studiengang;}
	public int getAnteil(){return anteil;}
	public Team getTeam(){return team;}

	// set methods
	public void setStudiengang(String studiengang){Studiengang = studiengang;}
	public void setAnteil(int anteil){this.anteil = anteil;}
	public void setTeam(Team team){this.team = team;}
}
