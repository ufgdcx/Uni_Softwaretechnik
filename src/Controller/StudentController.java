package Controller;

import java.util.ArrayList;

import javax.swing.*;

import Database.DatabaseException;
import GUI.*;
import Klassen.*;

/**@author Oleg
 * Steuert die Studentenansicht.
 */

public class StudentController extends MainController{
	private Student me;
	private ArrayList<Veranstaltung> alleV;
	private ArrayList<Veranstaltung> eingetrageneV;
	private ArrayList<Team> eingetrageneT;
	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		buildModel();
		mainFrame.setController(this);
		//changing the content of the main window to the "frontpage" for students
		//mainFrame.setContent(new SVeranstaltungsuebersicht(me, this.getAlleV(), this.getVeranstaltungen(me), 0, 1));
		m.setContent(new SVeranstaltungsuebersicht(m));
	}
	
	/**@author Oleg
	 * Erzeugt das Modell fuer das Model-View-Controller-Pattern.
	 */
	private void buildModel() {
		alleV = super.getAlleV();
		eingetrageneV = super.getVeranstaltungen(me);
		
		eingetrageneT = new ArrayList<Team>();
		for(Veranstaltung v : eingetrageneV) {
			try {
				ArrayList<Gruppe> gruppen = dbr.getGruppen(v);
				for(Gruppe g : gruppen) {
					Team t = dbr.getTeam(me, g);
					if(t != null) {
						eingetrageneT.add(t);
					}
				}
			} catch (DatabaseException e) {
				System.out.println(e.getErrorMsg());
			}
		}
		System.out.println(eingetrageneT);
	}
	
	/**@author Oleg
	 * erzeugt den Baum fuer die Leistungsansicht
	 * diese Funktion leitet nur weiter an MainController.createLeistungsTree()
	 * (spart den Studenten als Parameter)
	 */
	public JTree createLeistungsTree(Veranstaltung v, JScrollPane tsp) {
		return super.createLeistungsTree(v, me, tsp);
	}
	
	/**@author Oleg
	 * Gibt den derzeitigen Nutzer zurueck.
	 * In diesem Fall einen Studenten.
	 */
	public Student getSubject() {
		return me;
	}
	
	/**@author Oleg
	 * Gibt eine Liste von allen Veranstaltungen zurueck.
	 */
	public ArrayList<Veranstaltung> getAlleV(){
		return alleV;
	}
	
	/**@author Oleg
	 * Gibt eine Liste von den Veranstaltungen zurueck, in denen der Nutzer eingetrage ist.
	 */
	public ArrayList<Veranstaltung> getVeranstaltungen(){
		return eingetrageneV;
	}
	
	/**@author Oleg
	 * Regelt das Eintragen des Studenten in ein Team.
	 */
	public void teamEintragen(String[] slc) {
		super.createGehoertZu(me.getMatrikelnr(), Integer.parseInt(slc[2]), Integer.parseInt(slc[1]), slc[0]);
	}
	
	/**@author Oleg
	 * Regelt das Austragen des Studenten aus einem Team.
	 */
	public void teamAustragen(String[] slc) {
		for(Team t : eingetrageneT) {
			if(t.getTeamID() == Integer.parseInt(slc[2])) {
				eingetrageneT.remove(t);
				super.deleteGehoertZu(me.getMatrikelnr(), Integer.parseInt(slc[2]), Integer.parseInt(slc[1]), slc[0]);
			}
		}
	}
	
	/**@author Oleg
	 * Regelt das Eintragen des Studenten in eine Veranstaltung.
	 */
	public void eintragen(Veranstaltung v) {
		eingetrageneV.add(v);
		//Man kann nur in einer Veranstaltung sein, wenn man auch einem Team beitritt.
		//Deswegen wird gleich die Gruppenuebersicht aufgerufen, damit der Nutzer sich in ein Team eintraegt
		FrameContent c = new SGruppenuebersicht(mainFrame,v);
		//FrameContent updaten
        mainFrame.setContent(c);
	}
	
	/**@author Oleg
	 * Regelt das Austragen des Studenten aus einer Veranstaltung.
	 * (Und somit auch aus dem dazugehörigen Team)
	 */
	public void austragen(Veranstaltung v) {
		//System.out.println("Removing: "+ v + " at index: " + eingetrageneV.indexOf(v));
		eingetrageneV.remove(v);
		//TODO: Aus Team austragen
	}
}
