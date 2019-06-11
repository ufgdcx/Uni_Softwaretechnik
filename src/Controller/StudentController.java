package Controller;
import Database.DBrequest;
import GUI.*;
import Klassen.*;

import java.util.ArrayList;


/**
 * Steuert die Studentenansicht.
 * @author Oleg
 */

public class StudentController extends MainController{
	private Student me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	protected DBrequest dbr = new DBrequest();
	private ArrayList<String> vNameS = new ArrayList<String>();

	
	public StudentController(GUIMain m,Student s) {
		super(m);
		me = s;
		//changing the content of the main window to the "frontpage" for students
		mainFrame.setContent(new SVeranstaltungsuebersicht(this.getAlleV(), this.getVeranstaltungen(me), 0));
	}
}
