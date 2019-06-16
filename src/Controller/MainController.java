/**@author Oleg, Diana
 * Klasse erstellt von Oleg und erweitert von Oleg, Diana, Sebastian
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
import java.util.*;

public class MainController {
	protected GUIMain mainFrame;
	private Nutzer n;
	protected DBrequest dbr = DBrequest.getIntstance();

	/**@author Diana
	 * Hilfsmethode fuer die Registrierung eines neuen Nutzers
	 * @param email
	 * @param titel
	 * @param vorname
	 * @param nachname
	 * @param passwort
	 */
	public void createNutzer(String email, String titel, String vorname, String nachname, String passwort){
		try {
			dbr.createNutzer(email, titel, vorname, nachname, passwort);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode fuer die Registrierung eines neuen Dozenten
	 * Qparam email
	 * @param fakultaet
	 *
	 */
	public void createDozent(String email, String fakultaet){
		try {
			dbr.createDozent(email, fakultaet);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode fuer die Registrierung eines neuen Studenten
	 * Qparam email
	 * @param matrikelnummer
	 * @param studiengang
	 */
	public void createStudent(String email, int matrikelnummer, String studiengang){
		try {
			dbr.createStudent(email, matrikelnummer, studiengang);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	public MainController(GUIMain m) {
		mainFrame = m;
		mainFrame.setController(this);
	}

	/**@author Sebastian
	 * Methode zum Hashen der Nutzerpasswörter
	 * @param base
	 * @return
	 */
	public static char[] getHash(char[] base) {
    	String baseString = "";
    	for(int i = 0; i < base.length; i++)
    		baseString = baseString + base[i];
    	return String.valueOf(baseString.hashCode()).toCharArray();
    }

	/**@author Oleg
	 * Hilfsmethode fuer den Login eines Nutzers
	 * @param email
	 * @param passwd
	 */
	public void login(String email, char[] passwd) {
		//handle authentification
		try {
			n = dbr.getNutzer(email,getHash(passwd));
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

    /**@author Diana
     * erzeugt Verifizierungscode für die Email Bestätigung
     * @return verifyingCode
     */
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

	/**@author Diana
	 * Hilfsmethode zur Anzeige der Veranstaltungen eines Dozenten
	 * @param me
	 * @return
	 */
	public ArrayList<Veranstaltung> getVeranstaltungen(Dozent me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode zum Bearbteiten der Veranstaltungsinformationen in DVeranstaltungsuebersicht und -bearbeiten
	 * @param veranstaltung
	 */
	public void setVBeschreibung(Veranstaltung veranstaltung){
		try {
			dbr.updateVeranstaltungBeschreibung(veranstaltung.getName(), veranstaltung.getBeschreibung());
		}
		catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
			return;
		}
	}

	/**@author Diana
	 * Hilfsmethode für createGruppenTree
	 * @param veranstaltung
	 * @return
	 */
	public ArrayList<Gruppe> getGruppen(Veranstaltung veranstaltung) {

		try{
			return dbr.getGruppen(veranstaltung);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode für createGruppenTree
	 * @param gruppe
	 * @return
	 */
	public ArrayList<Team> getTeams(Gruppe gruppe) {

		try{
			return dbr.getTeams(gruppe);
		} catch (DatabaseException e) {
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode für createGruppenTree
	 * @param team
	 * @return
	 */
	public ArrayList<Student> getStudenten(Team team) {

		try{
			return dbr.getStudenten(team);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Methode zum erstellen der GruppenTrees in Dozenten- und Studentenansticht
	 * @param veranstaltung
	 * @param tsp
	 * @return
	 */
	public JTree createGruppenTree(Veranstaltung veranstaltung, JScrollPane tsp) {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(veranstaltung.getName());

		for (Gruppe gruppe: getGruppen(veranstaltung)) {
			DefaultMutableTreeNode gruppen = new DefaultMutableTreeNode("Gruppe" + " " + gruppe.getGruppenID() + " " +  " \t(" + gruppe.getWochentag() + "; " +  gruppe.getZeit() + "; " +  gruppe.getRhythmus() + "; " +  gruppe.getFrist() + ")");
			root.add(gruppen);
			for (Team team: getTeams(gruppe)) {
				DefaultMutableTreeNode teams = new DefaultMutableTreeNode("Team" + " " + team.getTeamID() + " " + "\t(" + getStudenten(team).size() + "/" + veranstaltung.getMaxTeilnehmer() + ")");
				gruppen.add(teams);
				for (Student student: getStudenten(team)) {
					DefaultMutableTreeNode studenten = new DefaultMutableTreeNode(student.getVorname()+ " " + student.getNachname());
					teams.add(studenten);
				}
			}
		}
		JTree tree = new JTree(root);
		tsp.setViewportView(tree);
		return tree;
	}

	/**@author Diana
	 * Erstellt die GruppenID bestehend aus den letzten zwei Zahlen des Jahres und einem Laufindex
	 * @param veranstaltung
	 * @return
	 */
	public int createGruppenID(Veranstaltung veranstaltung){
		//TODO: Prüfen ob GruppenID bereits vergeben ist

		int gruppenanzahl = getGruppen(veranstaltung).size()+1;

		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int year = cal.get(Calendar.YEAR) % 100;
		String gruppenID = "" + year + gruppenanzahl;
		return Integer.parseInt(gruppenID);
	}

	/**@author Diana
	 * Erstellt die TeamID bestehend aus der GruppenID und einem Laufindex
	 * @param gruppe
	 * @return
	 */
	public int createTeamID(Gruppe gruppe){
		//TODO: Prüfen ob TeamID bereits vergeben ist
		int teamanzahl = getTeams(gruppe).size()+1;
		String teamID = "" + gruppe.getGruppenID() + teamanzahl;
		return Integer.parseInt(teamID);
	}

	/**@author Diana
	 * Hilfsmethode zum Erstellen von Gruppen fuer GruppenTree in S-/DGruppenuebersicht und -bearbeiten
	 * @param gruppenid
	 * @param d
	 * @param veranstaltung
	 * @param einschreibungsfrist
	 * @param uhrzeit
	 * @param wochentag
	 * @param wochenrhytmus
	 */
	public void createGruppe(int gruppenid, Dozent d, String veranstaltung, Date einschreibungsfrist, Time uhrzeit, String wochentag, String wochenrhytmus){
		try {
			dbr.createGruppe(gruppenid, d.getEmail(), veranstaltung, einschreibungsfrist, uhrzeit, wochentag, wochenrhytmus);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Erstellen von Teams fuer GruppenTree in S-/DGruppenuebersicht und -bearbeiten
	 * @param gruppenid
	 * @param teamid
	 * @param veranstaltungsname
	 * @param thema
	 */
	public void createTeam(int gruppenid, int teamid, String veranstaltungsname, String thema){
		try {
			dbr.createTeam(teamid, gruppenid, veranstaltungsname, thema);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Setzt die maximale Anzahl der Teilnehmer pro Team in DB
	 * @param veranstaltungsname
	 * @param maximale_Teilnehmeranzahl_je_Team
	 */
	public void setMaximale_Teilnehmeranzahl_je_Team(String veranstaltungsname, int maximale_Teilnehmeranzahl_je_Team){
		try{
			dbr.updateVeranstaltungMaximale_Teilnehmeranzahl_je_Team(veranstaltungsname, maximale_Teilnehmeranzahl_je_Team);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

    /**@author Diana
     * Hilfsmethode zum Hinzufuegen eines Studenten in ein Team fuer GruppenTree in DGruppenbearbeiten
     * @return
     */
	public ArrayList<Student> getAlleStudenten(){
        try {
            return dbr.getAllStudenten();
        }  catch (DatabaseException e){
            System.out.println(e.getErrorMsg());
        }
        return null;
    }

	/**@author Diana
	 * Hilfsmethode zum Löschen von Gruppen fuer GruppenTree in DGruppenbearbeiten
	 * @param gruppenid
	 * @param veranstaltung
	 */
	public void deleteGruppe(int gruppenid, Veranstaltung veranstaltung){
		try {
			dbr.deleteGruppe(gruppenid, veranstaltung.getName());
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Löschen von Teams fuer GruppenTree in DGruppenbearbeiten
	 * @param gruppenid
	 * @param teamid
	 * @param veranstaltungsname
	 */
	public void deleteTeam(int gruppenid, int teamid, String veranstaltungsname){
		try {
			dbr.deleteTeam(teamid, gruppenid, veranstaltungsname);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Löschen von Studenten fuer GruppenTree in DGruppenbearbeiten
	 * @param student
	 */
	public void deleteStudent(Student student){
		try {
			dbr.deleteStudent(student);
		}  catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode fuer createLeistungsTree in S-/Dleistungsuebersicht
	 * @param student
	 * @param veranstaltung
	 * @return
	 */
	public ArrayList<Leistung> getLeistungsblock(Student student, Veranstaltung veranstaltung){
		try {
			return dbr.getLeistungsblock(student, veranstaltung);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode fuer createLeistungsTree in S-/Dleistungsuebersicht
	 * @param student
	 * @param leistungsblock
	 * @param veranstaltung
	 * @return
	 */
	public ArrayList<Unterblock> getUnterblock(Student student, Leistung leistungsblock, Veranstaltung veranstaltung){
		try {
			return dbr.getUnterblock(student, leistungsblock, veranstaltung);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode fuer createLeistungsTree in D-/SLeistungsuebersicht
	 * @param student
	 * @param leistungsblock
	 * @param unterblock
	 * @param veranstaltung
	 * @return
	 */
	public ArrayList<Aufgabe> getAufgabe(Student student, Leistung leistungsblock, Unterblock unterblock, Veranstaltung veranstaltung){
		try {
			return dbr.getEinzelleistung(student, leistungsblock, unterblock, veranstaltung);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode für createLeistungsTree
	 * @param veranstaltung
	 * @return Liste aller Studenten einer Veranstaltung
	 */
	public ArrayList<Student> getStudenten(Veranstaltung veranstaltung) {

		try{
			return dbr.getStudenten(veranstaltung);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Erstellt den Tree mit den Leistungen in DLeistungsuebersicht
	 * @param veranstaltung
	 * @param student
	 * @param tsp
	 * @return
	 */
	public JTree createLeistungsTreeAlle(Veranstaltung veranstaltung, Student student, JScrollPane tsp) {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(veranstaltung.getName());

		for (Leistung leistungsblock: getLeistungsblock(student, veranstaltung)) {
			DefaultMutableTreeNode leistungen = new DefaultMutableTreeNode(leistungsblock.getLbName());
			root.add(leistungen);
			for (Unterblock unterblock: getUnterblock(student, leistungsblock, veranstaltung)) {
				DefaultMutableTreeNode unterbloecke = new DefaultMutableTreeNode(unterblock.getUbName());
				leistungen.add(unterbloecke);
				for (Aufgabe aufgabe: getAufgabe(student, leistungsblock, unterblock, veranstaltung)) {
					DefaultMutableTreeNode aufgaben = new DefaultMutableTreeNode(aufgabe.getElName());
					unterbloecke.add(aufgaben);
				}
			}
		}
		JTree tree = new JTree(root);
		tsp.setViewportView(tree);
		return tree;
	}

	/**@author Diana
	 * Erstellt den Tree mit den Leistungen in DLeistungsuebersicht fuer einen Studenten
	 * @param veranstaltung
	 * @param student
	 * @param tsp
	 * @return
	 */
	public JTree createLeistungsTreeStudent(Veranstaltung veranstaltung, Student student, JScrollPane tsp) {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(student.getVorname() + " " + student.getNachname());

		for (Leistung leistungsblock: getLeistungsblock(student, veranstaltung)) {
			DefaultMutableTreeNode leistungen = new DefaultMutableTreeNode(leistungsblock.getLbName());
			root.add(leistungen);
			for (Unterblock unterblock: getUnterblock(student, leistungsblock, veranstaltung)) {
				DefaultMutableTreeNode unterbloecke = new DefaultMutableTreeNode(unterblock.getUbName());
				leistungen.add(unterbloecke);
				for (Aufgabe aufgabe: getAufgabe(student, leistungsblock, unterblock, veranstaltung)) {
					DefaultMutableTreeNode aufgaben = new DefaultMutableTreeNode(aufgabe.getElName() + "\t (" + aufgabe.getElPunkte()+ "/" + unterblock.getMaxPunkte() + ")");
					unterbloecke.add(aufgaben);
				}
			}
		}
		JTree tree = new JTree(root);
		tsp.setViewportView(tree);
		return tree;
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Leistungen in den LeistungsTree in DLeistungsuebersicht
	 * @param leistungsname
	 * @param veranstaltung
	 */
	public void createLeistung(Veranstaltung veranstaltung, String leistungsname){
		try {
			dbr.createLeistungEinzel(veranstaltung, leistungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Unterbloecken in den LeistungsTree in DLeistungsuebersicht
     * @param veranstaltung
     * @param leistungsname
     * @param unterblockname
	 */
	public void createUnterblock(Veranstaltung veranstaltung, String leistungsname, String unterblockname){
		try {
			dbr.createUnterblockEinzel(veranstaltung, leistungsname, unterblockname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Aufgaben in den LeistungsTree in DLeistungsuebersicht
     * @param veranstaltung
     * @param leistungsname
     * @param unterblockname
	 * @param aufgabename
	 * @param maxPunkte
	 */
	public void createAufgabe(Veranstaltung veranstaltung, String leistungsname, String unterblockname, String aufgabename, int maxPunkte){
		try {
			dbr.createAufgabeEinzel(veranstaltung, leistungsname, unterblockname, aufgabename, maxPunkte);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Leistungen in den LeistungsTree in DLeistungsuebersicht
	 * @param leistungsname
	 * @param veranstaltung
	 */
	public void deleteLeistung(Veranstaltung veranstaltung, String leistungsname){
		try {
			dbr.deleteLeistungEinzel(veranstaltung, leistungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Unterbloecken in den LeistungsTree in DLeistungsuebersicht
	 * @param veranstaltung
	 * @param leistungsname
	 * @param unterblockname
	 */
	public void deleteUnterblock(Veranstaltung veranstaltung, String leistungsname, String unterblockname){
		try {
			dbr.deleteUnterblockEinzel(veranstaltung, leistungsname, unterblockname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode zum Hinzufuegen von Aufgaben in den LeistungsTree in DLeistungsuebersicht
	 * @param veranstaltung
	 * @param leistungsname
	 * @param unterblockname
	 * @param aufgabename
	 */
	public void deleteAufgabe(Veranstaltung veranstaltung, String leistungsname, String unterblockname, String aufgabename){
		try {
			dbr.deleteAufgabeEinzel(veranstaltung, leistungsname, unterblockname, aufgabename);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

    /**@author Diana
     * Hilfsmethode zum Updaten der Einzelleistungen eines Studenten in DLeistungsuebersicht
     * @param matrikelnummer
     * @param veranstaltungsname
     * @param unterblockname
     * @param einzelleistungsname
     * @param leistungsblockname
     * @param punkte
     */
    public void updateEinzelleistungPunkte(int matrikelnummer, String veranstaltungsname, String unterblockname, String einzelleistungsname, String leistungsblockname, int punkte) {
        try {
            dbr.updateEinzelleistungPunkte(matrikelnummer, veranstaltungsname, unterblockname, einzelleistungsname, leistungsblockname, punkte);
        } catch (DatabaseException e) {
            System.out.println(e.getErrorMsg());
        }
    }

	//Methoden für Studentenansicht

	/**@author Diana
	 * Hilfsmethode zur Anzeige der Veranstaltungen eines Studenten in SVeranstaltungsuebersicht
	 * @param me
	 * @return
	 */
	public ArrayList<Veranstaltung> getVeranstaltungen(Student me){
		try {
			return dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			System.out.println(e.getErrorMsg());
		}
		return null;
	}

	/**@author Diana
	 * Hilfsmethode zur Anzeige aller Veranstaltungen in SAlleVeranstaltungen
	 * @return
	 */
	public ArrayList<Veranstaltung> getAlleV(){
		try {
			return dbr.getAllVeranstaltungen();
		}catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
			return null;
		}
	}

	/**@author Diana
	 * Hilfsmethode für Teambeitritt in SGruppenuebersicht
	 * @param matrikelnummer
	 * @param teamid
	 * @param gruppenid
	 * @param veranstaltungsname
	 */
	public void createGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname){
		try {
			dbr.createGehoertZu(matrikelnummer, teamid, gruppenid, veranstaltungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}

	/**@author Diana
	 * Hilfsmethode für Teamaustritt in SGruppenuebersicht
	 * @param matrikelnummer
	 * @param teamid
	 * @param gruppenid
	 * @param veranstaltungsname
	 */
	public void deleteGehoertZu(int matrikelnummer, int teamid, int gruppenid, String veranstaltungsname){
		try {
			dbr.deleteGehoertZu(matrikelnummer, teamid, gruppenid, veranstaltungsname);
		} catch (DatabaseException e){
			System.out.println(e.getErrorMsg());
		}
	}
	
	/**@author Oleg
	 * Erzeugt ein Fenster mit der Fehlermeldung, die als Parameter uebergeben wurde
	 * @param msg
	 * @return 
	 */
	public void createError(String msg) {
		ErrorDialog eD = new ErrorDialog(msg);
        return;
	}
}
