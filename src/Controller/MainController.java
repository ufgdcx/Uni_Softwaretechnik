/**@author Oleg, Diana
 * Klasse erstellt von Oleg und erweitert von Oleg und Diana
 *
 * Steuert Anmeldung, Registrierung und Wechsel zu Dozenten-/Studentencontroller.
 *
 */

package Controller;

import Database.*;
import GUI.*;
import Klassen.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainController {
	protected GUIMain mainFrame;
	private Nutzer n;
	protected DBrequest dbr = new DBrequest();
	
	public MainController(GUIMain m) {
		mainFrame = m;
		mainFrame.setController(this);
	}
	/**@author Oleg */
	public void login(String email, char[] passwd) {
		//handle authentification
		try {
			n = dbr.getNutzer(email,passwd);
		} catch (DatabaseException e) {

			System.out.println(e.getErrorMsg());
            return;
		}
		
		//switch to StudentController or DozentController
		if(n instanceof Dozent){
			//creating Dozent object d to pass the info to DozentController
			//and transforming Nutzer object n to Dozent object d
			Dozent d = (Dozent) n;
			new DozentController(mainFrame,d);

		}
		else{
			//creating Student object s to pass the info to StudentController
			//and transforming Nutzer object n to Student object s
			Student s = (Student) n;

			new StudentController(mainFrame,s);
		}
	}

	/**@author Diana */
	public ArrayList<Veranstaltung> getVeranstaltungen(Dozent me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana */
	public void setVBeschreibung(Veranstaltung veranstaltung){
		try {
			dbr.updateVeranstaltungBeschreibung(veranstaltung.getName(), veranstaltung.getBeschreibung());
		}
		catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
			return;
		}
	}

	/**@author Diana */
	public ArrayList<Gruppe> getGruppen(Veranstaltung veranstaltung) {

		try{
			return dbr.getGruppen(veranstaltung);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**@author Diana */
	public ArrayList<Team> getTeams(Gruppe gruppe) {

		try{
			return dbr.getTeams(gruppe);
		} catch (DatabaseException e) {
			System.out.println(e.getErrorMsg());
		}
		return null;
	}
	/**@author Diana */
	public ArrayList<Student> getStudenten(Team team) {

		try{
			return dbr.getStudenten(team);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**@author Diana */
	public void createGruppe(int gruppenid, Dozent d, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus){
		try {
			dbr.createGruppe(gruppenid, d.getEmail(), veranstaltung, einschreibungsfrist, uhrzeit, wochentag, wochenrhytmus);
		}  catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	/**@author Diana */
	public void createGruppenTree(Veranstaltung veranstaltung, JScrollPane tsp) {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(veranstaltung.getName());

		System.out.println(root.toString());

		for (Gruppe gruppe: getGruppen(veranstaltung)) {
			DefaultMutableTreeNode gruppen = new DefaultMutableTreeNode("Gruppe" + " " + gruppe.getGruppenID());
			root.add(gruppen);
			for (Team team: getTeams(gruppe)) {
				DefaultMutableTreeNode teams = new DefaultMutableTreeNode("Team" + " " + team.getTeamID());
				gruppen.add(teams);
				for (Student student: getStudenten(team)) {
					DefaultMutableTreeNode studenten = new DefaultMutableTreeNode(student.getVorname()+ " " + student.getNachname());
					teams.add(studenten);
				}
			}
		}
		tsp.setViewportView(new JTree(root));

	}

	/**@author Diana */
	/*public void createLeistungsTree(Veranstaltung veranstaltung, JScrollPane tsp) {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(veranstaltung.getName());

		for (Gruppe gruppe: getGruppen(veranstaltung)) {
			DefaultMutableTreeNode gruppen = new DefaultMutableTreeNode("Gruppe" + " " + gruppe.getGruppenID());
			root.add(gruppen);
			for (Team team: getTeams(gruppe)) {
				DefaultMutableTreeNode teams = new DefaultMutableTreeNode("Team" + " " + team.getTeamID());
				gruppen.add(teams);
				for (Student student: getStudenten(team)) {
					DefaultMutableTreeNode studenten = new DefaultMutableTreeNode(student.getVorname()+ " " + student.getNachname());
					teams.add(studenten);
				}
			}

		}
		tsp.setViewportView(new JTree(root));
	}*/

	//Erstellt die GruppenID bestehend aus den letzten zwei Zahlen des Jahres und einem Laufindex
	/**@author Diana*/
	public int createGruppenID(Veranstaltung veranstaltung){
		//TODO: Prüfen ob GruppenID bereits vergeben ist
		System.out.println("Hallo");
		int gruppenanzahl = getGruppen(veranstaltung).size()+1;
		System.out.println(gruppenanzahl);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int year = cal.get(Calendar.YEAR) % 100;
		System.out.println(year);
		String gruppenID = "" + year + gruppenanzahl;
		System.out.println(gruppenID);
		return Integer.parseInt(gruppenID);
	}

	//Erstellt die TeamID bestehend aus der GruppenID und einem Laufindex
	/**@author Diana*/
	public int createTeamID(Gruppe gruppe){
		//TODO: Prüfen ob TeamID bereits vergeben ist
		int teamanzahl = gruppe.getTeams().size()+1;
		String teamID = "" + gruppe.getGruppenID() + teamanzahl;
		System.out.println(teamID);
		return Integer.parseInt(teamID);
	}

	/**@author Diana*/
	public void addGruppe (Veranstaltung veranstaltung, String email, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus){
		try{
			dbr.createGruppe(createGruppenID(veranstaltung), email, veranstaltung.getName(), einschreibungsfrist, uhrzeit, wochentag, wochenrhytmus);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana*/
	public void addTeam(Veranstaltung veranstaltung, int teamID, int gruppenID, String thema){
		try {
			dbr.createTeam(teamID, gruppenID, veranstaltung.getName(), thema);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana */
    public ArrayList<Leistung> getLeistung(Team team){
        try {
            return dbr.getLeistung(team);
        } catch (DatabaseException e){
            System.out.println(e.getErrorMsg());
        }
        return null;
    }

	/**@author Diana */
	public Team getTeam(Student student, Gruppe gruppe) {

		try{
			return dbr.getTeam(student, gruppe);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**@author Diana */
    public void setGruppen(Gruppe gruppe) {

        try{
            dbr.updateGruppe(gruppe);

        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
            return;
        }
    }

	/**@author Diana */
    public void setTeam(Team team) {

        try{
            dbr.updateTeam(team);
        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
            return;
        }
    }

	/**@author Diana */
	public void setTeamanzahl(String veranstaltungsname, int teamanzahl) {
		try {
			dbr.updateVeranstaltungTeamanzahl_je_Gruppe(veranstaltungsname, teamanzahl);
		} catch (DatabaseException e) {
			System.out.println(e.getErrorMsg());
			return;
		}
	}

	/**@author Diana */
    public void setTeamgroesse(String veranstaltungsname, int teamgroesse){
		try{
		dbr.updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team(veranstaltungsname, teamgroesse);
	} catch (DatabaseException e) {
		System.out.println(e.getErrorMsg());
		return;
	}
}


	/**@author Diana*/
    /*public void setLeistung(Gruppe gruppe, Team team, Veranstaltung veranstaltung){

        try {
            dbr.updateLeistung(gruppe, team, veranstaltung);
        } catch (DatabaseException e){
            System.out.println(e.getErrorMsg());
            return;
        }
    }*/

	//Methoden für Studentenansicht
	/**@author Diana */
	public ArrayList<Veranstaltung> getVeranstaltungen(Student me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana */
	public ArrayList<Veranstaltung> getAlleV(){
		try {
			return dbr.getAllVeranstaltungen();
		}catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
			return null;
		}
	}

	//Hilfsmethode für Teambeitritt
	/**@author Diana */
	public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname){
		try {
			dbr.createGehoertZu(matrikelnummer, teamid, gruppenid, veranstaltungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	//Hilfsmethode für Teamaustritt
	/**@author Diana */
	public void deleteGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname){
		try {
			dbr.deleteGehoertZu(matrikelnummer, teamid, gruppenid, veranstaltungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	//erzeugt Verifizierungscode für die Email Bestätigung
	/**@author Diana*/
    public String generateVerifyingCode() {

        String charvalue = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] chars = charvalue.toCharArray();

        String verifyingCode = "";
        Random random = new Random();

        for (int i=0; i<= 16; i++) {
            verifyingCode += chars[random.nextInt(chars.length-1)];
        }

        System.out.println(verifyingCode);

        return verifyingCode;
    }



}
