package Controller;
import java.util.ArrayList;

import Database.*;
import GUI.*;
import Klassen.*;

public class DozentController extends MainController{
	private Dozent me;
	private ArrayList<Veranstaltung> veranstaltungen;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Team> teams;
	protected DBrequest dbr = new DBrequest();
	private ArrayList<String> vNameD = new ArrayList<String>();

	
	public DozentController(GUIMain m,Dozent d) {
		super(m);
		me = d;
		//buildModel();
		//changing the content of the main window to the "frontpage" for lecturers
		mainFrame.setContent(new DVeranstaltungsuebersicht(buildModel()));
	}

	public ArrayList<String> buildModel(){
		try {
			veranstaltungen = dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Veranstaltung v: veranstaltungen){
			//für Funktionastest
		    System.out.println(v.getName());
			vNameD.add(v.getName());
		}
		//für Funktionstest
		System.out.println(vNameD);
		return vNameD;
	}


}
