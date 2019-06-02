package Controller;
import java.util.ArrayList;

import Database.DBrequest;
import Database.DatabaseException;
import GUI.*;
import Klassen.*;

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

	public ArrayList<String> buildModel(){
		try {
			veranstaltungen = dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Veranstaltung v: veranstaltungen){

			//für Funktionstest
			System.out.println(v.getName());
			vNameS.add(v.getName());
		}

		//für Funktionstest
		System.out.println(vNameS);
		return vNameS;
	}
}
