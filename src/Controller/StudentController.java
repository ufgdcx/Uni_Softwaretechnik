package Controller;
import Database.DBrequest;
import GUI.GUIMain;
import GUI.SVeranstaltungsuebersicht;
import Klassen.Gruppe;
import Klassen.Student;
import Klassen.Team;
import Klassen.Veranstaltung;

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
		buildModel();
		//changing the content of the main window to the "frontpage" for students
		mainFrame.setContent(new SVeranstaltungsuebersicht());
	}

	public void buildModel(){
		veranstaltungen = this.getVeranstaltungen(me);

		for (Veranstaltung v: veranstaltungen){
			//für Funktionstest
			System.out.println(v.getName());
			vNameS.add(v.getName());
		}

		//für Funktionstest
		System.out.println(vNameS);
		return;
	}
}
