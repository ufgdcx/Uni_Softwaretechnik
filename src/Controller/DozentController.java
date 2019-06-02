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
	ArrayList<String> vName = new ArrayList<String>();

	
	public DozentController(GUIMain m,Dozent d) {
		super(m);
		me = d;
		buildModel();
		//changing the content of the main window to the "frontpage" for lecturers
		mainFrame.setContent(new DVeranstaltungsuebersicht());
	}

	private ArrayList<String> buildModel(){
		try {
			veranstaltungen = dbr.getVeranstaltungen(me);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Veranstaltung v: veranstaltungen){
			System.out.println(v.getName());
			vName.add(v.getName());
		}
		System.out.println(vName);
		return vName;
	}
}
