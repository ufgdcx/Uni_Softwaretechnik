package Controller;
import Database.DBrequest;
import GUI.DVeranstaltungsuebersicht;
import GUI.GUIMain;
import Klassen.Dozent;
import Klassen.Gruppe;
import Klassen.Team;
import Klassen.Veranstaltung;

import java.util.ArrayList;

/**
 * Steuert die Dozentenansicht.
 * @author Oleg
 */

public class DozentController extends MainController{
	private Dozent me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	protected DBrequest dbr = new DBrequest();

	
	public DozentController(GUIMain m,Dozent d) {
		super(m);
		me = d;
		//changing the content of the main window to the "frontpage" for lecturers
		mainFrame.setContent(new DVeranstaltungsuebersicht(this.getVeranstaltungen(me), 0));
	}

	
}
